package com.swd.application.usecase;

import com.google.inject.Inject;
import com.swd.application.config.GuiceFactory;
import com.swd.domain.model.Task;
import com.swd.domain.port.TaskDataBasePort;
import com.swd.domain.usecase.ICreateTaskUseCase;
import com.swd.domain.usecase.UseCaseResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

public class CreateTaskUseCase implements ICreateTaskUseCase {

    private static final Logger LOGGER = LogManager.getLogger(CreateTaskUseCase.class);

    private TaskDataBasePort taskDataBasePort;

    @Inject
    public CreateTaskUseCase(TaskDataBasePort taskDataBasePort) {
        this.taskDataBasePort = taskDataBasePort;
    }

    @Override
    public UseCaseResult<Task> create(Task task) {

        UseCaseResult<Task> result = new UseCaseResult<>();

        try {

            task.setId(UUID.randomUUID().toString());
            task.setComplete(false);

            this.taskDataBasePort.createTask(task);

            result.setModel(task);
            result.setMessage("Success: task created");
            result.setSuccess(true);

            LOGGER.info("New task created: " + GuiceFactory.getGson().toJson(task));

        } catch (Exception ex) {
            result.setMessage("Error: " + ex.getMessage());
            result.setSuccess(false);

            LOGGER.error("Error task not created: " + GuiceFactory.getGson().toJson(task));
        }

        return result;
    }
}
