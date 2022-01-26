FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=build/libs/vaccinationproject-0.0.2-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]