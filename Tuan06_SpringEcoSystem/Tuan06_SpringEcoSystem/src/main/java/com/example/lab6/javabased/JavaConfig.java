package com.example.lab6.javabased;

import com.example.lab6.model.Address;
import com.example.lab6.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {
    @Bean(name = "addressJava")
    public Address addressJava() {
        Address a = new Address();
        a.setCity("Buon Ma Thuot");
        a.setState("Dak Lak");
        a.setCountry("Vietnam");
        return a;
    }

    @Bean(name = "employeeJava")
    public Employee employeeJava(Address addressJava) {
        Employee e = new Employee();
        e.setId(4);
        e.setName("Tran Van C");
        e.setAddress(addressJava); // setter injection
        return e;
    }
}