package App.Digital_banking.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientRequest(
        @NotBlank(message = "username is required")
        @JsonAlias({"username","user_name","user"})
        String username,

        @NotBlank(message="cin is required")
        @JsonAlias({"cin","Cin"})
        String cin,

        @NotBlank(message = "email is required")
        @JsonAlias({"email","Email"})
        String email,

        @NotBlank(message = "password is required")
        @JsonAlias({"password","Password","pass_word"})
        String password
) {
}
