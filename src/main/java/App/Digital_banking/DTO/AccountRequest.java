package App.Digital_banking.DTO;


import App.Digital_banking.Models.Account;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record AccountRequest(
        @NotBlank(message = "account type is required")
        @JsonAlias({"Type","type"})
        Account.account_type type,

        @NotBlank(message = "Client CIN is required")
        @JsonAlias({"client_CIN","Client_CIN"})
        String client_CIN,

        @JsonAlias({"overdraft","Overdraft"})
        Double overdraftLimit,

        @JsonAlias({"Interest_rate","interest_rate"})
        Double interestRate


) {
}
