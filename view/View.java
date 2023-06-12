package view;

import presenter.Presenter;

import java.util.Scanner;

public class View {
    private Presenter presenter;
    private final Scanner scanner;
    private boolean status;

    /**
     * Класс представление, при инициализации создает экземпляр сканера для получения значений от пользователя
     */
    public View() {
        this.scanner = new Scanner(System.in);
        this.status = true;
    }

    /**
     * Метод запуска приложения, продолжает работу до изменения статуса представления на false
     */
    public void start() {
        Menu menu = new Menu(this, this.presenter);
        System.out.println("Type the command, -help -- for help");
        while (status) {
            String command = this.scanner.nextLine();
            menu.run(command);
        }
        this.scanner.close();
    }

    public Scanner getScanner() {
        return scanner;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
