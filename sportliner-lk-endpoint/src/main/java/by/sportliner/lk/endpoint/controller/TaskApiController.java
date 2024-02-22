package by.sportliner.lk.endpoint.controller;

import by.sportliner.lk.core.model.Task;
import by.sportliner.lk.core.service.CurrentUserService;
import by.sportliner.lk.core.service.UserAccountService;
import by.sportliner.lk.core.service.task.TaskService;
import by.sportliner.lk.endpoint.api.TaskApi;
import by.sportliner.lk.endpoint.api.TaskDto;
import by.sportliner.lk.endpoint.api.TaskStatusDto;
import by.sportliner.lk.endpoint.api.UserAccountItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TaskApiController implements TaskApi {

    @Autowired
    private TaskService taskService;

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private CurrentUserService currentUserService;

    @Override
    public ResponseEntity<Void> createTask(TaskDto taskDto) {
        Task task = new Task();

        updateFields(task, taskDto);

        taskService.save(task);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<TaskDto>> findAll() {
        return ResponseEntity.ok(taskService.findAll().stream()
            .map(this::convert)
            .collect(Collectors.toList())
        );
    }

    @Override
    public ResponseEntity<TaskDto> getTaskById(String id) {
        Task task = taskService.getById(id);

        return ResponseEntity.ok(convert(task));
    }

    @Override
    public ResponseEntity<Void> updateStatusTaskById(String id, TaskStatusDto status) {
        taskService.updateStatus(id, Task.TaskStatus.valueOf(status.name()));

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> updateTask(String id, TaskDto taskDto) {
        Task task = taskService.getById(id);

        updateFields(task, taskDto);

        taskService.save(task);

        return ResponseEntity.ok().build();
    }

    private void updateFields(Task task, TaskDto taskDto) {
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setAssignee(userAccountService.getById(taskDto.getAssignee().getId()));
        task.setReporter(taskDto.getReporter() == null
            ? currentUserService.getUserAccount()
            : userAccountService.getById(taskDto.getReporter().getId())
        );
        task.setStatus(Task.TaskStatus.valueOf(taskDto.getStatus().name()));
    }

    private TaskDto convert(Task it) {
        return new TaskDto()
            .id(it.getId())
            .name(it.getName())
            .description(it.getDescription())
            .assignee(new UserAccountItemDto()
                .id(it.getAssignee().getId())
                .fullName(it.getAssignee().getFullName())
            )
            .reporter(new UserAccountItemDto()
                .id(it.getReporter().getId())
                .fullName(it.getReporter().getFullName())
            )
            .status(TaskStatusDto.valueOf(it.getStatus().name()));
    }

}
