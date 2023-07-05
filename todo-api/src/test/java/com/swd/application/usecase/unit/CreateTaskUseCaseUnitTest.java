package com.swd.application.usecase.unit;

import com.swd.BaseTest;
import com.swd.application.usecase.CreateTaskUseCase;
import com.swd.domain.model.Task;
import com.swd.domain.port.TaskDataBasePort;
import com.swd.domain.usecase.UseCaseResult;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTaskUseCaseUnitTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
        this.environmentVariablesRule.set("ENV_NAME", this.getEnvName());
    }

    @Test
    public void should_log_date_time_and_created_task_as_json() {

        TaskDataBasePort taskDataBasePortMock = Mockito.mock(TaskDataBasePort.class);

        CreateTaskUseCase createTaskService = new CreateTaskUseCase(taskDataBasePortMock);

        Task task = new Task("01", "task01", false);

        UseCaseResult<Task> result = createTaskService.create(task);

        String log = systemOutRule.getLinesNormalized().toString().replaceAll("\n","");

        regexPattern = stringBuilder.append("^\\d{4}-\\d{2}-\\d{2} ")
                .append("\\d{2}:\\d{2}:\\d{2} ")
                .append(" INFO ")
                .append(".* - ")
                .append("New task created: ")
                .append("\\{  \"id\": \".*\",  \"title\": \"task01\",  \"complete\": false\\}$")
                .toString();

        assertThat(log).matches(regexPattern);
    }
}