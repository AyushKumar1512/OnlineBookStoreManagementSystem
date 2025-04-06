package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Mapper;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderItemDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static List<OrderDto> Order_to_OrderDto(List<Order> orders){
        List<OrderDto> orderDtos = new ArrayList<>();
        for(Order order: orders){
            OrderDto orderDto = new OrderDto();
            List<OrderItemDto> items = OrderItemMapper.OrderItem_to_OrderItemDto(order.getOrderItems());
            orderDto.setOrderItems(items);
            orderDto.setUserEmail(order.getUser().getEmail());
            orderDto.setTotalPrice(order.getTotalPrice());
            orderDtos.add(orderDto);

        }
        return orderDtos;
    }
}
