package App.Digital_banking.DTO;

public record ClientResponse(
        Long clientId,
        String username,
        String cin,
        String email
) {
}
