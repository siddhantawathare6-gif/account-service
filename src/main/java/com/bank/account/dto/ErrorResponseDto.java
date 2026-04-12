package com.bank.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
@Schema(
        name = "ErrorResponse",
        description = "Scheme to hold error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by client"
    )
    private String apiPath;

    @Schema(
            description = "errorCode represent the error happened"
    )

    private HttpStatus errorCode;

    @Schema(
            description = "errorMessage represent the error happened"
    )
    private String errorMessage;

    @Schema(
            description = "errorTime represent the error happened"
    )
    private LocalDateTime errorTime;

}

