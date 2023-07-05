package com.swd.application.config.unit;

import com.swd.BaseTest;
import com.swd.application.config.AppConfig;
import com.swd.application.config.GuiceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import uk.org.webcompere.lightweightconfig.ConfigLoader;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;

public class AppConfigUnitTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        this.environmentVariablesRule.set("ENV_NAME", this.getEnvName());
        this.environmentVariablesRule.set("LOCALSTACK_HOSTNAME", this.getLocalstackHostname());
        this.environmentVariablesRule.set("API_ID", this.getApiId());

        this.properties = ConfigLoader.loadProperties(Paths.get("src","main", "resources", "app/dev/config.properties"));
        this.appConfig = ConfigLoader.loadYmlConfigFromResource("app/dev/config.yml", AppConfig.class);
    }

    @Test
    public void test_get_create_endpoint_config_from_yml() {

        regexPattern = stringBuilder.append("^http://")
                .append(this.getApiId())
                .append(".*")
                .append("task/$")
                .toString();

        assertThat(this.appConfig.getCreateEndpoint()).matches(regexPattern);
    }

    @Test
    public void test_get_dbHost_config_from_yml() {

        regexPattern = stringBuilder.append("^http://")
                .append(this.getLocalstackHostname())
                .append(":4566")
                .toString();

        assertThat(this.appConfig.getDbHost()).matches(regexPattern);
    }

}