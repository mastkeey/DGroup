package ru.mastkey.dgroup.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mastkey.dgroup.entity.Customer;
import ru.mastkey.dgroup.repository.CustomerRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() {
        customerRepository.save(new Customer()
                .setEmail("test")
                .setPassword(passwordEncoder.encode("test")));
    }

    private final CustomerRepository customerRepository;

    public Customer create(Customer customer) {
        customer.setId(UUID.randomUUID());
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        return customerRepository.save(customer);
    }

}
