FROM eclipse-temurin:21-jdk-alpine
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar", \
  "-Djdk.virtualThreadScheduler.maxPoolSize=1", \
  "-Dcom.sun.management.jmxremote=true", \
  "-Dcom.sun.management.jmxremote.authenticate=false", \
  "-Dcom.sun.management.jmxremote.ssl=false", \
  "-Dcom.sun.management.jmxremote.local.only=false", \
  "-Dcom.sun.management.jmxremote.port=9091", \
  "-Dcom.sun.management.jmxremote.rmi.port=9091", \
  "-Djava.rmi.server.hostname=localhost", \
  "/app.jar"]
