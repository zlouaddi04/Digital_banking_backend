package App.Digital_banking.Mappers;

import App.Digital_banking.DTO.AccountRequest;
import App.Digital_banking.DTO.AccountResponse;
import App.Digital_banking.Models.Account;
import App.Digital_banking.Models.CheckingsAccount;
import App.Digital_banking.Models.SavingsAccount;

import java.time.LocalDateTime;

public class AccountMapper {


    public CheckingsAccount toCheckingEntity(AccountRequest accountRequest){
        CheckingsAccount checkingsAccount = new CheckingsAccount();
        checkingsAccount.setBalance(0);
        checkingsAccount.setCreatedAt(LocalDateTime.now());
        checkingsAccount.setOverdraftLimit(accountRequest.overdraftLimit());
        return checkingsAccount;
    }

    public SavingsAccount toSavingEntity(AccountRequest accountRequest){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setBalance(0);
        savingsAccount.setCreatedAt(LocalDateTime.now());
        savingsAccount.setInterestRate(accountRequest.interestRate());
        return savingsAccount;
    }

    public AccountResponse toCheckAccountResponse(CheckingsAccount checkingsAccount){
        return new AccountResponse(
                checkingsAccount.getAccountNumber(),
                checkingsAccount.getBalance(),
                checkingsAccount.getCreatedAt(),
                checkingsAccount.getStatus().toString(),
                null,
                checkingsAccount.getOverdraftLimit()

        );
    }


    public AccountResponse toSavAccountResponse (SavingsAccount savingsAccount){
        return new AccountResponse(
                savingsAccount.getAccountNumber(),
                savingsAccount.getBalance(),
                savingsAccount.getCreatedAt(),
                savingsAccount.getStatus().toString(),
                savingsAccount.getInterestRate(),
                null


        );
    }
}
