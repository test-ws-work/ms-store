package br.com.wswork.module.stores.controllers;

import br.com.wswork.module.stores.dtos.requests.SaleDtoRequest;
import br.com.wswork.module.stores.dtos.responses.SaleDtoResponse;
import br.com.wswork.module.stores.services.SaleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/sales", produces = MediaType.APPLICATION_JSON_VALUE)
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @ApiOperation("Create new sale")
    @PostMapping("")
    public ResponseEntity<SaleDtoResponse> create(
            @RequestBody(required = true) final SaleDtoRequest request) {

        return saleService.create(request);
    }
}
