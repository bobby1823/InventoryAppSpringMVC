# For Java 8
FROM openjdk:8-jdk-alpine AS build

# Maven build
ARG WAR_FILE=target/InventoryApp-0.0.1-SNAPSHOT.jar

# cd /opt/app
# WORKDIR /target/

COPY ${WAR_FILE} inventory.war


FROM tomcat:latest
ADD --from=build inventory.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]