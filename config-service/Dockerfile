FROM java:8-jre
MAINTAINER Artem

ADD ./build/libs/config-service-0.0.1-SNAPSHOT.jar /app.jar
CMD ["java", "-Xmx200m", "-jar", "/app.jar"]

HEALTHCHECK --interval=5s --timeout=10s CMD curl -f http://localhost:8888/health || exit 1

EXPOSE 8888