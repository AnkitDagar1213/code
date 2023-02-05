package com.example.Restaurant.controller;
import com.example.Restaurant.model.Restaurant;
import com.example.Restaurant.service.Restaurant_service;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/v1/Restaurant")
class Restaurant_controller {


    private final Restaurant_service restaurant_service;

    public Restaurant_controller(Restaurant_service restaurant_service) {
        this.restaurant_service = restaurant_service;
    }


    @PostMapping("/add-Restaurant")
    public void addRestaurant(@RequestBody Restaurant restaurant) {
        restaurant_service.addRestaurant(restaurant);
    }


    @GetMapping("/find-Restaurant/id/{id}")
    public Restaurant findRestaurantById(@PathVariable int id) {
        return restaurant_service.findById(id);
    }


    @GetMapping("/find-all")
    public List<Restaurant> findAllRestaurants() {
        return restaurant_service.findAll();
    }


    @PutMapping("/update-restaurant/id/{id}")
    public void updateRestaurant(@PathVariable int id, @RequestBody Restaurant restaurant) {
        restaurant_service.updateRestaurant(id, restaurant);
    }


    @DeleteMapping("/delete-restaurant/id/{id}")
    public void deleteRestaurant(@PathVariable int id) {
        restaurant_service.deleteRestaurant(id);
    }
}

