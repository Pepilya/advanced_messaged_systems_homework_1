#! /bin/bash
cd producer
echo "Building producer ..."
./gradlew clean build
cd ..
cd listener
echo "Building durable-listener ..."
./gradlew clean build
cd ..
docker compose down
docker compose up --build