FROM openjdk:18-bullseye
ARG JAR_FILE=target/PI_grupo_10-1.0.0.jar
ARG JAR_DEPLOYED=/opt/digital_booking/PI_grupo_10-1.0.0.jar
RUN mkdir /opt/digital_booking
COPY ${JAR_FILE} ${JAR_DEPLOYED}
CMD java -jar /opt/digital_booking/PI_grupo_10-1.0.0.jar
