package com.example.cacheexamples.controller;

import com.example.cacheexamples.entity.User;
import com.example.cacheexamples.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class MyController {
    @Autowired
    private UserService userService;

    @GetMapping("users/{uid}")
    public User getUser(@PathVariable Long uid) {
        return userService.getUser(uid);
    }

    @GetMapping("users")
    public List<User> listUser() {
        return userService.listUsers();
    }

    @PatchMapping("users")
    public User patchUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("users/{uid}")
    public void delUser(@PathVariable Long uid) {
        userService.delUser(uid);
    }
}
