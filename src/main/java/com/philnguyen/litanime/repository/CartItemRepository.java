package com.philnguyen.litanime.repository;

import com.philnguyen.litanime.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {
}
