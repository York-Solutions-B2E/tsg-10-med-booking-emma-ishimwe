FROM openjdk:17-jdk-slim AS build

WORKDIR /opt/app

COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src

RUN ./mvnw clean install -DskipTests
EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]

FROM openjdk:17-jdk-slim AS final

WORKDIR /opt/app

EXPOSE 8080

COPY --from=build /opt/app/target/*.jar /opt/app/*.jar

ENTRYPOINT ["java", "-jar", "/opt/app/*.jar"]