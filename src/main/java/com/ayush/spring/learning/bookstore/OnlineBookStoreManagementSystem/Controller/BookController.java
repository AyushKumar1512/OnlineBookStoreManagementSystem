package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Controller;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Constants.BookConstants;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.*;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.OpenAPIDocs.BookApiDocumentation;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service.BookService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/book", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class BookController implements BookApiDocumentation {

    private final BookService bookService;

    @PostMapping("/admin/addBook")
    public ResponseEntity<ResponseDto> createBook(@Valid @RequestBody BookDto bookDto){
        bookService.createBook(bookDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(BookConstants.Status_201,BookConstants.Message_201));
    }

    @PutMapping("/admin/updateBook")
    public ResponseEntity<ResponseDto> updateBook(@Valid @RequestBody BookDto bookDto){
        boolean isUpdated = bookService.updateBook(bookDto);
        if(isUpdated){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(BookConstants.Status_202,BookConstants.Message_202));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(BookConstants.Status_402, BookConstants.Message_402));
        }
    }

    @DeleteMapping("/admin/deleteBook")
    public ResponseEntity<ResponseDto> deleteBook(@RequestParam
                                                      @NotBlank(message = "Title should not be leave blank!")
                                                      @Size(min = 5, max = 50)String bookTitle){
        boolean isDeleted = bookService.deleteBook(bookTitle);
        if(isDeleted){
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(BookConstants.Status_203,BookConstants.Message_203));
        }
        else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(BookConstants.Status_403,BookConstants.Message_403));
        }
    }

    @GetMapping("/getAllBooks")
    public ResponseEntity<List<BookDto>> fetchAllBooks(){
        List<BookDto> books = bookService.fetchAllBooks();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(books);
    }

    @GetMapping("/getBooksByTitle")
    public ResponseEntity<BookDto> fetchBooksByTitle(@RequestParam @NotBlank(message = "Title should not be leave blank!")
                                                         @Size(min = 5, max = 50) String bookTitle){
        BookDto bookDto = bookService.fetchBooksByTitle(bookTitle);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookDto);
    }

    @GetMapping("/getBooksByAuthor")
    public ResponseEntity<List<BookDto>> fetchBooksByAuthor(@RequestParam @NotBlank(message = "Author should not be leave blank!")
                                                                @Size(min = 5, max = 50) String bookAuthor){
        List<BookDto> bookDto = bookService.fetchBooksByAuthor(bookAuthor);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookDto);
    }

    @GetMapping("/getBooksByGenre")
    public ResponseEntity<List<BookDto>> fetchBooksByGenre(@RequestParam @NotBlank(message = "genre should not be leave blank!")
                                                               @Size(min = 5, max = 50)
                                                                String bookGenre){
        List<BookDto> bookDto = bookService.fetchBooksByGenre(bookGenre);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(bookDto);
    }
}
