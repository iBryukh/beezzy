package beezzy.exceptions;

public class NoSuchGoodsException extends Exception {

    public NoSuchGoodsException(){
        this(DEFAULT_MESSAGE);
    }

    public NoSuchGoodsException(String message){
        super(message);
    }

    private static final String DEFAULT_MESSAGE = "No goods with these credentials are registered.";

}