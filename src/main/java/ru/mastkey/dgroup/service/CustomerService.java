//package ru.mastkey.dgroup.service;
//
//import lombok.RequiredArgsConstructor;
//import org.hibernate.service.spi.ServiceException;
//import org.springframework.core.convert.ConversionService;
//import org.springframework.stereotype.Service;
//import ru.mastkey.dgroup.entity.Customer;
//import ru.mastkey.dgroup.model.request.CustomerV1Request;
//import ru.mastkey.dgroup.model.response.CustomerV1Response;
//import ru.mastkey.dgroup.repository.CustomerRepository;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class CustomerService {
//    private final ConversionService conversionService;
//    private final UserService userService;
//
//    private final CustomerRepository customerRepository;
//
//    public List<CustomerV1Response> getCustomers() {
//        return customerRepository.findAll()
//                .stream()
//                .map(customer -> conversionService.convert(customer, CustomerV1Response.class))
//                .toList();
//    }
//
//    public CustomerV1Response getCustomer() {
//        return customerRepository.findByEmail(userService.getCurrentUsername())
//                .map(customer -> conversionService.convert(customer, CustomerV1Response.class))
//                .orElseGet(null);
//    }
//
//    public CustomerV1Response patchCustomer(CustomerV1Request customerV1Request) {
//        var customerToPost = conversionService.convert(customerV1Request, Customer.class);
//        userService.getCurrentUsername();
//        var customer = customerRepository.findByEmail(userService.getCurrentUsername())
//                .orElseThrow(() -> new ServiceException("User not found"));
//        customer.setInn(customerToPost.getInn());
//        customer.setPhone(customerToPost.getPhone());
//        return conversionService.convert(customerRepository.save(customer), CustomerV1Response.class);
//    }
//}
