#! /bin/bash
cd producer
echo "Building producer ..."
./gradlew clean build
cd ..
cd durable-listener
echo "Building durable-listener ..."
./gradlew clean build
cd ..
cd non-durable-listener
echo "Building non-durable-listener ..."
./gradlew clean build
docker compose down
docker compose up --build