#!/bin/bash
kill -9 $(ps -ef | grep "mims" | grep -v grep | awk '{print $2}')
