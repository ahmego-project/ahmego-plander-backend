FROM openjdk:8-jdk-alpine
RUN mkdir /service
ADD build/libs/backend-0.0.1-SNAPSHOT.jar /service/ROOT.jar
ENTRYPOINT ["java","-jar","/service/ROOT.jar"]