#!/bin/bash

kill -9 $(ps -ef | grep 'java' | grep 'app/bootstrap.jar' | awk '{print $2}')