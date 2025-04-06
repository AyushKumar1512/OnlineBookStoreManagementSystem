package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Event;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Book;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class LowStockEvent extends ApplicationEvent {

    private final Book book;
    public LowStockEvent(Object source, Book book) {
        super(source);
        this.book = book;
    }
}
