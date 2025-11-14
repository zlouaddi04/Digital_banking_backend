package App.Digital_banking.DTO;

import java.time.LocalDateTime;

public record CheckAccountResponse(
        String accountNumber,
        Double balance,
        LocalDateTime creationDate,
        String status,
        Double overdraftlimit
) {
}
