package br.com.wswork.module.stores.repositories;

import br.com.wswork.module.stores.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
