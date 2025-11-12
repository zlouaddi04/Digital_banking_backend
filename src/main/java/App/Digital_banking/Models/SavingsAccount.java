package App.Digital_banking.Models;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;


@Entity
@DiscriminatorValue("SAVINGS")
@Getter @Setter @ToString
@NoArgsConstructor
public class SavingsAccount extends Account {
    private Double interestRate;





}
