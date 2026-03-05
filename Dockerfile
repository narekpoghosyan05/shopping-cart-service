FROM openjdk:17-jdk-slim-buster
WORKDIR /app
COPY . /app
ENTRYPOINT ["java", "-jar", "shopping-cart.jar"]