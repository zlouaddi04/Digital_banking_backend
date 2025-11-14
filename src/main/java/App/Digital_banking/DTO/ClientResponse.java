package App.Digital_banking.DTO;

import lombok.Getter;

public record ClientResponse(
        Long clientId,
        String username,
        String cin,
        String email
) {
}
