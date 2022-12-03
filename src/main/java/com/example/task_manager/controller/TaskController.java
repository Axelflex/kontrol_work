package com.example.task_manager.controller;

import com.example.task_manager.domin.Status;
import com.example.task_manager.domin.Task;
import com.example.task_manager.dto.TaskDto;
import com.example.task_manager.repos.TaskRepo;
import com.example.task_manager.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/api/v1/task/addTask")
    public void addTask(@Valid @RequestBody TaskDto taskDto){
        taskService.add(taskDto);
    }
    @PostMapping("/api/v1/task/changeStatus")
    public void change(@Valid @RequestParam Long id, @RequestParam int statusNum){
        taskService.change(id, statusNum);
    }
    @PostMapping("/user/create-task")
    public void createTask(@Valid @RequestBody TaskDto taskDto){
        taskService.add(taskDto);
    }

}
