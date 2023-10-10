package br.com.wswork.module.stores.repositories;

import br.com.wswork.module.stores.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Collection<Store> findAllByUserId(@Param("userId") final Long userId);
}
