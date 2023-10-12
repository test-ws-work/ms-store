package br.com.wswork.module.stores.controllers;

import br.com.wswork.module.stores.dtos.requests.ProductDtoRequest;
import br.com.wswork.module.stores.dtos.responses.ProductDtoResponse;
import br.com.wswork.module.stores.services.ProductService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("Create a new product")
    @PostMapping(path = "{userId}")
    public ResponseEntity<ProductDtoResponse> create(
            @RequestBody(required = true) final ProductDtoRequest request,
            @PathVariable(name = "userId") final Long userId)  {

        return productService.create(request, userId);
    }

    @ApiOperation("Search product by id")
    @GetMapping(path = "by-product/{productId}")
    public ResponseEntity<ProductDtoResponse> findProductById(
            @PathVariable(name = "productId") final Long productId) {

        return productService.findProductById(productId);
    }

    @ApiOperation("Search all products by store")
    @GetMapping(path = "by-store/{storeId}")
    public ResponseEntity<Collection<ProductDtoResponse>> searchAllProductsByStore(
            @PathVariable(name = "storeId") final Long storeId,
            @RequestParam(name = "page", required = true,  defaultValue = "1") final Integer page,
            @RequestParam(name = "size", required = true,defaultValue = "10") final Integer size) {

        return productService.searchAllProductsByStore(storeId, page, size);
    }

    @ApiOperation("Search all products by store and brand")
    @GetMapping(path = "{storeId}/by-brand")
    public ResponseEntity<Collection<ProductDtoResponse>> searchAllProductsByBrand(
            @PathVariable(name = "storeId", required = true) final Long storeId,
            @RequestParam(name = "brand", required = true) final String brand,
            @RequestParam(name = "page", required = true,  defaultValue = "1") final Integer page,
            @RequestParam(name = "size", required = true,defaultValue = "10") final Integer size){

        return productService.searchAllProductsByBrand(storeId, brand, page, size);
    }

    @ApiOperation("Update product")
    @PatchMapping("{productId}")
    public ResponseEntity<ProductDtoResponse> update(
            @PathVariable(name = "productId", required = true) final Long productId,
            @RequestBody(required = true) final ProductDtoRequest request) {

        return productService.update(productId, request);
    }

    @ApiOperation("Delete product")
    @DeleteMapping("{productId}")
    public ResponseEntity<?> delete(
            @PathVariable(name = "productId", required = true) final Long productId) {
        productService.delete(productId);
        return ResponseEntity.noContent().build();
    }
}
