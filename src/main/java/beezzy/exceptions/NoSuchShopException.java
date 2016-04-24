package beezzy.exceptions;

public class NoSuchShopException extends Exception {

    public NoSuchShopException(){
        this(DEFAULT_MESSAGE);
    }

    public NoSuchShopException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "No shop with these credentials are registered.";

}