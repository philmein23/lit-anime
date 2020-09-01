package com.philnguyen.litanime.repository;

import com.philnguyen.litanime.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "select * from customers u WHERE u.user_name ILIKE ?", nativeQuery = true)
    Optional<Customer> findByUsername(String username);

}
