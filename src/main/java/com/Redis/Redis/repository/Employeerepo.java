package com.Redis.Redis.repository;

import com.Redis.Redis.model.Employee;

import java.util.Map;

public interface Employeerepo {
    void save(Employee employee);

    Employee findById(String id);

    Map<String, Employee> findAll();

    void delete(String id);
}
