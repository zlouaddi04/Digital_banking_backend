package App.Digital_banking.Exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data @AllArgsConstructor @NoArgsConstructor
public class ErrorResponse {
    private int httpStatus;
    private String message;
    private String errorcode;
    private LocalDateTime timestamp=LocalDateTime.now();
}
