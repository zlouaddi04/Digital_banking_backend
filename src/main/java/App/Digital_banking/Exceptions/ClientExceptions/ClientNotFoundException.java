package App.Digital_banking.Exceptions.ClientExceptions;

public class ClientNotFoundException extends RuntimeException{
    public ClientNotFoundException (String message){
        super(message);
    }
}
