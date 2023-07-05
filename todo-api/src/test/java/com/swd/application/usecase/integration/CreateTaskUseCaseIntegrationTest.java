package com.swd.application.usecase.integration;

import com.swd.BaseTest;
import com.swd.application.config.AppConfig;
import com.swd.application.port.DynamoDbTaskRepository;
import com.swd.application.port.aws.DynamoDbFactory;
import com.swd.application.usecase.CreateTaskUseCase;
import com.swd.domain.model.Task;
import com.swd.domain.port.TaskDataBasePort;
import com.swd.domain.usecase.UseCaseResult;
import org.junit.Before;
import org.junit.Test;
import uk.org.webcompere.lightweightconfig.ConfigLoader;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTaskUseCaseIntegrationTest extends BaseTest {

    @Before
    public void setUp() throws Exception {

        this.environmentVariablesRule.set("ENV_NAME", this.getEnvName());
        this.environmentVariablesRule.set("LOCALSTACK_HOSTNAME", this.getLocalstackHostname());

        this.appConfig = ConfigLoader.loadYmlConfigFromResource("app/dev/config.yml", AppConfig.class);
    }

    @Test
    public void should_save_a_task_in_the_database() {

        TaskDataBasePort taskDataBasePort = new DynamoDbTaskRepository(new DynamoDbFactory(this.appConfig));

        CreateTaskUseCase createTaskService = new CreateTaskUseCase(taskDataBasePort);

        Task task = new Task("", "task01", false);

        UseCaseResult<Task> result = createTaskService.create(task);

        Task dataBaseTask = taskDataBasePort.findTaksById(result.getModel().getId());

        assertThat(dataBaseTask).isNotNull();
    }

}
