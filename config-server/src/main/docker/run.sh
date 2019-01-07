#!/bin/sh
echo "********************************************************"
echo "Environment Variables"
echo "********************************************************"
echo "EUREKA_SERVER_PORT=$EUREKA_SERVER_PORT"
echo "EUREKA_SERVER_URI=$EUREKA_SERVER_URI"

echo "********************************************************"
echo "Waiting for the eureka server to start on port $EUREKA_SERVER_PORT"
echo "********************************************************"
while ! `nc -z eureka-server  $EUREKA_SERVER_PORT`; do sleep 3; done
echo "******* Eureka Server has started"

echo "********************************************************"
echo "Starting Config Server"
echo "********************************************************"
java -cp app:app/lib/* \
    -Deureka.client.serviceUrl.defaultZone=$EUREKA_SERVER_URI\
    per.duyd.training.microservices.configserver.ConfigServerApplication