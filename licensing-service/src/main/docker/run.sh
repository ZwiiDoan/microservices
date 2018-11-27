#!/bin/sh
echo "********************************************************"
echo "Environment Variables"
echo "********************************************************"
echo "CONFIG_SERVER_PORT=$CONFIG_SERVER_PORT"
echo "CONFIG_SERVER_URI=$CONFIG_SERVER_URI"
echo "DATABASE_PORT=$DATABASE_PORT"
echo "PROFILE=$PROFILE"
#echo "ENCRYPT_KEY=$ENCRYPT_KEY"

echo "********************************************************"
echo "Waiting for the configuration server to start on port $CONFIG_SERVER_PORT"
echo "********************************************************"
while ! `nc -z config-server $CONFIG_SERVER_PORT `; do sleep 3; done
echo ">>>>>>>>>>>> Configuration Server has started"

echo "********************************************************"
echo "Waiting for the database server to start on port $DATABASE_PORT"
echo "********************************************************"
while ! `nc -z database $DATABASE_PORT`; do sleep 3; done
echo ">>>>>>>>>>>> Database Server has started"

#echo "********************************************************"
#echo "Starting License Server with Configuration Service :  $CONFIGSERVER_URI";
#echo "********************************************************"
#java -cp app:app/lib/* per.duyd.training.microservices.licensingserver.LicensingServiceApplication \
#    -Dspring.cloud.config.uri=$CONFIGSERVER_URI \
#    -Dspring.profiles.active=$PROFILE

echo "********************************************************"
echo "Starting License Server with Configuration Service: $CONFIG_SERVER_URI"
echo "********************************************************"
java -cp app:app/lib/* \
    -Dspring.profiles.active=$PROFILE \
    -Dspring.cloud.config.uri=$CONFIG_SERVER_URI \
    -DENCRYPT_KEY=$ENCRYPT_KEY \
    per.duyd.training.microservices.licensingserver.LicensingServiceApplication