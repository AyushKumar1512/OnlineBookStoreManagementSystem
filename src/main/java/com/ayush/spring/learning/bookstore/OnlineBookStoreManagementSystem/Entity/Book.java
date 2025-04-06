package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//*Book Entity*: Each book should have the following attributes:
//        - ID (auto-generated)
//  - Title
//  - Author
//  - Genre
//  - Price
//  - Quantity in stock

@Entity
@Table(name = "books")
@Getter @Setter
@ToString @AllArgsConstructor @NoArgsConstructor
public class Book extends AuditClass{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "genre")
    private String genre;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "quantity", nullable = false)
    private int quantity;

}
