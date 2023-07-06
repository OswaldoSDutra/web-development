# Building a Java API

Sources:

https://www.javaguides.net/2021/10/spring-boot-crud-rest-api-project-using-IntelliJ-IDEA.html
https://www.javainuse.com/devOps/docker/docker-mysql

1. Configuring a mysql image
   1. Create a docker network for the mysql using:  
   `docker network create employee-mysql`
   2. Create the mysql container:
   `docker container run -p [host port]:[continer port] --name docker-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=ems -d mysql` 
   3. Confirm container was created:  
   `docker container ls`
   4. Connect to the database using:  
   `docker exec -it [container name] bash`  
   `mysql -uroot -proot [data base name]`

2. Configure the spring datasource
   1. `spring.datasource.url=jdbc:mysql://localhost:[docker port]/ems?useSSL=false`
   `spring.datasource.username=root`  
   `spring.datasource.password=root`  
   `spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect`
   `spring.jpa.hibernate.ddl-auto = update`





