package com.bank.account.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Account",
        description = "scheme to hold account information"
)
public class AccountDto {

    @Schema(
            description = "AccountNumber cannot be empty or null",example = "1234567890"
    )
    @NotEmpty(message = "AccountNumber cannot be empty or null")
    @Pattern(regexp = "(^$|[0-9]{10})",message = "AccountNumber must be 10 digit")
    private Long accountNumber;

    @Schema(
            description = "AccountType cannot be null or empty",example = "saving"
    )
    @NotEmpty(message = "AccountType cannot be null or empty")
    private String accountType;

    @Schema(
            description = "BranchAddress cannot be null or empty",example = "123 new york"
    )
    @NotEmpty(message = "BranchAddress cannot be null or empty")
    private String branchAddress;

}
