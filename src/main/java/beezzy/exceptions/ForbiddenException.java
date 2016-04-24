package beezzy.exceptions;

/**
 * Created by oleh on 06.04.2016.
 */
public class ForbiddenException extends Exception {

    public ForbiddenException(){
        this(DEFAULT_MESSAGE);
    }

    public ForbiddenException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "This resource is forbidden for You";

}
