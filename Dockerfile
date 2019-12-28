FROM openjdk:8-jre
RUN apt-get install -y libfontconfig
VOLUME /tmp
ARG JAR_FILE=hr.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
