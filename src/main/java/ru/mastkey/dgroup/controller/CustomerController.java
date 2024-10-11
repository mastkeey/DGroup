package ru.mastkey.dgroup.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.mastkey.dgroup.entity.Customer;
import ru.mastkey.dgroup.model.request.CustomerV1Request;
import ru.mastkey.dgroup.model.response.CustomerV1Response;
import ru.mastkey.dgroup.service.CustomerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/reg")
    public ResponseEntity<Customer> register(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.create(customer));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CustomerV1Response>> getCustomers(){
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/current")
    public ResponseEntity<CustomerV1Response> getCurrentCustomer(){
        return ResponseEntity.ok(customerService.getCustomer());
    }

    @PatchMapping("/current")
    public ResponseEntity<CustomerV1Response> patchCurrentCustomer(@RequestBody CustomerV1Request customerV1Request){
        return ResponseEntity.ok(customerService.patchCustomer(customerV1Request));
    }
}
