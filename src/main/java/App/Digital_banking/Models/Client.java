package App.Digital_banking.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Client_id;

    private String username;

    @Column(name = "CIN",unique = true, nullable = false)
    private String CIN;

    private String email;

    private String Password;


    @OneToMany(
            mappedBy = "owner",
            cascade= CascadeType.PERSIST,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<Account> accounts=new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(CIN, client.CIN);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CIN);
    }
}
