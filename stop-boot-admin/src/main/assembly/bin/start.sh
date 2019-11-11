#!/bin/bash

cd `dirname $0`
BIN_DIR=`pwd`
cd ..
DEPLOY_DIR=`pwd`
CONF_DIR=$DEPLOY_DIR/conf

SERVER_NAME=`sed '/application.name/!d;s/.*=//' conf/conf.properties | tr -d '\r'`

ENV=`sed '/application.env/!d;s/.*=//' conf/conf.properties | tr -d '\r'`

PIDS=`ps -ef | grep java | grep "$CONF_DIR" |awk '{print $2}'`
if [ -n "$PIDS" ]; then
    echo "ERROR: The $SERVER_NAME already started!"
    echo "PID: $PIDS"
    exit 1
fi


LIB_DIR=$DEPLOY_DIR/lib
LIB_JARS=`ls $LIB_DIR|grep .jar|awk '{print "'$LIB_DIR'/"$0}'`

echo "$SERVER_NAME jar location : " $LIB_JARS
echo "start $SERVER_NAME   begin..."

JAVA_OPTS=" -server -XX:MetaspaceSize=128m -XX:MaxMetaspaceSize=256m -Xms1024m -Xmx2048m -Xmn1024m -Xss256k -XX:SurvivorRatio=8"

#--------pinpoint begin-------------
AGENT_PATH=/usr/local/pinpoint-agent
if [ -d $AGENT_PATH ]; then
##get application_name from running base dir
_BASE_BIN_DIR="$( cd "$( dirname "$0" )" && pwd )"
_BASE_DIR=${_BASE_BIN_DIR/\/bin/}
APPLICATION_NAME=`basename $_BASE_DIR`
APPLICATION_NAME=`expr substr "$APPLICATION_NAME" 1 14`
HOST_NAME=`hostname`
APPLICATION_ID=`expr substr "${APPLICATION_NAME}_$HOST_NAME" 1 24`

echo $APPLICATION_ID
    JAVA_AGENT=" -javaagent:$AGENT_PATH/pinpoint-bootstrap.jar -Dpinpoint.agentId=$APPLICATION_ID -Dpinpoint.applicationName=$APPLICATION_NAME"
    JAVA_OPTS="$JAVA_OPTS $JAVA_AGENT"
fi
#--------pinpoint end-------------

nohup java -jar $JAVA_OPTS -Dfastjson.parser.autoTypeSupport=true  $LIB_JARS   >/dev/null 2>&1 &
echo "PID:"$!
echo "$SERVER_NAME  start end"
