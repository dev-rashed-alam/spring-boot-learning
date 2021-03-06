package com.example.springbootlearning.service;

import com.example.springbootlearning.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        var user = new User();
        user.setEmail("a.com");
        user.setName("Rashed");
        user.setId("1");

        var user2 = new User();
        user2.setEmail("b.com");
        user2.setName("Alam");
        user2.setId("2");
        users.add(user);
        users.add(user2);
    }

    public User getById(String id) {
        return users.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public List<User> getAllUsers() {
        return List.copyOf(users);
    }

    public void save(User user) {
        var matchingUser = users.stream().filter(user1 -> user1.getEmail().equals(user.getEmail())).findAny();
        matchingUser.ifPresent(user1 -> {
            throw new RuntimeException("User with this email already registered");
        });

        this.users.add(user);
    }
}