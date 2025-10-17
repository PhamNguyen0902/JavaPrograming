package com.example.lab6;

import com.example.lab6.model.Employee;
import com.example.lab6.anno.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppAnno {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        Employee e = ctx.getBean(Employee.class);
        System.out.println(e);
    }
}