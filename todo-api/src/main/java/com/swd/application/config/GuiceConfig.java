package com.swd.application.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.inject.AbstractModule;
import com.swd.application.usecase.CreateTaskUseCase;
import com.swd.domain.port.TaskDataBasePort;
import com.swd.application.port.DynamoDbTaskRepository;
import com.swd.application.port.aws.DynamoDbFactory;
import com.swd.application.port.aws.IDynamoDbFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import uk.org.webcompere.lightweightconfig.ConfigLoader;

public class GuiceConfig extends AbstractModule {

    private static final Logger LOGGER = LogManager.getLogger(GuiceConfig.class);

    private String env, configFileUri;

    private void setEnvironmentName(){
        this.env = System.getenv("ENV_NAME");

        LOGGER.info("Setting Env_Name: ");
        LOGGER.info(this.env);
    }

    private void setConfigFileUri(){
        this.configFileUri = new StringBuilder().append("app/").append(this.env).append("/config.yml").toString();
    }

    @Override
    protected void configure() {

        this.setEnvironmentName();
        this.setConfigFileUri();

        AppConfig appConfig = ConfigLoader.loadYmlConfigFromResource(this.configFileUri, AppConfig.class);

        LOGGER.info("AppConfig created: ");
        LOGGER.info(appConfig.getDbHost());
        LOGGER.info(appConfig.getAwsRegion());
        LOGGER.info(appConfig.getEnvironmentName());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        bind(Gson.class).toInstance(gson);
        bind(IAppConfig.class).toInstance(appConfig);
        bind(IDynamoDbFactory.class).to(DynamoDbFactory.class);
        bind(TaskDataBasePort.class).to(DynamoDbTaskRepository.class);
    }
}
