package App.Digital_banking.DTO;


public record AccountRequest(
        String type,
        Long clientId,
        Double overdraftLimit,
        Double interestRate


) {
}
