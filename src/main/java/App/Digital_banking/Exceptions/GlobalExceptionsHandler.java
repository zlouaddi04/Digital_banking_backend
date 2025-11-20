package App.Digital_banking.Exceptions;

import App.Digital_banking.Exceptions.ClientExceptions.ClientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalExceptionsHandler {


    //Client_Exceptions

    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleClientNotFoundException(ClientNotFoundException ex){
        ErrorResponse Error=new ErrorResponse();
        Error.setHttpStatus(HttpStatus.NOT_FOUND.value());
        Error.setMessage(ex.getMessage());
        Error.setErrorcode("CLIENT_NOT_FOUND");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Error);
    }



    //Account_Exceptions
    //Transaction_Exception


}
