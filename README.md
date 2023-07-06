# Building a Java API

Sources:

https://www.javaguides.net/2021/10/spring-boot-crud-rest-api-project-using-IntelliJ-IDEA.html

1. Configuring a mysql image   
   1. Create a mysql container:  
   `docker container run -p [host forward port]:[continer port] --name docker-mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=ems -d mysql` 
   2. Confirm container was created:  
   `docker container ls`
   3. Connect to the database using:  
   `docker exec -it [container name] bash`  
   `mysql -uroot -proot [data base name]`


2. Configure the spring datasource
   1. `spring.datasource.url=jdbc:mysql://localhost:[host forward port]/[data base name]`
   `spring.datasource.username=root`  
   `spring.datasource.password=root`  
   `spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQLDialect`
   `spring.jpa.hibernate.ddl-auto = update`
