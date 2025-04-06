package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Mapper;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderItemDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemMapper {

    public static List<OrderItemDto> OrderItem_to_OrderItemDto(List<OrderItem> orderItem){
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        for(OrderItem orderItem1:orderItem){
            OrderItemDto orderDto = new OrderItemDto();
            orderDto.setTitle(orderItem1.getBook().getTitle());
            orderDto.setQuantity(orderItem1.getQuantity());
            orderItemDtos.add(orderDto);
        }
        return orderItemDtos;
    }
}
