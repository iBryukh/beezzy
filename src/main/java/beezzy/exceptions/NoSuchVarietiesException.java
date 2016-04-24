package beezzy.exceptions;

public class NoSuchVarietiesException extends Exception {

    public NoSuchVarietiesException(){
        this(DEFAULT_MESSAGE);
    }

    public NoSuchVarietiesException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "No varieties with these credentials are registered.";

}