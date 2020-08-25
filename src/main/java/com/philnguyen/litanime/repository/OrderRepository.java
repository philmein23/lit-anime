package com.philnguyen.litanime.repository;

import com.philnguyen.litanime.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityManager;


public interface OrderRepository extends CrudRepository<Order, Long> {
}
