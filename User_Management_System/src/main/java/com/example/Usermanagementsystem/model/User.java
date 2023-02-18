package com.example.Usermanagementsystem.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private Long UserId;

    @NotNull(message = "Username cannot be null")
    @Size(min = 4, max = 30, message = "Username must be between 4 and 30 characters")
    @Column(name = "User_Name", nullable = false, length = 30)
    private String username;

    @NotNull(message = "Date of birth cannot be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth should be in the format YYYY-MM-DD")
    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @NotNull(message = "Email cannot be null")
    @Email(message = "Invalid email format")
    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in format xx-xxxxxxxxxx with first two digits as country code")
    @Column(name = "Phone_Number", nullable = false, length = 12)
    private String phoneNumber;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "Time")
    private LocalTime time;
}