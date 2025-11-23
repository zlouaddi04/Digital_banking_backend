package App.Digital_banking.Services;

import App.Digital_banking.DTO.ClientRequest;
import App.Digital_banking.DTO.ClientResponse;
import App.Digital_banking.Exceptions.ClientExceptions.ClientAlreadyExistsException;
import App.Digital_banking.Mappers.ClientMapper;
import App.Digital_banking.Models.Client;
import App.Digital_banking.Repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientService {
    final ClientRepository clientRepository;
    final PasswordEncoder passwordEncoder;
    final ClientMapper clientMapper;



    public ClientResponse add_client(ClientRequest clientRequest){
        Client client=clientMapper.toEntity(clientRequest);
        if (clientRepository.findByCIN(client.getCIN()).isPresent())
            throw new ClientAlreadyExistsException("Client already exists");
        String hashed=passwordEncoder.encode(client.getPassword());
        client.setPassword(hashed);

    }

}
