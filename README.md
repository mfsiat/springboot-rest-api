# How to deploy this project using docker
## Requeirements on linux machine
1. Docker & docker compose

run below command to run this project 
```
docker compose up -d
```
Deplyoment done!

## Api endpoints

- get student
```
http://localhost:8080/student
```
- get students
```
http://localhost:8080/students
```
## Spring Boot REST API with Path Variable
### {id} - URI template variable
```
http://localhost:8080/student/1
```
## Spring boot REST API with Request Param
```
http://localhost:8080/students/query?id=1&firstName=Nasirul&lastName=Islam
```
## Spring boot REST API that handles HTTP POST Request
### @PostMapping and @RequestBody
```
curl --location --request POST 'http://localhost:8080/students/create' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id": 3,
    "firstName": "Wasif",
    "lastName": "Shikdar"
}'
```
## Spring Boot REST API that handles HTTP PUT Request - updating existing resource
```
curl --location --request PUT 'http://localhost:8080/students/1/update' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Amdad",
    "lastName": "Bari"
}'
```

## Spring boot REST API that handles HTTP DELETE Request - deleting the existing resource
```
curl --location --request DELETE 'http://localhost:8080/students/2/delete'
```