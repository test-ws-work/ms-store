package br.com.wswork.module.stores.controllers;

import br.com.wswork.module.stores.dtos.requests.CreateStoreDtoRequest;
import br.com.wswork.module.stores.dtos.responses.StoreDtoResponse;
import br.com.wswork.module.stores.services.StoreService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller()
@RequestMapping(path = "api/v1/stores", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PostMapping("")
    public ResponseEntity<StoreDtoResponse> create(
            @RequestBody(required = true) final CreateStoreDtoRequest request) {

        return storeService.create(request);
    }

    @GetMapping("by-user/{userId}")
    public ResponseEntity<Collection<StoreDtoResponse>> find(
            @PathVariable(name = "userId", required = true) final Long userId) {

        return storeService.find(userId);
    }

    @GetMapping("by-store/{storeId}")
    public ResponseEntity<StoreDtoResponse> findById(
            @PathVariable(name = "storeId", required = true) final Long storeId,
            @RequestParam(name = "userId", required = true) final Long userId) {

        return storeService.findById(storeId, userId);
    }

    @DeleteMapping("")
    public ResponseEntity<?> delete(
            @RequestParam(name = "storeId", required = true) final Long storeId) {
        storeService.delete(storeId);
        return ResponseEntity.noContent().build();
    }
}
