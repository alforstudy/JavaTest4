#!/usr/bin/env bash


curl -X GET  "127.0.0.1:18080/v1/customers/BySelfPage?page=2&pageSize=10&sort=ASC"
echo
curl -X GET  "127.0.0.1:18080/v1/customers/login?name=AARON&password=SELBY"
echo
curl -X GET  "127.0.0.1:18080/v1/customers/?page=2&pageSize=10"
echo
curl -X POST -H "Content-Type: application/json" -d '{"firstName":"anlei","lastName":"1997-08-03","email":"alforstudy@163.com","address":"1001 Miyakonojo Lane"}' "127.0.0.1:18080/v1/customers/" > id.json
echo
id=$(awk '{print $1}' id.json)
curl -X PUT -H "Content-Type: application/json" -d '{"firstName":"anlei123","lastName":"nihao","email":"alforstudy@qq.com","address":"1001 Miyakonojo Lane"}' "127.0.0.1:18080/v1/customers/${id}" > id.json
echo
id=$(awk -F ','  '{print $1}' id.json | awk -F ":" '{print $2}')
echo id=$id
curl -X DELETE  "127.0.0.1:18080/v1/customers/${id}"


#curl -X GET 127.0.0.1:8080/v1/users/1 > var1

#curl -X GET 127.0.0.1:8080/v1/users/30


#curl -X PUT -H "Content-Type: application/json" -d '{"username":"小明123","birthday":"1997-08-06","sex":"2","address":"fd"}' "127.0.0.1:8080/v1/users/31"
#curl -X DELETE -H "Content-Type: application/json"  "127.0.0.1:8080/v1/users/31"


#curl


#{"id":1,"username":"王五","birthday":null,"sex":"2","address":null}