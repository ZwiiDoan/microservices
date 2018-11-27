FROM openjdk:8-jdk-alpine
RUN apk update && apk upgrade && apk add netcat-openbsd && apk add curl
VOLUME /tmp
#Install unlimited jce policy to support encryption and decryption using symmetric (shared) keys
RUN cd /tmp/ && \
    curl -k -LO "http://download.oracle.com/otn-pub/java/jce/8/jce_policy-8.zip" -H 'Cookie: oraclelicense=accept-securebackup-cookie' && \
    unzip jce_policy-8.zip && \
    rm jce_policy-8.zip && \
    yes |cp -v /tmp/UnlimitedJCEPolicyJDK8/*.jar $JAVA_HOME/jre/lib/security/
ARG DEPENDENCY
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/BOOT-INF/classes /app
COPY ${DEPENDENCY}/META-INF /app/META-INF
ADD run.sh run.sh
RUN chmod +x run.sh
CMD ./run.sh