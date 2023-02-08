package com.example.User_management_system.controller;

import com.example.User_management_system.model.User;
import com.example.User_management_system.service.Userservice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/User")
public class Usercontroller {
    private final Userservice userservice;

    public Usercontroller(Userservice userservice) {
        this.userservice = userservice;
    }


    @PostMapping("/add-User")
    public void addUser(@RequestBody User user) {
        userservice.addUser(user);
    }


    @GetMapping("/get-User/id/{id}")
    public User findUserById(@PathVariable int id) {
        return userservice.findById(id);
    }


    @GetMapping("/get-all-User")
    public List<User> findAllUser() {
        return userservice.findAll();
    }


    @PutMapping("/update-user-info/id/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) {
        userservice.updateUser(id, user);
    }


    @DeleteMapping("/delete-user/id/{id}")
    public void deleteUser(@PathVariable int id) {
        userservice.deleteUser(id);
    }
}
