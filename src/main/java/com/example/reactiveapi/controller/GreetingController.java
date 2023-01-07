package com.example.reactiveapi.controller;

import com.example.reactiveapi.controller.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @GetMapping("/hello")
    public String hello(){
        return "hello from reactive web api...";
    }

    @GetMapping(value = "/emitUser", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<User> emitUser(){
        return Flux.interval(Duration.ofSeconds(1))
                .log()
                .map(val -> User.builder().id(val).name("Test User "+val ).build());
    }
}
