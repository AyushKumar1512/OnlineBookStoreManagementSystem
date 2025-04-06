package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
    private String status;
    private String message;
}
