FROM resin/rpi-raspbian:jessie

MAINTAINER Carl J. Mosca <carljmosca@gmail.com>

# Install common build dependencies
RUN apt-get update
RUN apt-get install -y \
openjdk-jre8

VOLUME /tmp
ADD zmjet-server-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
