package App.Digital_banking.Models;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@DiscriminatorValue("CHECKINGS")
@Getter @Setter @ToString
@NoArgsConstructor
public class CheckingsAccount {
    private Double overdraftLimit;
}
