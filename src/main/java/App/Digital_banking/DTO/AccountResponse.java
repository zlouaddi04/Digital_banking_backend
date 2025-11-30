package App.Digital_banking.DTO;

import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


public record AccountResponse(
        String accountNumber,
        Double balance,
        LocalDateTime creationDate,
        String status,
        Double interestRate,
        Double overdraftlimit

) {
}
