package com.example.Url_Hit_Counter.controller;

import com.example.Url_Hit_Counter.model.Url;
import com.example.Url_Hit_Counter.service.Url_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/Url-Hit-Count")
public class Url_controller {
    @Autowired
    private Url_service url_service;
    @GetMapping("/username/{username}/count")
    public Url getCount(@PathVariable String username) {
        Url url=url_service.getUrls(username);
        return url;
    }
}
