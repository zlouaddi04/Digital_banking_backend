package App.Digital_banking.Services;

import App.Digital_banking.DTO.AccountRequest;
import App.Digital_banking.DTO.AccountResponse;
import App.Digital_banking.Exceptions.ClientExceptions.ClientNotFoundException;
import App.Digital_banking.Mappers.AccountMapper;
import App.Digital_banking.Models.Account;
import App.Digital_banking.Models.CheckingsAccount;
import App.Digital_banking.Models.Client;
import App.Digital_banking.Models.SavingsAccount;
import App.Digital_banking.Repositories.AccountRepository;
import App.Digital_banking.Repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService {

    final AccountRepository accountRepository;
    final ClientRepository clientRepository;
    final AccountMapper accountMapper;

    public String GenerateAccountNumber(Account.account_type type){
        long seq=System.currentTimeMillis();
        String prefix=String.valueOf(type);
        return prefix+seq;
    }





    @Transactional
    public AccountResponse add_account(AccountRequest accountRequest){
        AccountResponse accountResponse;
        switch (accountRequest.type()){
            case SAVINGS :
                accountResponse=add_savings_account(accountRequest);
            default:
                accountResponse=add_checkings_account(accountRequest);
        }
        return accountResponse;
    }
    public AccountResponse add_savings_account(AccountRequest accountRequest){
        Optional<Client> client=clientRepository.findByCIN(accountRequest.client_CIN());
        if(client.isEmpty())
            throw new ClientNotFoundException("Client not found");
        SavingsAccount account = accountMapper.toSavingEntity(accountRequest);
        account.setAccountNumber(GenerateAccountNumber(Account.account_type.SAVINGS));
        account.setOwner(client.get());
        SavingsAccount saved_account=accountRepository.save(account);
        return accountMapper.toSavAccountResponse(saved_account);

    }

    public AccountResponse add_checkings_account(AccountRequest accountRequest){
        Optional<Client> client=clientRepository.findByCIN(accountRequest.client_CIN());
        if(client.isEmpty())
            throw new ClientNotFoundException("Client not found");
        CheckingsAccount account=accountMapper.toCheckingEntity(accountRequest);
        account.setAccountNumber(GenerateAccountNumber(Account.account_type.CHECKINGS));
        account.setStatus(Account.account_status.ACTIVE);
        account.setOwner(client.get());
        CheckingsAccount saved_account=accountRepository.save(account);
        return accountMapper.toCheckAccountResponse(saved_account);

    }
}
