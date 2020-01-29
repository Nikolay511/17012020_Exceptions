package Exceptions;

public class ConnectionError extends Exception {
    public ConnectionError(String errormessage) {
        super(errormessage);
    }
}