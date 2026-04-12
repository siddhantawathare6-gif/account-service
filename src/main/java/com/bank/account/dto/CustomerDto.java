package com.bank.account.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Scheme to hold customer and account information"
)
public class CustomerDto {


    @Schema(
            description = "Name of the customer", example = "Siddhant"
    )
    @NotEmpty(message = "Name cannot be null or empty")
    @Size(min = 3, max = 30, message = "the length of customer name should be between 3 and 30")
    private String name;

    @Schema(
            description = "Email of the customer", example = "siddhant@gmail.com"
    )
    @NotEmpty(message = "email cannot be null or empty")
    @Email(message = "email should be valid")
    private String email;

    @Schema(
            description = "MobileNumber of the customer", example = "9876543210"
    )
    @Pattern(regexp = "(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Schema(
            description = "Account details of the customer"
    )
    private AccountDto accountDto;

}
