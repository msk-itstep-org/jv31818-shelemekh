FROM alpine:3.13
ARG JAR_FILE=target/*jar

RUN apk add openjdk11
COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-jar", "/app.jar"]