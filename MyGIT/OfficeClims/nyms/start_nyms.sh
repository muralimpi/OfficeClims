#!/bin/bash
exec nohup mvn spring-boot:run &> nyms_log.txt 2>&1 &
