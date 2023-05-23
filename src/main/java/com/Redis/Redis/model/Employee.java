package com.Redis.Redis.model;

import java.io.Serializable;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int age;
    private Double salary;
}