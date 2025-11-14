package App.Digital_banking.Mappers;

import App.Digital_banking.DTO.AccountRequest;
import App.Digital_banking.DTO.CheckAccountResponse;
import App.Digital_banking.Models.CheckingsAccount;
import App.Digital_banking.Models.SavingsAccount;

public class AccountMapper {


    public CheckingsAccount toCheckingsEntity(AccountRequest accountRequest){
        CheckingsAccount checkingsAccount = new CheckingsAccount();
        checkingsAccount.setOverdraftLimit(accountRequest.overdraftLimit());
        return checkingsAccount;
    }

    public SavingsAccount toSavingsEntity(AccountRequest accountRequest){
        SavingsAccount savingsAccount = new SavingsAccount();
        savingsAccount.setInterestRate(accountRequest.interestRate());
        return savingsAccount;
    }

    public CheckAccountResponse toCheckAccountResponse(CheckingsAccount checkingsAccount){
        return new CheckAccountResponse(
                checkingsAccount.getAccountNumber(),
                checkingsAccount.getBalance(),
                checkingsAccount.getCreatedAt(),
                checkingsAccount.getStatus().toString(),
                checkingsAccount.getOverdraftLimit()
        );
    }
}
