package App.Digital_banking.Services;

import App.Digital_banking.DTO.ClientRequest;
import App.Digital_banking.DTO.ClientResponse;
import App.Digital_banking.Exceptions.ClientExceptions.ClientAlreadyExistsException;
import App.Digital_banking.Mappers.ClientMapper;
import App.Digital_banking.Models.Client;
import App.Digital_banking.Repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class ClientService {
    final ClientRepository clientRepository;
    final PasswordEncoder passwordEncoder;
    final ClientMapper clientMapper;


    @Transactional
    public ClientResponse create_client(ClientRequest clientRequest){
        Client client=clientMapper.toEntity(clientRequest);
        if (clientRepository.existsByCIN(client.getCIN()))
            throw new ClientAlreadyExistsException("Client already exists");
        String hashed=passwordEncoder.encode(client.getPassword());
        client.setPassword(hashed);
        Client client_added=clientRepository.save(client);
        return clientMapper.toResponse(client_added);
    }






}
