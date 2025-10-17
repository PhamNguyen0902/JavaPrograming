package com.example.lab6;

import com.example.lab6.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppXml {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        Employee e1 = (Employee) ctx.getBean("employeeCtor");
        Employee e2 = (Employee) ctx.getBean("employeeSetter");
        System.out.println(e1);
        System.out.println(e2);
    }
}