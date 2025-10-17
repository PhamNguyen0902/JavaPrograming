package com.example.lab7.jdbc;

import com.example.lab7.jdbc.config.JdbcJavaConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringPureJdbcAnnotationApplication {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JdbcJavaConfig.class)) {
            JdbcTemplate jdbc = ctx.getBean(JdbcTemplate.class);
            jdbc.execute("CREATE TABLE IF NOT EXISTS employees (id INT PRIMARY KEY, name VARCHAR(100), city VARCHAR(100))");
            jdbc.update("INSERT INTO employees (id, name, city) VALUES (?,?,?) ON DUPLICATE KEY UPDATE name=VALUES(name), city=VALUES(city)",
                    3, "Le Thi B", "Hue");
            jdbc.query("SELECT * FROM employees", new BeanPropertyRowMapper<>(Employee.class)).forEach(System.out::println);
        }
    }
}