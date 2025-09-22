#!/bin/bash

export LC_ALL="zh_CN.UTF-8"

debug=false

for arg in "$@"; do
  case $arg in
    -d|--debug)
      debug=true
      shift
      ;;
    *)
      ;;
  esac
done

# 设置Java选项
JAVA_OPTIONS="${JAVA_OPTIONS} -Dfile.encoding=utf-8"
if [ "$debug" = true ]; then
  JAVA_OPTIONS="${JAVA_OPTIONS} -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005"
fi
# 启动应用
java ${JAVA_OPTIONS} -jar app/bootstrap.jar

# kill -9 $(ps -ef | grep 'java' | grep 'app/bootstrap.jar' | awk '{print $2}')
# tail -f /dev/null