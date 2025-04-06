package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Mapper;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.BookDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Book;

public class BookMapper {

    public static Book BookDto_To_Book(BookDto bookDto, Book book){
        book.setAuthor(bookDto.getAuthor());
        book.setTitle(bookDto.getTitle());
        book.setGenre(bookDto.getGenre());
        book.setPrice(bookDto.getPrice());
        book.setQuantity(bookDto.getQuantity());
        return book;

    }
    public static BookDto Book_To_BookDto(Book book,BookDto bookDto){
        bookDto.setAuthor(book.getAuthor());
        bookDto.setTitle(book.getTitle());
        bookDto.setGenre(book.getGenre());
        bookDto.setPrice(book.getPrice());
        bookDto.setQuantity(book.getQuantity());
        return bookDto;
    }
}
