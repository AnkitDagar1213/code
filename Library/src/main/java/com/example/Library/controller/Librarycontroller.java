package com.example.Library.controller;

import com.example.Library.model.Library;
import com.example.Library.service.Libraryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/Library")
public class Librarycontroller {
    @Autowired
    private  Libraryservice libraryservice;
    @PostMapping("/add-library")
    public void addLibrary(@RequestBody Library user) {
        libraryservice.addLibrary(user);
    }


    @GetMapping("/get-User/library_number/{library_number}")
    public Library findUserById(@PathVariable int library_number) {
        return libraryservice.findBylibrary_number(library_number);
    }


    @GetMapping("/get-all-library")
    public List<Library> findAllLibrary() {
        return libraryservice.findAllLibrary();
    }


    @PutMapping("/update-user-info/library_number/{library_number}")
    public void updateLibrary(@PathVariable int library_number, @RequestBody Library user) {
        libraryservice.updateLibrary(library_number, user);
    }


    @DeleteMapping("/delete-user/library_number/{library_number}")
    public void deleteLibrary(@PathVariable int library_number) {
        libraryservice.deleteLibrary(library_number);
    }
}
