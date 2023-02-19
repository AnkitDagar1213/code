package com.example.Usermanagementsystem.service;

import com.example.Usermanagementsystem.model.User;
import com.example.Usermanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User addUser(User user) {
        user.setDate(LocalDate.now());
        user.setTime(LocalTime.now());
        return userRepository.save(user);
    }
    public Optional<User> getUser(Integer User_Id) {
        return userRepository.findById(Long.valueOf(User_Id));
    }
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User updateUserInfo(Long User_Id, User NewUser) {

        Optional<User> optionalUser = userRepository.findById(User_Id);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setUsername(NewUser.getUsername());
            user.setDateOfBirth(NewUser.getDateOfBirth());
            user.setEmail(NewUser.getEmail());
            user.setPhoneNumber(NewUser.getPhoneNumber());
            user.setDate(LocalDate.now());
            user.setTime(LocalTime.now());
            return userRepository.save(user);
        } else {
            throw new UserNotFoundException("User with ID " + User_Id + " not found");
        }
    }
    public void deleteUser(Integer User_Id) {
        try {
            userRepository.deleteById(Long.valueOf(User_Id));
        } catch (Exception e) {
            throw new UserNotFoundException("User with ID " + User_Id + " not found");
        }
    }
}
