#!/usr/bin/env bash

docker run -dit -p 8005:8005 --name ratpack --net host logify/vertx