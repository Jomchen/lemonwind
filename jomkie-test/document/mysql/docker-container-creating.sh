#!/bin/bash
# Author: Jomkie


containerName=mysql00
baseDir=/opt/docker-container/mysql/${containerName}
logDir=${baseDir}/logs
dataDir=${baseDir}/data

if [ ! -e ${baseDir} ];then
  mkdir -p ${baseDir}
fi
if [ ! -e ${logDir} ];then
  mkdir ${logDir}
fi
if [ ! -e ${dataDir} ];then
  mkdir ${dataDir}
fi

# 是映射 配置路径
  # 挂载配置 -v xxx:/etc/mysql \
  # 挂载日志 -v xxx:/var/log/mysql \
  # 挂载数据 -v xxx:/var/lib/mysql \

docker run \
  --name ${containerName} \
  -p 3306:3306 \
  -e MYSQL_ROOT_PASSWORD=root \
  -v ${logDir}:/var/log/mysql \
  -v ${dataDir}:/var/lib/mysql \
  -d mysql:5.7.27
