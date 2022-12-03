package com.example.task_manager.service;

import com.example.task_manager.domin.*;
import com.example.task_manager.dto.TaskDto;
import com.example.task_manager.repos.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;

    public void add(TaskDto taskDto) {
        Task t = new Task(
                taskDto.getText(),
                Status.Created,
                taskDto.getUser()
        );
        taskRepo.save(t);
    }


    public void change(Long id, int statusNum) {
        switch (statusNum){
            case 1:
                taskRepo.updateTask(String.valueOf(Status.Completed), id);
                break;
            case 2:
                taskRepo.updateTask(String.valueOf(Status.On_Going), id);
                break;
            case 3:
                taskRepo.updateTask(String.valueOf(Status.Failed), id);
                break;
        }
    }
}
