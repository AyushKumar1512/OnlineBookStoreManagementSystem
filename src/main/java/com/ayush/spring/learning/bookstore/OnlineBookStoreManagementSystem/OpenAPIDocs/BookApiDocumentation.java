package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.OpenAPIDocs;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.BookDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Book",
        description = "CRUD REST APIs for FETCH, ADD, DELETE, UPDATE books"
)
public interface BookApiDocumentation {

    @Operation(summary = "Add Book ", description = "Add a Book")
    @ApiResponse(responseCode = "201", description = "Successful operation")
    ResponseEntity<ResponseDto> createBook(@Valid @RequestBody BookDto bookDto);


    @Operation(summary = "Update Book ", description = "Update a Book")
    @ApiResponse(responseCode = "202", description = "Successful operation")
    @ApiResponse(responseCode = "402", description = "Expectation Failed")
    ResponseEntity<ResponseDto> updateBook(@Valid @RequestBody BookDto bookDto);

    @Operation(summary = "Delete Book ", description = "Delete a Book")
    @ApiResponse(responseCode = "203", description = "Successful operation")
    @ApiResponse(responseCode = "403", description = "Expectation Failed")
    ResponseEntity<ResponseDto> deleteBook(@RequestParam
                                           @NotBlank(message = "Title should not be leave blank!")
                                           @Size(min = 5, max = 50) String bookTitle);

    @Operation(summary = "Get all Books ", description = "Fetch all Books")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    ResponseEntity<List<BookDto>> fetchAllBooks();


    @Operation(summary = "Get all Books by Author ", description = "Fetch all Books by Author")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    ResponseEntity<List<BookDto>> fetchBooksByAuthor(@RequestParam @NotBlank(message = "Author should not be leave blank!")
                                                     @Size(min = 5, max = 50) String bookAuthor);

    @Operation(summary = "Get all Books by Genre ", description = "Fetch all Books by Genre")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    ResponseEntity<List<BookDto>> fetchBooksByGenre(@RequestParam @NotBlank(message = "genre should not be leave blank!")
                                                    @Size(min = 5, max = 50)
                                                    String bookGenre);

    @Operation(summary = "Get Book by title ", description = "Fetch Book by Title")
    @ApiResponse(responseCode = "200", description = "Successful operation")
    ResponseEntity<BookDto> fetchBooksByTitle(@RequestParam @NotBlank(message = "Title should not be leave blank!")
                                              @Size(min = 5, max = 50) String bookTitle);

}
