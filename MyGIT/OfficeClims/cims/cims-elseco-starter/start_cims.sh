#!/bin/bash
exec nohup mvn spring-boot:run >/dev/null 2>&1 &
