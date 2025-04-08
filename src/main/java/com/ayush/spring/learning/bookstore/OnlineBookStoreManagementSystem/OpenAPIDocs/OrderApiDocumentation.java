package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.OpenAPIDocs;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.ErrorResponseDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderItemDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.ResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Order",
        description = "CRUD REST APIs for FETCH Order History and place new Order"
)
public interface OrderApiDocumentation {

    @Operation(summary = "Place Order ", description = "Customer create a new order")
    @ApiResponse(responseCode = "201", description = "Successful operation")
    ResponseEntity<ResponseDto> createOrder(@RequestBody @Valid List<OrderItemDto> orderList);

    @Operation(summary = "Get order History ", description = "Customer fetch order history")
    @ApiResponse(responseCode = "200", description = "Http Status Ok")
    @ApiResponse(responseCode = "500",description = "Internal Server Error",content = @Content(
            schema = @Schema(implementation = ErrorResponseDto.class)
    ))
    ResponseEntity<List<OrderDto>> getAllOrders();
}
