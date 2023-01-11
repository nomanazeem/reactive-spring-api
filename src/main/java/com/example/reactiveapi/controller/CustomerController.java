package com.example.reactiveapi.controller;

import com.example.reactiveapi.model.Customer;
import com.example.reactiveapi.model.User;
import com.example.reactiveapi.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @GetMapping("/hello")
    public String hello(){
        return "hello from reactive web api...";
    }

    @Autowired
    private CustomerService customerService;

    @GetMapping("/interactive")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping(value="/streams", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream(){
        return customerService.getAllCustomersStream();
    }

}
