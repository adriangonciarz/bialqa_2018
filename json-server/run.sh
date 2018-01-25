#!/bin/bash

docker run -d --name json-server -v$HOME/bialqa/data_files/db.json:/opt/db.json -p3000:3000 agonciarz/json-server:latest