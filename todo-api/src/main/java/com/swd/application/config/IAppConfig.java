package com.swd.application.config;

 public interface IAppConfig {

     String getEnvironmentName();

     void setEnvironmentName(String environmentName);

     String getDbHost();

     void setDbHost(String dbHost);

     String getUserName();

     void setUserName(String userName);

     String getUserPassword();

     void setUserPassword(String userPassword);

     String getAwsRegion();

     void setAwsRegion(String awsRegion);

     String getFindByIdEndpoint();

     void setFindByIdEndpoint(String findByIdEndpoint);

     String getCreateEndpoint();

     void setCreateEndpoint(String createEndpoint);



}
