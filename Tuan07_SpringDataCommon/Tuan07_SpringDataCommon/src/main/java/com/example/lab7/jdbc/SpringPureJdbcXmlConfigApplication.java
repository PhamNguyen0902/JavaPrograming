package com.example.lab7.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class SpringPureJdbcXmlConfigApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("databaseConfig.xml");
        JdbcTemplate jdbc = ctx.getBean(JdbcTemplate.class);

        // CREATE TABLE if not exists (id INT PRIMARY KEY, name VARCHAR, city VARCHAR)
        jdbc.execute("CREATE TABLE IF NOT EXISTS employees (id INT PRIMARY KEY, name VARCHAR(100), city VARCHAR(100))");

        // INSERT demo rows (idempotent)
        jdbc.update("INSERT INTO employees (id, name, city) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name=VALUES(name), city=VALUES(city)",
                1, "Pham Minh Tien", "Dak Lak");
        jdbc.update("INSERT INTO employees (id, name, city) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name=VALUES(name), city=VALUES(city)",
                2, "Nguyen Van A", "HCM");

        List<Employee> list = jdbc.query("SELECT id, name, city FROM employees",
                new BeanPropertyRowMapper<>(Employee.class));
        list.forEach(System.out::println);
    }
}