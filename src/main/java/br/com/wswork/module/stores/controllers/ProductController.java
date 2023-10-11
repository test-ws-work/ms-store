package br.com.wswork.module.stores.controllers;

import br.com.wswork.module.stores.dtos.requests.CreateProductDtoRequest;
import br.com.wswork.module.stores.dtos.responses.ProductDtoResponse;
import br.com.wswork.module.stores.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
