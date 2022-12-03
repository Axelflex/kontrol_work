package com.example.task_manager.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class EmailValidationService implements Predicate<String> {

    @Override
    public boolean test(String s){
        return true;
    }
}
