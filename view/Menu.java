package view;

import presenter.Presenter;
import view.command.*;

import java.util.Scanner;
import java.util.TreeMap;

public class Menu {
    private final TreeMap<String, Command> menuList;
    private final View view;

    /**
     * Класс меню, при инициализации создает экземпляры всех команд, добавленных в меню
     *
     * @param view      экземпляр класса представление
     * @param presenter экземпляр класса презентер
     */
    public Menu(View view, Presenter presenter) {
        this.view = view;
        this.menuList = new TreeMap<>();
        addCommand(new AddToy(this, presenter));
        addCommand(new RemoveToy(this, presenter));
        addCommand(new Refill(this, presenter));
        addCommand(new GetToy(this, presenter));
        addCommand(new Help(this, presenter));
        addCommand(new Exit(this, presenter));
        addCommand(new ShowAll(this, presenter));
    }

    public TreeMap<String, Command> getMenuList() {
        return menuList;
    }

    /**
     * Запускает введенную пользователем команду или выводит сообщение о некорректном вводе
     *
     * @param command текстовом значение команды, введенное пользователем
     */
    public void run(String command) {
        try {
            this.menuList.get(command).execute();
        } catch (NullPointerException e) {
            System.out.println("The command is not found, -help -- for help");
        }
    }

    public Scanner getScanner() {
        return this.view.getScanner();
    }

    private void addCommand(Command command) {
        this.menuList.put(command.getName(), command);
    }

    public void setStatus(boolean status) {
        this.view.setStatus(status);
    }
}
