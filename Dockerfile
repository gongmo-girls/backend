FROM openjdk:17-alpine
COPY build/libs/tourgather-0.0.1-SNAPSHOT.jar tourgather.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/tourgather.jar"]

RUN echo "tourgather server start"