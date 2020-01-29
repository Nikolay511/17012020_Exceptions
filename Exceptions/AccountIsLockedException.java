package Exceptions;

public class AccountIsLockedException extends Exception{
    public AccountIsLockedException() {
        super("Error: Аккаунт заблокирован на 5 секунд!");
    }
}