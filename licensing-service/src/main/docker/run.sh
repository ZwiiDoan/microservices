#!/bin/sh
#echo "********************************************************"
#echo "Waiting for the configuration server to start on port $CONFIGSERVER_PORT"
#echo "********************************************************"
#while ! `nc -z configserver $CONFIGSERVER_PORT `; do sleep 3; done
#echo ">>>>>>>>>>>> Configuration Server has started"
#
#echo "********************************************************"
#echo "Waiting for the database server to start on port $DATABASESERVER_PORT"
#echo "********************************************************"
#while ! `nc -z database $DATABASESERVER_PORT`; do sleep 3; done
#echo ">>>>>>>>>>>> Database Server has started"
#
#echo "********************************************************"
#echo "Starting License Server with Configuration Service :  $CONFIGSERVER_URI";
#echo "********************************************************"
#java -cp app:app/lib/* per.duyd.training.microservices.licensingserver.LicensingServiceApplication \
#    -Dspring.cloud.config.uri=$CONFIGSERVER_URI \
#    -Dspring.profiles.active=$PROFILE

echo "********************************************************"
echo "Starting License Server with Configuration Service "
echo "********************************************************"
java -cp app:app/lib/* per.duyd.training.microservices.licensingserver.LicensingServiceApplication