package com.example.task_manager.service;

import com.example.task_manager.domin.RegistrationRequest;
import com.example.task_manager.domin.User;
import com.example.task_manager.domin.UserRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final EmailValidationService emailService;
    private final UserService userService;

    public String register(RegistrationRequest request) {
        boolean isValid = emailService.test(request.getEmail());
        if (!isValid){
            throw new IllegalStateException("email not valid");
        }
        return userService.signUpUser(
                new User(
                        request.getUsername(),
                        request.getEmail(),
                        request.getPassword(),
                        UserRole.USER
                )
        );
    }
}
