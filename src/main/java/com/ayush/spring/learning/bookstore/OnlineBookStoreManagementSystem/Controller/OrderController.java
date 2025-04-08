package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Controller;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Constants.OrderConstant;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderItemDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.ResponseDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.OpenAPIDocs.OrderApiDocumentation;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service.OrderService;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Utils.CurrentUser;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/order", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@AllArgsConstructor
public class OrderController implements OrderApiDocumentation {


    private final OrderService orderService;

    @PostMapping("/placeOrder")
    public ResponseEntity<ResponseDto> createOrder(@RequestBody @Valid List<OrderItemDto> orderList){
        orderService.createOrder(orderList);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(OrderConstant.Status_201,OrderConstant.Message_201));
    }

    @GetMapping("/orderHistory")
    public ResponseEntity<List<OrderDto>> getAllOrders(){
        List<OrderDto> allOrders = orderService.fetchOrders();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allOrders);
    }


}
