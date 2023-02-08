package com.example.User_management_system.service;

import com.example.User_management_system.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class Userservice {
    private static List<User> users=new ArrayList<>();
    private static int User_Count =0;

    static {
        users.add(new User(++User_Count,"Ankit","dagarshaab","Palwal","9306305689"));
        users.add(new User(++User_Count,"Ankit","dagarshaab","Palwal","9306305689"));
        users.add(new User(++User_Count,"Ankit","dagarshaab","Palwal","9306305689"));
        users.add(new User(++User_Count,"Ankit","dagarshaab","Palwal","9306305689"));
        users.add(new User(++User_Count,"Ankit","dagarshaab","Palwal","9306305689"));
    }

    public List<User> findAll() {
        return users;
    }

    public User findById(int id) {
        Predicate<? super User> predicate = user -> user.getUserId() == id;
        User user = users.stream().filter(predicate).findFirst().get();
        return user;
    }

    public void addUser(User restaurant) {
        users.add(restaurant);
    }

    public void deleteUser(int id) {
        Predicate<? super User> predicate = user -> user.getUserId() == id;
        users.removeIf(predicate);
    }

    public void updateUser(int id,User newUser) {


        User user=findById(id);

        user.setUserId(newUser.getUserId());
        user.setName(newUser.getName());
        user.setUserName(newUser.getUserName());
        user.setAddress(newUser.getAddress());
        user.setPhone_Number(newUser.getPhone_Number());
    }
}
