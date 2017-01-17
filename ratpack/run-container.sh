#!/usr/bin/env bash

docker run -dit -p 9001:9001 --name ratpack --net host logify/ratpack