package App.Digital_banking.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Transactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transaction_id;

    private Double Amount;
    private Transaction_Type Type;
    private String Transaction_Reference;
    private LocalDateTime timestamp;

    @ManyToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST
    )
    @JoinColumn(name = "Account_id", referencedColumnName = "Account_id", nullable = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Destination_account_id", referencedColumnName = "Account_id")
    private String Destination_account;



    protected enum Transaction_Type {
        DEPOSIT,
        WITHDRAWAL,
        TRANSFER
    }
    protected enum transaction_status {
        PENDING,
        COMPLETED,
        FAILED
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return Objects.equals(Transaction_Reference, that.Transaction_Reference);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Transaction_Reference);
    }
}

