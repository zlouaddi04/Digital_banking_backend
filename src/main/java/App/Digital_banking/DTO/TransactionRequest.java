package App.Digital_banking.DTO;

import App.Digital_banking.Models.Account;
import App.Digital_banking.Models.Transactions;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;

public record TransactionRequest (

        @NotBlank(message = "Transaction type is required")
        @JsonAlias({"Type","type"})
        Transactions.Transaction_Type type,

        @NotBlank(message = "Amount is required")
        @JsonAlias({"amount","Amount"})
        Double amount,

        @NotBlank(message = "Source account is required")
        @JsonAlias({"Source_account_id","source_account_id"})
        Long Source_account_id,

        @JsonAlias({"Destination_account_id","destination_accounr_id"})
        Long Destination_account_id
){

}
