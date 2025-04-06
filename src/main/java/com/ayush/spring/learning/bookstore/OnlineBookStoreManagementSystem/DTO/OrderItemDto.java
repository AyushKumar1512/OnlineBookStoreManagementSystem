package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class OrderItemDto {

    @NotBlank(message = "Title should not be leave blank!")
    @Size(min = 5, max = 50)
    private String title;

    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;
}
