FROM java:8-jre
MAINTAINER Artem

ADD ./build/libs/discovery-service-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-Xmx200m", "-jar", "/app.jar"]

HEALTHCHECK --interval=5s --timeout=60s CMD curl -f http://localhost:8762/actuator || exit 1

EXPOSE 8762