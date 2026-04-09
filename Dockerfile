FROM eclipse-temurin:17-jre

WORKDIR /app

COPY build/libs/demo-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-Dfile.encoding=UTF-8", "-jar", "/app/app.jar"]
