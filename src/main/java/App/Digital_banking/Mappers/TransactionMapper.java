package App.Digital_banking.Mappers;

import App.Digital_banking.DTO.TransactionRequest;
import App.Digital_banking.DTO.TransactionResponse;
import App.Digital_banking.Models.Transactions;
import org.hibernate.Transaction;

public class TransactionMapper {

    public TransactionResponse toTransactionResponse (Transactions T){
        return new TransactionResponse(
                T.getType().name(),
                T.getTransaction_Reference(),
                T.getTimestamp(),
                T.getAccount().getAccount_id(),
                T.getDestination_account() != null ? T.getDestination_account().getAccount_id() : null,
                T.getAmount()
        );

    }

    public Transactions toEntity(TransactionRequest R){
        Transactions T=new Transactions();
        T.setAmount(R.amount());
        T.setType(R.type());
        return T;
    }
}
