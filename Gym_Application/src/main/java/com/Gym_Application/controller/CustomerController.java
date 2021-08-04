package com.Gym_Application.controller;


import com.Gym_Application.Repository.CustomerRepository;
import com.Gym_Application.Repository.DietsRepository;
import com.Gym_Application.Service.CustomerService;
import com.Gym_Application.Service.DietsService;
import com.Gym_Application.entity.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RestController
@RequestMapping("/")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerRepository customerRepository;


    public CustomerController(CustomerService customerService, CustomerRepository customerRepository, DietsRepository dietsRepository, DietsService dietsService) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;

    }

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @ModelAttribute
    public Customer listCustomers(@ModelAttribute("customer") Customer customer) {
        customerService.listAllCustomers();
        System.out.println("Returning customer:");
        return customer;
    }


    @RequestMapping("customer/add")
    public Customer newCustomer(@Valid Customer customer) {
        return customerService.saveCustomer(customer);


    }


    @PostMapping("customer/update/{id}")
    public List<Customer> updateCustomer(@PathVariable("id") long id, @Valid Customer customer) {

        customerRepository.save(customer);
        return customerRepository.findAll();

    }

    @GetMapping("customer/delete/{id}")
    public List<Customer> deleteCustomer(@PathVariable("id") Long id) {
        Customer customer = (Customer) customerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student Id:" + id));
        customerRepository.delete(customer);
        return customerRepository.findAll();

    }

}
