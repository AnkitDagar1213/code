package com.example.Library.model;

public class Library {

    private int library_number;
    private String library_name;
    private String library_address;
    private String library_Status;
    private int No_of_staff_in_Library;
    Library(){}

    public Library(int library_number, String library_name, String library_address, String library_Status, int no_of_staff_in_Library) {
        this.library_number = library_number;
        this.library_name = library_name;
        this.library_address = library_address;
        this.library_Status = library_Status;
        No_of_staff_in_Library = no_of_staff_in_Library;
    }

    @Override
    public String toString() {
        return "Library{" +
                "library_number=" + library_number +
                ", library_name='" + library_name + '\'' +
                ", library_address='" + library_address + '\'' +
                ", library_Status='" + library_Status + '\'' +
                ", No_of_staff_in_Library='" + No_of_staff_in_Library + '\'' +
                '}';
    }

    public int getLibrary_number() {
        return library_number;
    }

    public void setLibrary_number(int library_number) {
        this.library_number = library_number;
    }

    public String getLibrary_name() {
        return library_name;
    }

    public void setLibrary_name(String library_name) {
        this.library_name = library_name;
    }

    public String getLibrary_address() {
        return library_address;
    }

    public void setLibrary_address(String library_address) {
        this.library_address = library_address;
    }

    public String getLibrary_Status() {
        return library_Status;
    }

    public void setLibrary_Status(String library_Status) {
        this.library_Status = library_Status;
    }

    public int getNo_of_staff_in_Library() {
        return No_of_staff_in_Library;
    }

    public void setNo_of_staff_in_Library(int no_of_staff_in_Library) {
        No_of_staff_in_Library = no_of_staff_in_Library;
    }
}
