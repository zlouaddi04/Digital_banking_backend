package App.Digital_banking.Exceptions.ClientExceptions;

public class ClientAlreadyExistsException extends RuntimeException {
    public ClientAlreadyExistsException (String message){
        super(message);
    }
}
