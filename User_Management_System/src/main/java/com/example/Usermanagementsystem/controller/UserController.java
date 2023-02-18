package com.example.Usermanagementsystem.controller;

import com.example.Usermanagementsystem.model.User;
import com.example.Usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
        user.setDate(LocalDate.now());
        user.setTime(LocalTime.now());
        User newUser = userRepository.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getUser(@PathVariable Long User_Id) {
        Optional<User> user = userRepository.findById(User_Id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> user = userRepository.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/updateUserInfo/{User_Id}")
    public ResponseEntity<User> updateUserInfo(@PathVariable Long User_Id, @Valid @RequestBody User NewUser) {
        Optional<User> optionalUser = userRepository.findById(User_Id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(NewUser.getUsername());
            user.setDateOfBirth(NewUser.getDateOfBirth());
            user.setEmail(NewUser.getEmail());
            user.setPhoneNumber(NewUser.getPhoneNumber());
            user.setDate(LocalDate.now());
            user.setTime(LocalTime.now());
            User savedUser = userRepository.save(user);
            return new ResponseEntity<>(savedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUser/{User_Id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable Long User_Id) {
        try {
            userRepository.deleteById(User_Id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
