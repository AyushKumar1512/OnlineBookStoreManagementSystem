package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Data;


@Data
@Schema(name = "User",description = "Schema to hold user information")
public class UserDto {

    @Schema(description = "Name of the user")
    @NotBlank(message = "Name field must not leave blank!")
    @Size(min = 4, max = 30,message = "Characters in name should be Greater than 3")
    private String name;

    @Schema(description = "Email address of the user")
    @NotBlank(message = "Email address can not be a null or empty")
    @Email(message = "Email address should be a valid")
    private String email;

    @Schema(description = "Password of the user")
    @NotBlank(message = "Password field must not leave blank!")
    @Size(min = 8, max = 30,message = "Password must be greater than or equal to 8 characters")
    private String Password;

}
