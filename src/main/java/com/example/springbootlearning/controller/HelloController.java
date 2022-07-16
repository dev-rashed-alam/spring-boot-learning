package com.example.springbootlearning.controller;

import com.example.springbootlearning.model.User;
import com.example.springbootlearning.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/users")
public class HelloController {


    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {

        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id, @RequestParam("client") String clientName) {
        System.out.println("clientName: " + clientName);
        return userService.getById(id);
    }

    @PostMapping
    public User save(@Valid @RequestBody User user) {
        userService.save(user);
        return user;
    }
}
