# FullStack-Mini-Projects

# Table of Contents
1. [P1-SpringBoot-MySQL ](#1-p1-springboot-mysql  )
2. [P2-SpringBoot-MongoDB-Atlas](#2-p2-springboot-mongodb-atlas)

## 1. P1-SpringBoot-MySQL
SpringBoot Project with local MySQL integration.  
  
    Initial Dependencies added:  
        1. Lombok  
        2. Spring Data JPA  
        3. MySQL Driver  
        4. Spring Web  

CRUD Operations Done here:  
    1. addCompany  
    2. addCompanies  
    3. findAllCompanies  
    4. findCompanyById  
    5. findCompanyByCode  
    6. updateCompany  
    7. deleteCompany  

  
## 2. P2-SpringBoot-MongoDB-Atlas
SpringBoot Project with MongoDB Atlas integration.  

    Initial Dependencies added:  
        1. Lombok  
        2. Spring Boot DevTools  
        3. Spring Data MongoDB  
        4. Spring Web  

    
## 3. SpringBoot-Kafka-Producer and Consumer
1. P3a-SpringBoot-Kafka-Producer  
        SpringBoot Project as Kafka Producer.  

        Initial Dependencies added:  
            1. Lombok  
            2. Spring Boot DevTools  
            3. Spring Web  
            4. Spring for Apache Kafka  

2. P3b-SpringBoot-Kafka-Consumer  
        SpringBoot Project as Kafka Consumer.  

        Initial Dependencies added:  
            1. Lombok  
            2. Spring Boot DevTools  
            3. Spring Web  
            4. Spring for Apache Kafka  

Kafka Commands:(Kafka Version: 2.8.1)  
Open 2 cmd in: 
```bash
  C:\Prosenjit\IT_Softwares\Kafka\kafka\bin\windows  
``` 
start zookeeper.start bat (Default port = 2181)  
```bash
  zookeeper-server-start.bat ./../../config/zookeeper.properties
``` 
start Kafka server (Default port = 9092)
```bash
  kafka-server-start.bat ./../../config/server.properties
``` 
  
Now let’s create a topic:  
Open cmd in:  
```bash
  C:\Prosenjit\IT_Softwares\Kafka\kafka\bin\windows
``` 
```bash
  kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 -topic demo1topic
``` 
Note: Here 2181 is the zookeeper port. Here “demo1topic” is the topic name.

To check all the topics:  
```bash
  kafka-topics.bat --zookeeper localhost:2181 –list
``` 



sadsa
## 4. P4-SpringBoot-Kafka-MySQL and MongoDB  
1. P4a-SpringBoot-Kafka-Producer-MySQL  
        SpringBoot Project as Kafka Producer. 
        This will have the CRUD Operations in MySQL.  
        The same will be sent to Kafka Consumer to be in sync with MongoDB.   

        Initial Dependencies added:  
            1. Spring Boot DevTools
            2. Lombok
            3. Spring for Apache Kafka
            4. Spring Data JPA
            5. MySQL Driver
            6. Spring Data MongoDB
            7. Spring Web

2. P4b-SpringBoot-Kafka-Consumer-MongoDB  
        SpringBoot Project as Kafka Consumer.  

        Initial Dependencies added:  
            1. Spring Boot DevTools
            2. Lombok
            3. Spring for Apache Kafka
            4. Spring Data MongoDB
            5. Spring Web

Replicate all data from MySQL to MongoDB.  
Export from MySQL DB, import into MongoDB.  
Here it is a table, there it is a collection.  
Here it is a record, there it is a document.  
## 5. P5-SpringBoot-SpringSecurity-BasicAuthenticationAuthorization

    Initial Dependencies added:  
        1. Spring Boot DevTools  
        2. Spring Web  
        3. Spring Security

Role based authorization  
URL based authorization
## 6. P6-SpringBoot-SpringSecurity-JWT

    Initial Dependencies added:  
        1. Spring Boot DevTools  
        2. Spring Web  