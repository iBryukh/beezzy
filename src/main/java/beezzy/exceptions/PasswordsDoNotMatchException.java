package beezzy.exceptions;

/**
 * Created by Polomani on 24.04.2016.
 */
public class PasswordsDoNotMatchException extends Exception {

    public PasswordsDoNotMatchException(){
        this(DEFAULT_MESSAGE);
    }

    public PasswordsDoNotMatchException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "Old password isn't correct";

}