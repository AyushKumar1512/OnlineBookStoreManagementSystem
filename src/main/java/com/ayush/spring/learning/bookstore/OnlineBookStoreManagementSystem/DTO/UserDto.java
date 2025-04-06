package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import jakarta.validation.constraints.*;
import lombok.Data;


@Data
public class UserDto {

    @NotBlank(message = "Name field must not leave blank!")
    @Size(min = 4, max = 30,message = "Characters in name should be Greater than 3")
    private String name;

    @NotBlank(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid")
    private String email;

    @NotBlank(message = "Password field must not leave blank!")
    @Size(min = 8, max = 30,message = "Password must be greater than or equal to 8 characters")
    private String Password;

}
