package App.Digital_banking.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "ACCOUNT_TYPE",discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Account_id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    private double balance;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private account_status status;


    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "Client_id", referencedColumnName = "Client_id",nullable = false)
    private Client owner;

    @OneToMany(mappedBy = "account",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<Transactions> Outgoingtransactions=new ArrayList<>();

    @OneToMany(mappedBy = "Destination_account",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private List<Transactions> Incomingtransactions=new ArrayList<>();

    public enum account_status {
        ACTIVE,
        INACTIVE,
        SUSPENDED
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) && Objects.equals(createdAt, account.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, createdAt);
    }
}
