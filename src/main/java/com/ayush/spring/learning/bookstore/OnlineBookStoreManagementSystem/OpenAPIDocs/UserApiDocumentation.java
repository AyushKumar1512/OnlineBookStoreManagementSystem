package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.OpenAPIDocs;


import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.ResponseDto;
import com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO.UserDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(
        name = "CRUD REST APIs for add new user",
        description = "CRUD REST APIs for new customer and admin registration"
)
public interface UserApiDocumentation {

    @Operation(summary = "Add user ", description = "Add new Customer")
    @ApiResponse(responseCode = "201", description = "Successful operation")
    ResponseEntity<ResponseDto> addCustomer(@RequestBody @Valid UserDto userDto);

    @Operation(summary = "Add user ", description = "Add new Admin")
    @ApiResponse(responseCode = "201", description = "Successful operation")
    ResponseEntity<ResponseDto> addAdmin(@RequestBody @Valid UserDto userDto);
}
