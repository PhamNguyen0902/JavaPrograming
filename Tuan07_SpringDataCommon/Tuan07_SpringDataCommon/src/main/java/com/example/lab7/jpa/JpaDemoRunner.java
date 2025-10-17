package com.example.lab7.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaDemoRunner {
    @Bean
    CommandLineRunner demo(EmployeeRepository repo) {
        return args -> {
            EmployeeEntity e = new EmployeeEntity();
            e.setId(10);
            e.setName("Pham Minh Tien");
            e.setCity("HCMC");
            repo.save(e);

            repo.findAll().forEach(emp -> System.out.println(emp.getId() + " - " + emp.getName() + " - " + emp.getCity()));
        };
    }
}