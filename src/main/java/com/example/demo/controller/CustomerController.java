package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable Long id){
        return customerService.getById(id);
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) throws URISyntaxException {
        Customer savedCustomer = customerService.createCustomer(customer);
        return ResponseEntity.created(new URI("/customers/" + savedCustomer.getId())).body(savedCustomer);
    }


}
