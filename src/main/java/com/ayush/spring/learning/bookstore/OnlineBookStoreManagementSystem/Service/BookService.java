package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.BookDto;

import java.util.List;

public interface BookService {


    void createBook(BookDto bookDto);

    boolean updateBook(BookDto bookDto);

    boolean deleteBook(String BookName);

    List<BookDto> fetchAllBooks();

    BookDto fetchBooksByTitle(String title);

    List<BookDto> fetchBooksByAuthor(String author);

    List<BookDto> fetchBooksByGenre(String genre);
}



