package com.philnguyen.litanime.repository;

import com.philnguyen.litanime.model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
}
