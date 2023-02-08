package com.example.Url_Hit_Counter.service;

import com.example.Url_Hit_Counter.model.Url;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Url_service {
    static Map<String,Integer> map=new HashMap<>();
    public Url getUrls(String username) {

        int count=map.getOrDefault(username,0)+1;
        map.put(username,count);

        Url url=new Url(username,count);
        return url;
    }
}
