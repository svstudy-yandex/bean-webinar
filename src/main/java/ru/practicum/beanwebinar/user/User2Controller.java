package ru.practicum.beanwebinar.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users2")
public class User2Controller {
    private final UserRepository userRepository;

    public User2Controller(UserRepository userRepository) {
        System.out.println("UserController2 - constructor");
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User saveNewUser(@RequestBody User user) {
        return userRepository.save(user);
    }
}
