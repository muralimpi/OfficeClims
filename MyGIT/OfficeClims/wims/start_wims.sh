#!/bin/bash
exec nohup mvn spring-boot:run &> wims_log.txt 2>&1 &
