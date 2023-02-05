package com.example.Restaurant.model;

public class Restaurant {
    private int id;
    private String name;
    private String status;
    private String address;

    @Override
    public String toString() {
        return "restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    Restaurant() {}

    public Restaurant(int id,String name,String status,String address) {
        this.id=id;
        this.name=name;
        this.status=status;
        this.address=address;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
