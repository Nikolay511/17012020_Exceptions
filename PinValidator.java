import Exceptions.*;


public class PinValidator {

    private boolean statusPin;
    private int numberOfAttemptsPin;
    private final int maxNumberOfAttemptsPin;

    PinValidator(int maxNumberOfAttemptsPin,int numberOfAttemptsPin) {
        this.numberOfAttemptsPin = numberOfAttemptsPin;
        this.maxNumberOfAttemptsPin = maxNumberOfAttemptsPin;
    }

    void unlock(){
        statusPin = true;
        numberOfAttemptsPin = 0;
        System.out.println("Пин-код верен!");
    }

    void lock() throws AccountIsLockedException, IncorrectPin {
        statusPin = false;
        numberOfAttemptsPin++;
    if (numberOfAttemptsPin == maxNumberOfAttemptsPin){
            throw new AccountIsLockedException();
        }
        else{
            int remainedAttempts = maxNumberOfAttemptsPin-numberOfAttemptsPin;
            throw new IncorrectPin("Error: Не корректный пин-код, попыток осталось:" + remainedAttempts);
        }
    }
    void isPin() throws EmptyPin {
        if (!statusPin){
            throw new EmptyPin();
        }
    }
}