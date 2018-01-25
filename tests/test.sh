#!/usr/bin/env bash

cd /tests
mvn test -Dapi.endpoint=$ENDPOINT -Dapi.port=$PORT
mvn surefire-report:report-only
mvn site -DgenerateReports=false

cp -rf /tests/target/site/* /reports