FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.2-jdk-slim
COPY --from=build /target/hospital_management.jar hospital_management.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","hospital_management.jar" ]
