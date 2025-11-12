package App.Digital_banking.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Client_id;

    private String username;
    @Column(unique = true, nullable = false)
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




}
