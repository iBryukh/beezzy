package beezzy.exceptions;

/**
 * Created by oleh on 06.04.2016.
 */
public class UnauthorizedException extends Exception {

    public UnauthorizedException(){
        this(DEFAULT_MESSAGE);
    }

    public UnauthorizedException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "You should authorize before use this resource";

}
