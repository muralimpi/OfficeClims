#!/bin/bash
exec nohup mvn spring-boot:run &> mims_log.txt 2>&1 &
