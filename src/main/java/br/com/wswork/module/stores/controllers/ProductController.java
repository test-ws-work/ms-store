package br.com.wswork.module.stores.controllers;

import br.com.wswork.module.stores.dtos.requests.CreateProductDtoRequest;
import br.com.wswork.module.stores.dtos.responses.ProductDtoResponse;
import br.com.wswork.module.stores.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/products", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(path = "{userId}")
    public ResponseEntity<ProductDtoResponse> create(
            @RequestBody(required = true) final CreateProductDtoRequest request,
            @PathVariable(name = "userId") final Long userId)  {

        return productService.create(request, userId);
    }

    @GetMapping(path = "by-product/{productId}")
    public ResponseEntity<ProductDtoResponse> findProductById(
            @PathVariable(name = "productId") final Long productId) {

        return productService.findProductById(productId);
    }

    @GetMapping(path = "by-store/{storeId}")
    public ResponseEntity<Collection<ProductDtoResponse>> searchAllProductsByStore(
            @PathVariable(name = "storeId") final Long storeId) {

        return productService.searchAllProductsByStore(storeId);
    }

    @GetMapping(path = "{storeId}/by-brand")
    public ResponseEntity<Collection<ProductDtoResponse>> searchAllProductsByBrand(
            @PathVariable(name = "storeId", required = true) final Long storeId,
            @RequestParam(name = "brand", required = true) final String brand){

        return productService.searchAllProductsByBrand(storeId, brand);
    }
}
