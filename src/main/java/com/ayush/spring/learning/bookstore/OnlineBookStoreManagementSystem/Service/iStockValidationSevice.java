package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Book;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Role;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.User;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Event.LowStockEvent;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository.UserRepository;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class iStockValidationSevice {

    private final UserRepository userRepository;

    public iStockValidationSevice(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @EventListener
    public void stockValidation(LowStockEvent lowStockEvent){
        Book book = lowStockEvent.getBook();
        List<User> admins = userRepository.findAll().stream().filter(user->user.getRole()== Role.ADMIN).toList();

        for(User admin:admins){
            sendNotification(admin.getEmail(),book);
        }
    }

    public void sendNotification(String email, Book book){
        System.out.println("Alert: Stock for book " + book.getTitle()
                +" is went below 5 only "+ book.getQuantity()+" copies left. Notifying Admin: " + email);
    }
}
