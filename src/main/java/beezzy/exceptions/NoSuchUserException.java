package beezzy.exceptions;

/**
 * Created by Polomani on 23.04.2016.
 */
public class NoSuchUserException extends Exception {

    public NoSuchUserException(){
        this(DEFAULT_MESSAGE);
    }

    public NoSuchUserException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "No user with these credentials are registered.";

}