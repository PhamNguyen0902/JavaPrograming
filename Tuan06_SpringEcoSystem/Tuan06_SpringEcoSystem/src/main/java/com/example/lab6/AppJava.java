package com.example.lab6;

import com.example.lab6.javabased.JavaConfig;
import com.example.lab6.model.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppJava {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class)) {
            Employee e = (Employee) ctx.getBean("employeeJava");
            System.out.println(e);
        }
    }
}