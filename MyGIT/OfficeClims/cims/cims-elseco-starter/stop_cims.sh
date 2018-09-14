#!/bin/bash
kill -9 $(ps -ef | grep "cims" | grep -v grep | awk '{print $2}')
