package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(name = "Order Item",description = "Schema to hold order item information")
public class OrderItemDto {

    @Schema(description = "Title of book")
    @NotBlank(message = "Title should not be leave blank!")
    @Size(min = 5, max = 50)
    private String title;

    @Schema(description = "Quantity ordered")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;
}
