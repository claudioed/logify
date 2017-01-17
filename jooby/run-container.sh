#!/usr/bin/env bash

docker run -dit -p 8080:8080 --name jooby --net host logify/jooby