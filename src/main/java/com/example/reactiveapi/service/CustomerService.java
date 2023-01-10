package com.example.reactiveapi.service;

import com.example.reactiveapi.dao.CustomerDAO;
import com.example.reactiveapi.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> getAllCustomers(){
        return customerDAO.getAllCustomers();
    }

    public Flux<Customer> getAllCustomersStream(){
        return customerDAO.getAllCustomersSteam();
    }
}
