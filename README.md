# webapp
Cloud computing Summer 2020 

**Cloud native web-app hosted on AWS**

Services used : EC2, RDS,Lambda, VPC, SNS, SES, CodeDeploy, Route53, Cloudwatch

Prerequisites for building and deploying your application locally :
The web application is built using Maven, and is based on Java, Spring MVC and Hibernate.
MySQL database is used for storage.
Apache Tomcat Server is used to run the application.
JDK,Maven,Apache Tomcat 9.0.35 and MySQL database is required to run this web app.

Build and Deploy instructions for web application:
Build the application using maven: mvn clean install


To deploy the application, configure the tomcat server
Deploy the application on port 8080

CLI Command to Import SSL Certificate into AWS Certificate Manager:
aws acm import-certificate --certificate file://prod_anishkapuskar_me.crt --private-key file://server.private.pem
