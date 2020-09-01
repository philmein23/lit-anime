package com.philnguyen.litanime.security;

import com.philnguyen.litanime.model.MyUserDetails;
import com.philnguyen.litanime.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private final CustomerRepository customerRepository;

    public UserRepositoryUserDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return customerRepository
                .findByUsername(username)
                .map(user -> {
                    MyUserDetails userDetails = new MyUserDetails();

                    userDetails.setUsername(user.getUserName());
                    userDetails.setPassword(user.getPassword());

                    return userDetails;
                })
                .orElseThrow(() -> new UsernameNotFoundException("Usernanme not found"));
    }

}
