#!/bin/bash
rm -rf proj/
docker stop $(docker ps -a -q)
docker rm -f $(docker ps -a -q)
docker rmi $(docker images -q)