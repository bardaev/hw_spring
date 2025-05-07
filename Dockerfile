FROM amazoncorretto:17.0.5-alpine AS corretto-jdk
ADD /target/hw_plug-1.0-SNAPSHOT.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]