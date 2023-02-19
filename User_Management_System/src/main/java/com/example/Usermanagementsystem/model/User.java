package com.Usermanagementsystem.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "User_Id")
    private Integer UserId;

    @NotNull(message = "Username can't be null")
    @Size(min = 4, max = 30, message = "Username size must be between 4 and 30 characters")
    @Column(name = "User_Name", nullable = false, length = 30)
    private String username;

    @NotNull(message = "Date of birth can't be null")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth format YYYY-MM-DD")
    @Column(name = "date_of_birth", nullable = false)
    private String dateOfBirth;

    @NotNull(message = "Email can't be null")
    @Email(message = "Invalid email format")
    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @NotNull(message = "Phone number can't be null")
    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number format xx-xxxxxxxxxx with first two digits is country code")
    @Column(name = "Phone_Number", nullable = false, length = 12)
    private String phoneNumber;

    @Column(name = "Date", nullable = false)
    private LocalDate date;

    @Column(name = "Time")
    private LocalTime time;
}
