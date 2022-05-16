# JavaDA_PROJECT7_RESTAPI


Tecknical



1- Java 11

2- Maven 3.6.2

3- Mysql 8.0.17

Installing

A step by step series of examples that tell you how to get a development env running:

1.Install Java:

https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html

2.Install Maven:

https://maven.apache.org/install.html

3.Install MySql:

https://dev.mysql.com/downloads/mysql/

After downloading the mysql 8 installer and installing it, you will be asked to configure the password for the default root account.

This code uses the default root account to connect and the password can be set as rootroot. 





Running App

Post installation of MySQL, Java and Maven, you have to :

- fork this repostory (https://github.com/OpenClassrooms-Student-Center/JavaDA_PROJECT7_RESTAPI) 
- Clone the project in your terminal : https://github.com/sekou11/JavaDA_PROJECT7_RESTAPI.git




Running App

After some modifications of project we can run this app with maven in command line:
- mvn clean package : for generate a classes in target

- mvn spring-boot:run : for run our application

Deploy App
 move in directory target :cd target
 deploy it : java -jar spring-boot-skeleton-0.0.1-SNAPSHOT.jar
