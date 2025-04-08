package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Data
@Schema(
        name = "Book",
        description = "Schema to hold book information"
)
public class BookDto implements Serializable {

    @Schema(description = "Title of the book",example = "To Kill a Mockingbird")
    @NotBlank(message = "Title should not be leave blank!")
    @Size(min = 5, max = 50)
    private String title;

    @Schema(description = "Author of the book",example = "Harper Lee")
    @NotBlank(message = "Author should not be leave blank!")
    @Size(min = 5, max = 50)
    private String author;

    @Schema(description = "Genre of the book",example = "Fiction")
    @NotBlank(message = "genre should not be leave blank!")
    @Size(min = 5, max = 50)
    private String genre;

    @Schema(description = "Price of the book",example = "300")
    @Min(value = 1,message = "price must be greater than 0")
    private double price;

    @Schema(description = "Quantity of the book",example = "20")
    @Min(value = 1, message = "Quantity must be greater than 0")
    private int quantity;

}
