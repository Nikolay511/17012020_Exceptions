import java.util.*;

public class Main {
    public static void main(String[] args) {
        TerminalServer server = new TerminalServer();
        PinValidator pinVal = new PinValidator(3, 0);
        TerminalImpl terminal = new TerminalImpl(server, pinVal);

        System.out.println("Блочим акк, 3-мя неправильными пинами, на 5 сек");
        terminal.lock();
        terminal.lock();
        terminal.lock();


        System.out.println("Выбрана функция выдачи:");
        terminal.unlock();
        terminal = new TerminalImpl(new TerminalServer(15000), pinVal);
        terminal.balance();
        System.out.print("Введите сумму ");
        Scanner in = new Scanner(System.in);
        terminal.getCDM(in.nextInt());
        terminal.balance();


        System.out.println("Выбрана функция взноса:");
        terminal.unlock();
        terminal.balance();
        System.out.println("Вносимая сумма: 12");
        terminal.putBIM(12);
        System.out.println("Вносимая сумма: 1000");
        terminal.putBIM(1000);
        terminal.balance();

        System.out.println("Обрываем сервер");
        terminal.connectLock();
        terminal.putBIM(10);

        System.out.println("Выбрана функция выдачи:");
        terminal.connectUnLock(true);
        terminal.unlock();
        terminal.balance();
        terminal.getCDM(200000);

    }
}