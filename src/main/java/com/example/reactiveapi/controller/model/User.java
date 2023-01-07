package com.example.reactiveapi.controller.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
public class User {
    public Long id;
    public String name;
}
