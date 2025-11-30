package App.Digital_banking.Exceptions;

import App.Digital_banking.Exceptions.ClientExceptions.*;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
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

    @ExceptionHandler(ClientAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleClientAlreadyExistsException(ClientAlreadyExistsException ex){
        ErrorResponse Error=new ErrorResponse();
        Error.setHttpStatus(HttpStatus.CONFLICT.value());
        Error.setErrorcode("CLIENT_ALREADY_EXISTS");
        Error.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(Error);
    }



    //Account_Exceptions
    //Transaction_Exception



    //General_Exceptions

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handleDataIntegrity(DataIntegrityViolationException ex) {
        ErrorResponse Error=new ErrorResponse();
        Error.setMessage(ex.getMessage());
        Error.setErrorcode("DATABASE_CONSTRAINT_VIOLATED");
        Error.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleValidation(ConstraintViolationException ex) {
        ErrorResponse Error=new ErrorResponse();
        Error.setMessage(ex.getMessage());
        Error.setErrorcode("VALIDATION_FAILED");
        Error.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(Error);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleUnknown(Exception ex){
        ErrorResponse Error =new ErrorResponse();
        Error.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        Error.setErrorcode("SERVER_ERROR");
        Error.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Error);
    }





}
