package com.swd;

import com.swd.application.config.AppConfig;
import com.swd.application.config.IAppConfig;
import org.junit.Rule;
import uk.org.webcompere.systemstubs.rules.EnvironmentVariablesRule;
import uk.org.webcompere.systemstubs.rules.SystemOutRule;

import java.util.Properties;

public class BaseTest {

    @Rule
    public EnvironmentVariablesRule environmentVariablesRule = new EnvironmentVariablesRule();

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule();

    public String regexPattern;

    public StringBuilder stringBuilder = new StringBuilder();

    public Properties properties;
    public AppConfig appConfig;

    private String envName = "dev";
    private String localstackHostname = "localhost";
    private String userPassword = "user-pwd";
    private String apiId = "api-id";

    public void setEnvName(String envName) {
        this.envName = envName;
    }

    public void setLocalstackHostname(String localstackHostname) {
        this.localstackHostname = localstackHostname;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getEnvName() {
        return envName;
    }

    public String getLocalstackHostname() {
        return localstackHostname;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getApiId() {
        return apiId;
    }

}
