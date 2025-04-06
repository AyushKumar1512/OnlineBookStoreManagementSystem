package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class OrderDto {

    List<OrderItemDto> orderItems;
    double totalPrice;
    String userEmail;
}
