FROM openjdk:8-jdk-alpine
COPY target/Jumia-0.0.1.jar Jumia-0.0.1.jar.jar
COPY sample.db sample.db
ENTRYPOINT ["java","-jar","/Jumia-0.0.1.jar"]
EXPOSE 8080