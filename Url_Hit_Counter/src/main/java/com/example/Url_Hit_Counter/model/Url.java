package com.example.Url_Hit_Counter.model;

public class Url {
    private String username;
    private int count;
    Url(){}

    @Override
    public String toString() {
        return "Url{" +
                "username='" + username + '\'' +
                ", count=" + count +
                '}';
    }

    public Url(String username, int count) {
        this.username = username;
        this.count = count;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
