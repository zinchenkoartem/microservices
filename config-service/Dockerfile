FROM java:8-jre
MAINTAINER Artem

ADD ./build/libs/config-service-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-Xmx200m", "-jar", "/app.jar"]

HEALTHCHECK --interval=1m --timeout=3s --start-period=15s CMD curl -f http://localhost:8888/actuator || exit 1

EXPOSE 8888