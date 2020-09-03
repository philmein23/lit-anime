package com.philnguyen.litanime.web;

import com.philnguyen.litanime.dto.CustomerDto;
import com.philnguyen.litanime.model.Customer;
import com.philnguyen.litanime.repository.CustomerRepository;
import com.philnguyen.litanime.service.RegistrationService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public Customer processRegistration(@RequestBody CustomerDto newCustomerDto) {
        return registrationService.registerNewCustomer(newCustomerDto);
    }
}
