#!/usr/bin/env bash

cd /opt
mvn verify clean
mvn surefire-report:report-only
mvn site -DgenerateReports=false

cp -rf /opt/target/site/* /reports