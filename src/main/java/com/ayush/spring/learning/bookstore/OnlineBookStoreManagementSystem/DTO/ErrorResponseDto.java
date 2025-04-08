package com.ayush.spring.learning.bookstore.OnlineBookStoreManagementSystem.DTO;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "Error Response",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(description = "Api path detail")
    private String apiPath;
    @Schema(description = "Http status code")
    private HttpStatus httpStatus;
    @Schema(description = "Error message")
    private String errorMessage;
    @Schema(description = "Time of error occurred")
    private LocalDateTime errorTime;

}
