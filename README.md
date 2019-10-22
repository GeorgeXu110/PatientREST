README
======================================================
This is a Patient Record Restful server.
======================================================

### start mysql server at port 3306 with user name: root password:(null)
    sudo /usr/local/mysql/support-files/mysql.server start
    
### run schema.sql in mysql

### run the patientApi-0.0.1-SNAPSHOT.jar
    java -jar patientApi-0.0.1-SNAPSHOT.jar
   
### Aspect log for logging the Api response time.
    2019-10-22 13:10:42,183 INFO (TimeLogAspect.java:26)- AddressController.getAllAddresses took 1917 ms

### Springfox's Swagger UI Portal
    http://localhost:8080/swagger-ui.html
    
### Tested by both Postman and SwaggerUI



