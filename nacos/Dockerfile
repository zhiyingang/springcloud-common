FROM registry.docker-cn.com/library/java:8-jdk-alpine

MAINTAINER pader "huangmnlove@163.com"

# set environment
ENV MODE="cluster" \
    BASE_DIR="/home/nacos" \
    JAVA="$JAVA_HOME/bin/java" \
    CLASSPATH=".:/home/nacos/conf:$CLASSPATH" \
    CLUSTER_CONF="/home/nacos/conf/cluster.conf"

WORKDIR /home/nacos

COPY nacos $BASE_DIR

# timezone
RUN apk add -U tzdata \
    && cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
	&& rm -rf /var/lib/apt/lists/*

# set startup log dir
RUN mkdir logs \
	&& cd logs \
	&& touch start.log \
	&& ln -sf /dev/stdout $BASE_DIR/logs/start.log \
	&& ln -sf /dev/stderr $BASE_DIR/logs/start.log
RUN chmod +x bin/docker-startup.sh

EXPOSE 8848
# ENTRYPOINT ["bin/docker-startup.sh"]
# WORKDIR /home/nacos/bin
ENTRYPOINT exec /home/nacos/bin/docker-startup.sh