package by.sportliner.lk.core.service.task;

import by.sportliner.lk.core.model.*;

import java.util.List;

public interface TaskService {

    Task getById(String id);

    List<Task> findAll();

    Task save(Task task);

    void updateStatus(String id, Task.TaskStatus taskStatus);

}
