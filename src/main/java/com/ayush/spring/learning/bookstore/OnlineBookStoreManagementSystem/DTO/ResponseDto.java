package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(name = "Response",description = "Schema to hold successful response information")
public class ResponseDto {

    @Schema(description = "status of the response",example = "200")
    private String status;
    @Schema(description = "message of the response",example = "Operation Successful")
    private String message;
}
