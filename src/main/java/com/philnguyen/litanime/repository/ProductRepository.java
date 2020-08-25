package com.philnguyen.litanime.repository;

import com.philnguyen.litanime.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT * from PRODUCTS p WHERE p.product_type ILIKE ?", nativeQuery = true)
    List<Product> findProductByType(String productType);
}
