# FSCHECKER

A sample project exposing REST APIs to perform CRUD operations on text files.

## Maven repository

FSCHECKER relies on Red Hat EAP maven dependencies using the BOM defintion.<br>
In order to use in your environment the Red Hat maven repositories for EAP you should refer to this guide:<br>
https://access.redhat.com/documentation/en-us/red_hat_jboss_enterprise_application_platform/7.1/html-single/development_guide/index#use_the_maven_repository

## Compile

```bash
mvn clean compile
```

## Create WAR

```bash
mvn clean install
```

## Deploy

Copy the WAR archive **target/fschecker.war** in **${EAP_HOME}/standalone/deployments**

## Test

Two options are available for easy testing the module:

Import the postman collection **postman/FSCHECKER.postman_collection.json** and execute the endpoints:
 - create (create a new file)
 - add entry (add content to an existing files)
 - read content (read file content)
 - delete (delete the file)

Execute the curl script **curl/curl-samples.sh**; it will simulate the CRUD operations
  - create (create a new file)
  - add entry (add content to an existing files)
  - read content (read file content)
  - delete (delete the file)
