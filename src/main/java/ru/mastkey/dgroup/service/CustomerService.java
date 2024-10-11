package ru.mastkey.dgroup.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.ServiceException;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mastkey.dgroup.entity.Customer;
import ru.mastkey.dgroup.model.request.CustomerV1Request;
import ru.mastkey.dgroup.model.response.CustomerV1Response;
import ru.mastkey.dgroup.repository.CustomerRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final PasswordEncoder passwordEncoder;
    private final ConversionService conversionService;
    private final UserService userService;

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

    public List<CustomerV1Response> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> conversionService.convert(customer, CustomerV1Response.class))
                .toList();
    }

    public CustomerV1Response getCustomer() {
        return customerRepository.findByEmail(userService.getCurrentUsername())
                .map(customer -> conversionService.convert(customer, CustomerV1Response.class))
                .orElseGet(null);
    }

    public CustomerV1Response patchCustomer(CustomerV1Request customerV1Request) {
        var customerToPost = conversionService.convert(customerV1Request, Customer.class);
        userService.getCurrentUsername();
        var customer = customerRepository.findByEmail(userService.getCurrentUsername())
                .orElseThrow(() -> new ServiceException("User not found"));
        customer.setInn(customerToPost.getInn());
        customer.setPhone(customerToPost.getPhone());
        return conversionService.convert(customerRepository.save(customer), CustomerV1Response.class);
    }
}
