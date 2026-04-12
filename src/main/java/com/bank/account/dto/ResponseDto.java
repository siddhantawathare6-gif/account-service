package com.bank.account.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response",
        description = "Scheme to hold successful response information"
)
public class ResponseDto {

    @Schema(
            description = "statusCode in the response"
    )
    private String statusCode;

    @Schema(
            description = "statusMsg in the response"
    )
    private String statusMsg;

}
