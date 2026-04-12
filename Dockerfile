# base image to run java runtime
FROM eclipse-temurin:17-jre

# information aroung who maintain the image
LABEL authors="siddhant"

# copy local machine jar to host machine
COPY target/account-service-0.0.1-SNAPSHOT.jar account-service-0.0.1-SNAPSHOT.jar

# to run jar file
ENTRYPOINT ["java", "-jar","account-service-0.0.1-SNAPSHOT.jar"]