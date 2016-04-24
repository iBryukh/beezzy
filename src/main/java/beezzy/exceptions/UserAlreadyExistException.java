package beezzy.exceptions;

/**
 * Created by Polomani on 23.04.2016.
 */
public class UserAlreadyExistException extends Exception {

    public UserAlreadyExistException(){
        this(DEFAULT_MESSAGE);
    }

    public UserAlreadyExistException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "User with same credentials is already registered";

}