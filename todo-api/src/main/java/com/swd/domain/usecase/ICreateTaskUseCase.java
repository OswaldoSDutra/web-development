package com.swd.domain.usecase;

import com.swd.domain.model.Task;

public interface ICreateTaskUseCase {
    UseCaseResult<Task> create(Task task);
}
