package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
public class BookDto {

    @NotBlank(message = "Title should not be leave blank!")
    @Size(min = 5, max = 50)
    private String title;

    @NotBlank(message = "Author should not be leave blank!")
    @Size(min = 5, max = 50)
    private String author;

    @NotBlank(message = "genre should not be leave blank!")
    @Size(min = 5, max = 50)
    private String genre;

    @Min(value = 1,message = "price must be greater than 0")
    private double price;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;

}
