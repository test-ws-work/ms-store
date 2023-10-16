package br.com.wswork.module.stores.repositories;

import br.com.wswork.module.stores.constants.StoreStatusEnum;
import br.com.wswork.module.stores.entities.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long> {

    Collection<Store> findAllByUserIdAndStatus(@Param("userId") final Long userId, @Param("status") final StoreStatusEnum status);

    Optional<Store> findByIdAndUserIdAndStatus(@Param("id") final Long id, @Param("userId") final Long userId, @Param("status") final StoreStatusEnum status);
}
