package com.philnguyen.litanime.repository;

import com.philnguyen.litanime.model.ShoppingCart;
import org.springframework.data.repository.CrudRepository;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long> {
}
