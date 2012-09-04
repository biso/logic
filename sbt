#!/bin/sh

java -Xmx1g -jar `dirname $0`/sbt-launch.jar "$@"
