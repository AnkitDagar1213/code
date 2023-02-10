package com.example.Library.service;

import com.example.Library.model.Library;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
public class Libraryservice {
    private static List<Library> librarys=new ArrayList<>();
    private static int Library_Count =0;

    static {
        librarys.add(new Library(++Library_Count,"Learn Spring Boot","Palwal","Open",5));
        librarys.add(new Library(++Library_Count,"Learn Spring Boot","Palwal","Open",5));
        librarys.add(new Library(++Library_Count,"Learn Spring Boot","Palwal","Open",5));
        librarys.add(new Library(++Library_Count,"Learn Spring Boot","Palwal","Open",5));
        librarys.add(new Library(++Library_Count,"Learn Spring Boot","Palwal","Open",5));
    }

    public List<Library> findAllLibrary() {
        return librarys;
    }

    public Library findBylibrary_number(int library_number) {
        Predicate<? super Library> predicate = library -> library.getLibrary_number() == library_number;
        Library library = librarys.stream().filter(predicate).findFirst().get();
        return library;
    }

    public void addLibrary(Library library) {
        librarys.add(library);
    }

    public void deleteLibrary(int library_number) {
        Predicate<? super Library> predicate = library -> library.getLibrary_number() == library_number;
        librarys.removeIf(predicate);
    }

    public void updateLibrary(int library_number,Library newLibrary) {


        Library library=findBylibrary_number(library_number);

        library.setLibrary_number(newLibrary.getLibrary_number());
        library.setLibrary_name(newLibrary.getLibrary_name());
        library.setLibrary_address(newLibrary.getLibrary_address());
        library.setLibrary_Status(newLibrary.getLibrary_Status());
        library.setNo_of_staff_in_Library(newLibrary.getNo_of_staff_in_Library());
    }
}
