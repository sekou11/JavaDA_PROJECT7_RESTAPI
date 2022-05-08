# JavaDA_PROJECT7_RESTAPI
spring Boot
Tecknical

1 Framework: Spring Boot v2.2.6

2 Java 11

3 Thymeleaf

4 Bootstrap v.5.1.3

5 Maven 3.6.2

6 Mysql 8.0.17

Installing

A step by step series of examples that tell you how to get a development env running:

1.Install Java:

https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

2.Install Maven:

https://maven.apache.org/install.html

3.Install MySql:

https://dev.mysql.com/downloads/mysql/

After downloading the mysql 8 installer and installing it, you will be asked to configure the password for the default root account. This code uses the default root account to connect and the password can be set as rootroot. 
And :
 -create  database demo_p7db;
 - use demo_p7db;
Running App

Post installation of MySQL, Java and Maven, you have to :
- fork this repostory (https://github.com/OpenClassrooms-Student-Center/JavaDA_PROJECT7_RESTAPI) 
- Clone in your terminal : 
Implement a future

1 Create mapping domain class and place in package com.nnk.springboot.domain 

2 Create repository class and place in package com.nnk.springboot.repositories

3 Create controller class and place in package com.nnk.springboot.controllers

4 Create view files and place in src/main/resource/templates

Write Unit Test

1 Create unit test and place in package com.nnk.springboot in folder test > java

Security

1 Create user service to load user from database and place in package com.nnk.springboot.services
2 Add configuration class and place in package com.nnk.springboot.security
