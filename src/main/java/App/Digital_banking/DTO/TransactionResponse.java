package App.Digital_banking.DTO;

import java.time.LocalDateTime;


public record TransactionResponse (
        String type,
        String Transaction_reference,
        LocalDateTime time_stamp,
        Long account_id,
        Long Destination_account_id,
        Double amount

) {
}
