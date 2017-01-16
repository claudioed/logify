#!/usr/bin/env bash

docker run -dit -p 8005:8005 --name vertx --net host logify/vertx