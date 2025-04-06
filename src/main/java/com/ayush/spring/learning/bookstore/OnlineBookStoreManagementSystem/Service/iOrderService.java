package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.OrderItemDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.*;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Event.LowStockEvent;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Exception.ResourceNotFoundException;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Exception.StockNotAvailableException;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Mapper.OrderMapper;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository.BookRepository;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository.OrderRepository;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository.UserRepository;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Utils.CurrentUser;
import com.sun.source.doctree.UnknownBlockTagTree;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class iOrderService implements OrderService{

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;
    private final ApplicationEventPublisher publisher;

    public iOrderService(OrderRepository orderRepository, BookRepository bookRepository, UserRepository userRepository, ApplicationEventPublisher publisher) {
        this.orderRepository = orderRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.publisher = publisher;
    }

    @Override
    @Transactional
    public void createOrder(List<OrderItemDto> orderList) {

        List<OrderItem> orderItems = new ArrayList<>();
        String userEmail = CurrentUser.getCurrentUsername();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + userEmail));

        Order order = new Order();
        order.setUser(user);
        order.setOrderDate(LocalDateTime.now());
        double totalPrice = 0.0;

        for (OrderItemDto items : orderList) {
            Book book = bookRepository.findByTitle(items.getTitle())
                    .orElseThrow(() -> new ResourceNotFoundException("Book not found with title: " + items.getTitle()));


            if (book.getQuantity() < items.getQuantity()) {
                throw new StockNotAvailableException("Insufficient Stock. Only " + book.getQuantity() + " copies available of " + book.getTitle());
            }
            book.setQuantity(book.getQuantity() - items.getQuantity());
            if(book.getQuantity()<5){
                publisher.publishEvent(new LowStockEvent(this,book));
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setBook(book);
            orderItem.setQuantity(items.getQuantity());
            orderItems.add(orderItem);

            totalPrice += book.getPrice() * items.getQuantity();
        }

        order.setTotalPrice(totalPrice);

        order = orderRepository.save(order);

        for (OrderItem item : orderItems) {
            item.setOrder(order);
        }

        order.setOrderItems(orderItems);
        orderRepository.save(order);
        bookRepository.saveAll(orderItems.stream().map(OrderItem::getBook).collect(Collectors.toList()));

    }

    @Override
    public List<OrderDto> fetchOrders() {
        String userEmail = CurrentUser.getCurrentUsername();
        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with email: " + userEmail));
        List<Order> listOfOrders;
        if(user.getRole().equals(Role.CUSTOMER)){
            listOfOrders = orderRepository.findByUserId(user.getId());
        }

        else{
            listOfOrders = orderRepository.findAll();
        }
        System.out.println("Orders fetched: " + listOfOrders.size());
        if(listOfOrders.isEmpty()){
            throw new ResourceNotFoundException("Currently no order is placed by email "+userEmail);
        }
        return OrderMapper.Order_to_OrderDto(listOfOrders);
    }
}
