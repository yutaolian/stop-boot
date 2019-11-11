#!/bin/sh
SERVER_NAME='axxol-api'
PIDS=`ps -ef | grep java | grep $SERVER_NAME |awk '{print $2}'`
if [ -z "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME does not started!"
    exit 1
fi
echo -e "Stopping the $SERVER_NAME ...\c"
for PID in $PIDS ; do
    kill -9 $PID > /dev/null 2>&1
done
echo "OK!"
echo "PID: $PIDS"
