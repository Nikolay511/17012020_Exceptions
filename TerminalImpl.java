import Exceptions.*;

public class TerminalImpl implements ITerminal {
    private final TerminalServer server;
    private final PinValidator pinValidator;

    TerminalImpl(TerminalServer server, PinValidator pinValidator) {
        this.server = server;
        this.pinValidator = pinValidator;
    }

    void unlock() {
        pinValidator.unlock();
    }

    void lock() {
        try {
            pinValidator.lock();
        } catch (AccountIsLockedException | IncorrectPin errorLock) {
            System.out.println(errorLock.getMessage());
        }
    }
    void connectUnLock(boolean b){
        server.setLock(true);
        System.out.println("Соединение восстановлено!!!");
    }

    void connectLock() {
        server.setLock(false);
    }

    @Override
    public void getCDM(double sum) {
        //Проверяем коннект и СтатусПин,Дальше проверяем баланс
        try {
            server.isConnect();
            pinValidator.isPin();
        } catch (ConnectionError | EmptyPin errorConPin) {
            System.out.println(errorConPin.getMessage());
            return;
        }

        try {
            server.getCDM(sum);
        } catch (IncorrectAmount | noMoney errorSum) {
            System.out.println(errorSum.getMessage());
        }
    }

    @Override
    public void putBIM(double sum) {
        try {
            server.isConnect();
            pinValidator.isPin();
        } catch (ConnectionError | EmptyPin errorConPin) {
            System.out.println(errorConPin.getMessage());
            return;
        }

        try {
            server.putBIM(sum);
        } catch (IncorrectAmount errorSum) {
            System.out.println(errorSum.getMessage());
        }
    }

    @Override
    public void balance() {
        try {
            server.isConnect();
            pinValidator.isPin();
        } catch (ConnectionError | EmptyPin p) {
            System.out.println(p.getMessage());
            return;
        }
        System.out.println("Отстаок: " + server.getBalance());
    }
}