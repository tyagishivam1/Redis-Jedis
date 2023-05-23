package com.Redis.Redis.service;

import java.util.Map;
import com.Redis.Redis.model.Employee;
import com.Redis.Redis.repository.Employeerepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements Employeerepo {

    private final String EMPLOYEE_CACHE = "EMPLOYEE";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    private HashOperations<String, String, Employee> hashOperations;

    @PostConstruct
    private void intializeHashOperations() {
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(final Employee employee) {
        hashOperations.put(EMPLOYEE_CACHE, employee.getId(), employee);
    }
    @Override
    public Employee findById(final String id) {
        return (Employee) hashOperations.get(EMPLOYEE_CACHE, id);
    }
    @Override
    public Map<String, Employee> findAll() {
        return hashOperations.entries(EMPLOYEE_CACHE);
    }
    @Override
    public void delete(String id) {
        hashOperations.delete(EMPLOYEE_CACHE, id);
    }
}