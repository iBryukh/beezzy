package beezzy.exceptions;

public class NoSuchCategoryException extends Exception {

    public NoSuchCategoryException(){
        this(DEFAULT_MESSAGE);
    }

    public NoSuchCategoryException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "No category with these credentials are registered.";

}