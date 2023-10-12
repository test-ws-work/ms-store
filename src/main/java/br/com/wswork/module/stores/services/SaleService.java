package br.com.wswork.module.stores.services;

import br.com.wswork.module.stores.configs.BusinessException;
import br.com.wswork.module.stores.dtos.requests.SaleDtoRequest;
import br.com.wswork.module.stores.dtos.requests.SaleItemDtoRequest;
import br.com.wswork.module.stores.dtos.responses.SaleDtoResponse;
import br.com.wswork.module.stores.entities.Product;
import br.com.wswork.module.stores.entities.Sale;
import br.com.wswork.module.stores.entities.SaleProduct;
import br.com.wswork.module.stores.entities.Store;
import br.com.wswork.module.stores.repositories.ProductRepository;
import br.com.wswork.module.stores.repositories.SaleProductRepository;
import br.com.wswork.module.stores.repositories.SaleRepository;
import br.com.wswork.module.stores.repositories.StoreRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SaleService {

    private static final Logger LOGGER = LogManager.getLogger(StoreService.class.getName());

    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final StoreRepository storeRepository;
    private final SaleProductRepository saleProductRepository;

    public SaleService(SaleRepository saleRepository, ProductRepository productRepository, StoreRepository storeRepository, SaleProductRepository saleProductRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.storeRepository = storeRepository;
        this.saleProductRepository = saleProductRepository;
    }

    public ResponseEntity<SaleDtoResponse> create(SaleDtoRequest request) {
        Store store = findStoreById(request.getStoreId());

        Collection<Long> productIds = request.getItems().stream()
                .map(item -> item.getProductId())
                .collect(Collectors.toList());

        Collection<Product> products = findProductsByIds(productIds);

        Sale sale = createSale(store, request);

        Sale savedSale = saleRepository.save(sale);

        Collection<SaleProduct> saleProducts = getSaleProducts(request, products, savedSale);

        BigDecimal totalPrice = updateSaleTotalPrice(savedSale, saleProducts);

        savedSale.setTotalPrice(totalPrice);

        saleProductRepository.saveAll(saleProducts);

        removeStock(saleProducts);

        Sale saleResponse = saleRepository.save(savedSale);

        SaleDtoResponse response = mapSaleToResponse(saleResponse, store, saleProducts);
        return ResponseEntity.ok(response);
    }

    private void removeStock(Collection<SaleProduct> saleProducts) {
        for (SaleProduct saleProduct : saleProducts) {
            Product product = saleProduct.getProduct();
            int quantity = saleProduct.getQuantity();
            int newStock = product.getStock() - quantity;
            product.setStock(newStock);
            productRepository.save(product);
        }
    }


    private Collection<SaleProduct> getSaleProducts(SaleDtoRequest request, Collection<Product> products, Sale sale) {
        Collection<SaleProduct> saleProducts = new ArrayList<>();
        BigDecimal totalPrice = BigDecimal.ZERO;

        for (SaleItemDtoRequest saleItem : request.getItems()) {
            Long productId = saleItem.getProductId();
            Product product = products.stream()
                    .filter(p -> p.getId().equals(productId))
                    .findFirst()
                    .orElse(null);

            if (product != null) {
                SaleProduct saleProduct = new SaleProduct(sale, product, saleItem.getQuantity(), saleItem.getProductPrice());
                totalPrice = totalPrice.add(saleProduct.getProductPrice().multiply(BigDecimal.valueOf(saleItem.getQuantity())));
                saleProducts.add(saleProduct);
            }
        }

        return saleProducts;
    }

    private Store findStoreById(Long storeId) {
        LOGGER.info("Searching store...");
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new BusinessException(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.getReasonPhrase(), "Store not found."));
        LOGGER.info("Found.");
        return store;
    }

    private Collection<Product> findProductsByIds(Collection<Long> productIds) {
        LOGGER.info("Searching products...");
        Collection<Product> products = productRepository.findAllById(productIds);
        LOGGER.info("Found.");
        return products;
    }

    private Sale createSale(Store store, SaleDtoRequest request) {
        Sale sale = new Sale();
        sale.setSaleDate(LocalDateTime.now());
        sale.setCostumerId(request.getCostumerId());
        sale.setTax(request.getTax());
        sale.setStore(store);
        return sale;
    }

    private BigDecimal updateSaleTotalPrice(Sale sale, Collection<SaleProduct> saleProducts) {
        BigDecimal totalPrice = saleProducts.stream()
                .map(saleProduct -> saleProduct.getProductPrice().multiply(BigDecimal.valueOf(saleProduct.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        sale.setSaleProducts(saleProducts);
        return totalPrice;
    }

    private SaleDtoResponse mapSaleToResponse(Sale saleResponse, Store store, Collection<SaleProduct> saleProducts) {
        SaleDtoResponse response = new SaleDtoResponse();
        response.setCustumerId(saleResponse.getCostumerId());
        response.setProducts(saleProducts.stream().map(saleProduct -> saleProduct.getProduct().getName()).collect(Collectors.toList()));
        response.setTax(saleResponse.getTax());
        response.setSaleDate(saleResponse.getSaleDate());
        response.setStore(store.getName());
        response.setTotalPrice(saleResponse.getTotalPrice());
        return response;
    }
}