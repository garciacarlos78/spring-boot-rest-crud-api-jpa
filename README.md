# Spring Boot REST CRUD API JPA

Simple exercise to manage Employees in a MySQL database via REST API, using JPA.

Base project: https://github.com/garciacarlos78/spring-boot-rest-crud-api-hibernate

## Commit: Initial commit
Copied base project, renamed it and tested it.

## Commit: JPA DAO implemented
Implemented new DAO interface, using JPA instead of Hibernate.  
Also changed response when trying to delete a non existing id, from 200 OK to RuntimeException. Exception handling is not the goal of this project (should be 4xx response instead of 500).