package com.swd.domain.port;

import com.swd.domain.model.Task;

public interface TaskDataBasePort {
    void createTask(Task task);
    Task findTaksById(String id);
}

