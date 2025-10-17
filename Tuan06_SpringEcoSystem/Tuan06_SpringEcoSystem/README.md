# Tuần 06 – Spring EcoSystem (IoC/DI)

Bài làm theo yêu cầu: **Spring IoC, DI, Spring Bean**, cấu hình theo **XML-based**, **Annotation-based**, **Java-based**. Chạy được 3 app runner: `AppXml`, `AppAnno`, `AppJava`.

## Cách chạy
```bash
mvn -q -DskipTests package
# XML
java -cp target/tuan06-spring-ecosystem-1.0.0.jar:$(mvn -q -Dexec.classpathScope=runtime -Dexec.executable=echo --non-recursive org.codehaus.mojo:exec-maven-plugin:3.5.0:classpath -Dexec.args='%classpath%') com.example.lab6.AppXml
# Annotation
java -cp target/tuan06-spring-ecosystem-1.0.0.jar:$(mvn -q -Dexec.classpathScope=runtime -Dexec.executable=echo --non-recursive org.codehaus.mojo:exec-maven-plugin:3.5.0:classpath -Dexec.args='%classpath%') com.example.lab6.AppAnno
# Java-based
java -cp target/tuan06-spring-ecosystem-1.0.0.jar:$(mvn -q -Dexec.classpathScope=runtime -Dexec.executable=echo --non-recursive org.codehaus.mojo:exec-maven-plugin:3.5.0:classpath -Dexec.args='%classpath%') com.example.lab6.AppJava
```
## Nội dung chính
- `Employee`, `Address` minh hoạ **constructor injection** và **setter injection**.
- `beans.xml` cấu hình 2 kiểu inject.
- `AppConfig` (annotation) và `JavaConfig` (java-based) cho 2 cách cấu hình khác.