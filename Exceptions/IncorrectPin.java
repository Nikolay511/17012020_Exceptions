package Exceptions;

public class IncorrectPin extends Exception {
    public IncorrectPin(String errormessage){
        super(errormessage);
    }
}
