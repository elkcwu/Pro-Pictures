FROM openjdk:8
EXPOSE 8081
ADD target/propictures-docker.jar propictures-docker.jar
ENTRYPOINT ["java", "-jar", "/propictures-docker.jar"]