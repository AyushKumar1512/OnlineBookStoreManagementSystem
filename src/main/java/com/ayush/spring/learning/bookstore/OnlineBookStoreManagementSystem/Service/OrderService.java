package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderItemDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Order;

import java.util.List;


public interface OrderService {

    void createOrder(List<OrderItemDto> orderList);
    List<OrderDto> fetchOrders();
}
