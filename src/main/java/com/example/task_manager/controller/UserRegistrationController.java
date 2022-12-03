package com.example.task_manager.controller;

import com.example.task_manager.domin.RegistrationRequest;
import com.example.task_manager.service.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class UserRegistrationController {

    private final RegistrationService service;
    @PostMapping
    public String register(@Valid @RequestBody RegistrationRequest request){
        return service.register(request);
    }
}
