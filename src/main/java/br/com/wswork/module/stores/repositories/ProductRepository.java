package br.com.wswork.module.stores.repositories;

import br.com.wswork.module.stores.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Collection<Product> findAllByStoreId(@Param("storeId") final Long storeId);

    Collection<Product> findAllByStoreIdAndBrandIgnoreCase(@Param("storeId") final Long storeId, @Param("brand") final String brand);
}
