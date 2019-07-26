#!/bin/bash
while ! nc -z ${db_ip} ${db_port}
do
    sleep 3
    echo "数据库端口测试失败，等待开启中"
done
java -jar /app.jar