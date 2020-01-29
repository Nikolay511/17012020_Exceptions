import Exceptions.*;

public class TerminalServer {

    private boolean connect;
    private double balance;


    TerminalServer() {
        connect = true;
    }

    TerminalServer(double balance) {
        connect = true;
        if (balance <= 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    void isConnect() throws ConnectionError {
        if (!connect) {
            throw new ConnectionError("Error: Невозможно совершить операцию, ошибка подключения");
        }
    }

    void getCDM(double sum) throws IncorrectAmount, noMoney {
        if (sum % 100D != 0.00D) {
            throw new IncorrectAmount("Error: Некорректно введена сумма. \nКупюра должна быть кратна 100");
        } else if (sum > balance) {
            throw new noMoney("Error: Запрошенная сумма не выдана.\nНедостаточно средств");
        } else {
            System.out.println("Запрошенная сумма выдана: " + sum +"\nНе забудьте деньги");
            balance -= sum;
        }
    }

    void putBIM(double sum) throws IncorrectAmount {
        if (sum%100D != 0.00D) {
            throw new IncorrectAmount("Заберите не распознаные купюры. \nКупюра должна быть кратна 100");
        } else {
            balance += sum;
        }
    }

    double getBalance(){
        return balance;
    }

    public void setLock(boolean o) {
        connect = o;
    }
}
