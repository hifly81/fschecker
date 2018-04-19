#!/bin/bash

ENDPOINT=http://localhost:8080/fschecker/file


printf "Execute health check:"
curl -H 'Content-Type: application/json' -X GET $ENDPOINT/health

printf "\nCreate file:"
curl -H 'Content-Type: application/json' -X PUT -d '{"content": "test","path": "/tmp/test.txt"}' $ENDPOINT

printf "\nRead file content:"
curl -H 'Content-Type: application/json' -X POST -d '{"path": "/tmp/test.txt"}' $ENDPOINT/content

printf "\nAdd file content:"
curl -H 'Content-Type: application/json' -X POST -d '{"content": "test2","path": "/tmp/test.txt"}' $ENDPOINT

printf "\nRead file content:"
curl -H 'Content-Type: application/json' -X POST -d '{"path": "/tmp/test.txt"}' $ENDPOINT/content

printf "\nDelete file:"
curl -H 'Content-Type: application/json' -X DELETE -d '{"path": "/tmp/test.txt"}' $ENDPOINT
