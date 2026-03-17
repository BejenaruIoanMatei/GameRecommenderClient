FROM gradle:8.5-jdk21 AS build
WORKDIR /app
COPY GamesRecommenderClient/build.gradle .
COPY GamesRecommenderClient/settings.gradle .
COPY GamesRecommenderClient/src ./src
RUN gradle build -x test

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

