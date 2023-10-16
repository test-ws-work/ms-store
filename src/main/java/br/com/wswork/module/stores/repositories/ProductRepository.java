package br.com.wswork.module.stores.repositories;

import br.com.wswork.module.stores.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByStoreId(@Param("storeId") final Long storeId, Pageable pageable);

    List<Product> findAllByStoreIdAndBrandIgnoreCase(@Param("storeId") final Long storeId, @Param("brand") final String brand, Pageable pageable);
}
