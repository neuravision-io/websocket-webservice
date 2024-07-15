FROM openjdk:21-jdk
MAINTAINER Samuel Abramov
COPY build/libs/websocket-webservice-0.0.1.jar websocket-webservice-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/websocket-webservice-0.0.1.jar"]