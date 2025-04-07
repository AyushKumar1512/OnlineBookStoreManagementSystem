package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service;

import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.UserDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Role;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.User;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Exception.AlreadyExistException;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Mapper.UserMapper;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@AllArgsConstructor
public class iUserService implements UserService{

    private final UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    @Transactional
    public void addUser(UserDto userDto, Role role) {

        Optional<User> user = userRepository.findByEmail(userDto.getEmail());
        if(user.isPresent()){
            throw new AlreadyExistException("User is already registered with email!  "+userDto.getEmail());
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User saveUser = UserMapper.UserDto_To_User(userDto,new User(),role);
        userRepository.save(saveUser);
    }
}
