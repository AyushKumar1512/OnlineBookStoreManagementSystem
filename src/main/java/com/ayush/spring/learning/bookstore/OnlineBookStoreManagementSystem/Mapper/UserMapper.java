package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Mapper;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.UserDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Role;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.User;

public class UserMapper {

    public static User UserDto_To_User(UserDto userDto, User user, Role role){
       user.setEmail(userDto.getEmail());
       user.setName(userDto.getName());
       user.setPassword(userDto.getPassword());
       user.setRole(role);
       return user;

    }

    public static UserDto User_To_UserDto(User user, UserDto userDto){
        userDto.setEmail(user.getEmail());
        userDto.setName(user.getName());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

}
