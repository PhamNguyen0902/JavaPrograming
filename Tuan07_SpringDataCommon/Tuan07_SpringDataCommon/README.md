# Tuần 07 – Spring Data Common (JDBC & JPA)

Bài làm gồm 2 phần chính theo yêu cầu:
1) **JDBC API**: cấu hình theo **XML** (`databaseConfig.xml`) và **Annotation/Java-based** (`JdbcJavaConfig`). Runner: `SpringPureJdbcXmlConfigApplication`, `SpringPureJdbcAnnotationApplication`.
2) **Spring Data JPA**: dự án Spring Boot với entity `EmployeeEntity`, `EmployeeRepository` chạy `CommandLineRunner` để CRUD demo.

> Lưu ý: bạn cần MariaDB đang chạy `employees` DB, tài khoản trong `application.properties` và `database.properties`.

## Cách chạy
```bash
mvn -q -DskipTests package
# JDBC (XML)
java -cp target/tuan07-spring-data-common-1.0.0.jar:$(mvn -q -Dexec.classpathScope=runtime -Dexec.executable=echo --non-recursive org.codehaus.mojo:exec-maven-plugin:3.5.0:classpath -Dexec.args='%classpath%') com.example.lab7.jdbc.SpringPureJdbcXmlConfigApplication
# JDBC (Annotation/Java)
java -cp target/tuan07-spring-data-common-1.0.0.jar:$(mvn -q -Dexec.classpathScope=runtime -Dexec.executable=echo --non-recursive org.codehaus.mojo:exec-maven-plugin:3.5.0:classpath -Dexec.args='%classpath%') com.example.lab7.jdbc.SpringPureJdbcAnnotationApplication
# JPA (Spring Boot)
java -jar target/tuan07-spring-data-common-1.0.0.jar
```