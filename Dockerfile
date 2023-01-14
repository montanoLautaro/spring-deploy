FROM openjdk:19

COPY target/spring-boot-mysql.jar app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]
