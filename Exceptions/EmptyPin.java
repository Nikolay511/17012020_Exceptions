package Exceptions;

public class EmptyPin extends Exception {
    public EmptyPin() {
        super("Error: Введите пин-код!");
    }
}