#!/usr/bin/env bash

docker run -dit -p 8081:8081 --name dropwizard --net host logify/dropwizard