package com.spendwise.controller;

import com.spendwise.dto.UserDTO;
import com.spendwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.findAllUsers();
    }

    // Additional endpoints
}
