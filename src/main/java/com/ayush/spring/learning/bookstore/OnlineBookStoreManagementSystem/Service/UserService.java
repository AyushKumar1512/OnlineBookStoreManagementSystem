package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.UserDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Role;


public interface UserService {
    void addUser(UserDto userDto, Role role);
}
