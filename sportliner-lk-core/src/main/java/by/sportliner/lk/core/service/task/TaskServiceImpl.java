package by.sportliner.lk.core.service.task;

import by.sportliner.lk.core.model.Task;
import by.sportliner.lk.core.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task getById(String id) {
        return taskRepository.getReferenceById(id);
    }

    @Override
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    @Override
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void updateStatus(String id, Task.TaskStatus taskStatus) {
        taskRepository.updateStatus(id, taskStatus);
    }
}
