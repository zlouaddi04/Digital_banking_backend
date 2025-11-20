package App.Digital_banking.DTO;

import App.Digital_banking.Models.Account;
import App.Digital_banking.Models.Transactions;

public record TransactionRequest (
        Transactions.Transaction_Type type,
        Double amount,
        Long Source_account_id,
        Long Destination_account_id
){

}
