package com.example.reactiveapi.dao;

import com.example.reactiveapi.model.Customer;
import com.example.reactiveapi.service.CustomerService;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDAO {
    private static void sleepExecution(int j){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Customer> getAllCustomers(){
        return IntStream.rangeClosed(1, 10)
                .peek(CustomerDAO::sleepExecution)
                .peek(i-> System.out.println("Processing of "+i))
                .mapToObj(i-> new Customer(i, "Customer "+i))
                .collect(Collectors.toList());
    }


    public Flux<Customer> getAllCustomersSteam(){
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("Processing of "+i))
                .map(i-> new Customer(i, "Customer "+i));
    }
}
