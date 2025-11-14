package App.Digital_banking.Mappers;

import App.Digital_banking.DTO.ClientRequest;
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

    public Client toEntity(ClientRequest clientRequest){
        Client client=new Client();
        client.setUsername(clientRequest.username());
        client.setCIN(clientRequest.cin());
        client.setEmail(clientRequest.email());
        client.setPassword(clientRequest.password());

        return client;
    }
}
