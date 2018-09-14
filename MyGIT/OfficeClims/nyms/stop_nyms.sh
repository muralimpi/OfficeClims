#!/bin/bash
kill -9 $(ps -ef | grep "nyms" | grep -v grep | awk '{print $2}')
