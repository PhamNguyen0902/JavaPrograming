package com.example.lab6.anno;

import com.example.lab6.model.Address;
import com.example.lab6.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Address address() {
        return new Address("Hue", "Phu Hoi", "Vietnam");
    }

    @Bean
    public Employee employee(Address address) {
        return new Employee(3, "Le Thi B", address); // constructor injection with @Bean method parameter
    }
}