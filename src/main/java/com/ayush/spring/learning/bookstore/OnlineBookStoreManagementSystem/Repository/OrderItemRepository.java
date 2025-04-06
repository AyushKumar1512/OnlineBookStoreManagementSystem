package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
