# Building a .Net Core API

## Source:
### Development:  
https://medium.com/beelabacademy/implementando-na-pr%C3%A1tica-rest-api-com-conceitos-de-ddd-net-2160291a44b7
### Testing:  
https://www.learmoreseekmore.com/2022/02/dotnet6-unit-testing-aspnetcore-web-api-using-xunit.html

### C# input and output
https://zetcode.com/csharp/input-output/


1. Start a sql server using a microsoft docker image:

`docker run -e 'ACCEPT_EULA=Y' -e 'SA_PASSWORD=yourStrong(!)Password' -p 1433:1433 -d mcr.microsoft.com/mssql/server:2017-latest`

2. Build the domain project
   1. Build the domain model of the application
   2. Build the repository interfaces of the application
   3. Build the service interfaces of the application (model as entry and exit)
   4. Implement the services

3. Build the application project
   1. Build DTOs for the model
   2. Build application service interfaces (DTO as entry and exit)

4. Build the infrastructure project
   1. Implement mapping mechanism between model and DTO
   2. Build the ORM mechanism
   2. Implement the repositories

5. Finish the application project
   1. Implement the application service

6. Finish the infrastructure project
   1. implement the dependency injection configuration
   2. implement the dependency injection module

7. Build the presentation project
   1. Implement the controllers 



