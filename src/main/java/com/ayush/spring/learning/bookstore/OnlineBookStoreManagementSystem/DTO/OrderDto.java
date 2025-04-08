package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Schema(
        name = "Order",
        description = "Schema to hold order information"
)
public class OrderDto {

    @Schema(description = "List of order items")
    List<OrderItemDto> orderItems;
    @Schema(description = "Total price")
    double totalPrice;
    @Schema(description = "Email address of customer")
    String userEmail;
}
