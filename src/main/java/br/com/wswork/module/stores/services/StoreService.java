package br.com.wswork.module.stores.services;

import br.com.wswork.module.stores.dtos.requests.CreateStoreDtoRequest;
import br.com.wswork.module.stores.dtos.responses.CreateStoreDtoResponse;
import br.com.wswork.module.stores.entities.Store;
import br.com.wswork.module.stores.repositories.StoreRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class StoreService {

    private static final Logger LOGGER = LogManager.getLogger(StoreService.class.getName());
    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public ResponseEntity<CreateStoreDtoResponse> create(@Valid final CreateStoreDtoRequest dto) {

        Store store = new Store(dto.getName(),
                  dto.getAddress(),
                  dto.getNumber(),
                  dto.getComplement(),
                  dto.getNeighbor(),
                  dto.getState(),
                  dto.getCity(),
                  dto.getCountry(),
                  dto.getPersonId());

        LOGGER.info("Saving new Store in  database...");
        Store newStore = storeRepository.save(store);
        LOGGER.info("Saved.");

        CreateStoreDtoResponse storeResponse = storeResponse(newStore);

        return ResponseEntity.ok(storeResponse);
    }

    private static CreateStoreDtoResponse storeResponse(Store newStore) {
        CreateStoreDtoResponse storeResponse = new CreateStoreDtoResponse();
        storeResponse.setAddress(newStore.getAddress());
        storeResponse.setCity(newStore.getCity());
        storeResponse.setComplement(newStore.getComplement());
        storeResponse.setCountry(newStore.getCountry());
        storeResponse.setId(newStore.getId());
        storeResponse.setName(newStore.getName());
        storeResponse.setNeighbor(newStore.getNeighbor());
        storeResponse.setNumber(newStore.getNumber());
        storeResponse.setPersonId(newStore.getUserId());
        storeResponse.setState(newStore.getState());
        return storeResponse;
    }
}
