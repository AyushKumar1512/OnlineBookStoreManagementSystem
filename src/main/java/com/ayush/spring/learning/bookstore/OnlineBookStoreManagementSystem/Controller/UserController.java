package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Controller;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Constants.UserConstants;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.ResponseDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.UserDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Entity.Role;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/user", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/customerRegistration")
    public ResponseEntity<ResponseDto> addCustomer(@RequestBody @Valid UserDto userDto){
        userService.addUser(userDto,Role.CUSTOMER);
        System.out.println("Ayush");
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(UserConstants.Status_201,UserConstants.Message_201));
    }

    @PostMapping("/adminRegistration")
    public ResponseEntity<ResponseDto> addAdmin(@RequestBody @Valid UserDto userDto){
        userService.addUser(userDto,Role.ADMIN);
        System.out.println("Ayush");
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(UserConstants.Status_202,UserConstants.Message_202));
    }
}
