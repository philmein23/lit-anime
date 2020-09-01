package com.philnguyen.litanime.service;

import com.philnguyen.litanime.dto.CustomerDto;
import com.philnguyen.litanime.model.Customer;
import com.philnguyen.litanime.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final CustomerRepository customerRepository;

    public RegistrationService(PasswordEncoder passwordEncoder, CustomerRepository customerRepository) {
        this.passwordEncoder = passwordEncoder;
        this.customerRepository = customerRepository;
    }

    public Customer registerNewCustomer(CustomerDto newCustomerDto) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(newCustomerDto.getFirstName());
        newCustomer.setLastName(newCustomerDto.getLastName());
        newCustomer.setUserName(newCustomerDto.getUserName());
        newCustomer.setPassword(passwordEncoder.encode(newCustomerDto.getPassword()));
        newCustomer.setEmail(newCustomerDto.getEmail());

        return customerRepository.save(newCustomer);
    }
}
