package App.Digital_banking.Mappers;

import App.Digital_banking.DTO.ClientResponse;
import App.Digital_banking.Models.Client;

public class ClientMapper {

    public ClientResponse toResponse(Client client) {
        return new ClientResponse(
                client.getClient_id(),
                client.getUsername(),
                client.getCIN(),
                client.getEmail()
        );
    }

    public Client toEntity(ClientResponse){

    }
}
