#!/usr/bin/env bash

mvn clean install
docker build -t logify/ratpack .