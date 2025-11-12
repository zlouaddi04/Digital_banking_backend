package App.Digital_banking.DTO;

public record ClientRequest(
        String username,
        String cin,
        String email,
        String password
) {
}
