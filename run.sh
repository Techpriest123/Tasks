#! /bin/bash

gradle build
java -cp ./app/build/classes/java/main/ org.example.App
