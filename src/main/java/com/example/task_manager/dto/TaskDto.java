package com.example.task_manager.dto;

import com.example.task_manager.domin.Status;
import com.example.task_manager.domin.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Max;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;


@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class TaskDto {
    @Max(20)
    private String text;
    private Calendar calendar = Calendar.getInstance();
    private User user;
}
