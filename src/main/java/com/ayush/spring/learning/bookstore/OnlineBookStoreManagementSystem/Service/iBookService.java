package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.BookDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Book;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Exception.AlreadyExistException;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Exception.ResourceNotFoundException;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Mapper.BookMapper;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class iBookService implements BookService{

    private final BookRepository bookRepository;


    @Override
    @Transactional
    @CacheEvict(value = {"books","allBooks"}, allEntries = true)
    public void createBook(BookDto bookDto) {
        Book book = BookMapper.BookDto_To_Book(bookDto,new Book());
        Optional<Book> searchBook = bookRepository.findByTitle(bookDto.getTitle());
        if(searchBook.isPresent()){
            throw new AlreadyExistException("Book already exists by title "+bookDto.getTitle());
        }
        Book savedBook = bookRepository.save(book);

    }

    @Override
    @Transactional
    @CachePut(value = "books", key ="#bookDto.title")
    @CacheEvict(value = "allBooks", allEntries = true)
    public boolean updateBook(BookDto bookDto) {
        boolean isUpdated;
        Optional<Book> book = bookRepository.findByTitle(bookDto.getTitle());
        if(book.isPresent()==false){
            throw new ResourceNotFoundException("Book doesn't exists by title "+bookDto.getTitle());
        }
        Book updatedBook = BookMapper.BookDto_To_Book(bookDto,book.get());
        bookRepository.save(updatedBook);
        isUpdated = true;

        return isUpdated;
    }

    @Override
    @Transactional
    @CacheEvict(value = {"books","allBooks"},allEntries = true)
    public boolean deleteBook(String BookTitle) {
        boolean isDeleted;
        Optional<Book> book = bookRepository.findByTitle(BookTitle);
        if(book.isPresent()==false){
            throw new ResourceNotFoundException("Book doesn't exists by title "+BookTitle);
        }
        bookRepository.deleteById(book.get().getId());
        isDeleted=true;
        return isDeleted;
    }

    @Override
    @Cacheable(value = "allBooks")
    public List<BookDto> fetchAllBooks() {
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){
            throw new ResourceNotFoundException("Currently no Books available in the stock");
        }
        List<BookDto> BooksList= new ArrayList<>();
        for(Book book:books){
            BooksList.add(BookMapper.Book_To_BookDto(book,new BookDto()));
        }
        return BooksList;
    }

    @Override
    public BookDto fetchBooksByTitle(String title) {
        Optional<Book> book = bookRepository.findByTitle(title);
        if(book.isEmpty()){
            throw new ResourceNotFoundException("Book is not available by title "+title);
        }
        BookDto bookDto = BookMapper.Book_To_BookDto(book.get(),new BookDto());
        return bookDto;
    }

    @Override
    @Cacheable(value = "books", key = "'author_' + #author")
    public List<BookDto> fetchBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthor(author);
        if(books.isEmpty()){
            throw new ResourceNotFoundException("Currently no Books available by author "+author);
        }
        List<BookDto> BooksList= new ArrayList<>();
        for(Book book:books){
            BooksList.add(BookMapper.Book_To_BookDto(book,new BookDto()));
        }
        return BooksList;
    }

    @Override
    @Cacheable(value = "books", key = "'genre_'+#genre")
    public List<BookDto> fetchBooksByGenre(String genre) {
        List<Book> books = bookRepository.findByGenre(genre);
        if(books.isEmpty()){
            throw new ResourceNotFoundException("Currently no Books available of genre "+genre);
        }
        List<BookDto> BooksList= new ArrayList<>();
        for(Book book:books){
            BooksList.add(BookMapper.Book_To_BookDto(book,new BookDto()));
        }
        return BooksList;
    }
}
