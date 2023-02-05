package com.example.Restaurant.service;

import com.example.Restaurant.model.Restaurant;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

@Service
public class Restaurant_service {
    private static List<Restaurant> restaurants=new ArrayList<>();
    private static int Restaurant_Count =0;

    static {
        restaurants.add(new Restaurant(++Restaurant_Count,"Learn Spring Boot","Open","Palwal"));
        restaurants.add(new Restaurant(++Restaurant_Count,"Learn Spring ","Open","Palwal"));
        restaurants.add(new Restaurant(++Restaurant_Count,"Learn  Boot","Open","Palwal"));
        restaurants.add(new Restaurant(++Restaurant_Count,"Learn  ","Open","Palwal"));
        restaurants.add(new Restaurant(++Restaurant_Count,"Learn Springs Boot","Open","Palwal"));


    }

    public List<Restaurant> findAll() {
        return restaurants;
    }

    public Restaurant findById(int id) {
        Predicate<? super Restaurant> predicate = restaurant -> restaurant.getId() == id;
        Restaurant restaurant = restaurants.stream().filter(predicate).findFirst().get();
        return restaurant;
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void deleteRestaurant(int id) {
        Predicate<? super Restaurant> predicate = restaurant -> restaurant.getId() == id;
        restaurants.removeIf(predicate);
    }

    public void updateRestaurant(int id,Restaurant newRestaurant) {


        Restaurant restaurant=findById(id);

        restaurant.setId(newRestaurant.getId());
        restaurant.setName(newRestaurant.getName());
        restaurant.setStatus(newRestaurant.getStatus());
        restaurant.setAddress(newRestaurant.getAddress());
    }
}
