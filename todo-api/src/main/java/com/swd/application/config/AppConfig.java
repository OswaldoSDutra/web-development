package com.swd.application.config;

public class AppConfig implements IAppConfig {

    private String environmentName;
    private String userName;
    private String userPassword;
    private String awsRegion;

    private String findByIdEndpoint;
    private String createEndpoint;

    private String dbHost;

    @Override
    public String getFindByIdEndpoint() {
        return findByIdEndpoint;
    }

    @Override
    public void setFindByIdEndpoint(String findByIdEndpoint) {
        this.findByIdEndpoint = findByIdEndpoint;
    }

    @Override
    public String getCreateEndpoint() {
        return createEndpoint;
    }

    @Override
    public void setCreateEndpoint(String createEndpoint) {
        this.createEndpoint = createEndpoint;
    }

    @Override
    public String getEnvironmentName() {
        return environmentName;
    }

    @Override
    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }


    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getUserPassword() {
        return userPassword;
    }

    @Override
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String getAwsRegion() {
        return awsRegion;
    }

    @Override
    public void setAwsRegion(String awsRegion) {
        this.awsRegion = awsRegion;
    }

    @Override
    public String getDbHost() {
        return dbHost;
    }

    @Override
    public void setDbHost(String dbHost) {
        this.dbHost = dbHost;
    }
}
