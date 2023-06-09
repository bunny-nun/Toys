package view.command;

import model.toy.Toy;
import presenter.Presenter;
import view.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RemoveToy extends Command {

    public RemoveToy(Menu menu, Presenter presenter) {
        super("-remove", "remove the toy from the store's assortment", menu, presenter);
    }

    /**
     * Удаление игрушки из ассортимента магазина, принимает от пользователя id игрушки
     * и выводит сообщение об успешном удалении, обрабатывает ошибки ввода
     */
    @Override
    public void execute() {
        try {
            Scanner scanner = this.menu.getScanner();
            System.out.println("Type the ID of the toy:");
            Integer id = Integer.parseInt(scanner.nextLine());
            Toy toy = this.presenter.remove(id);
            System.out.printf("Toy %s is removed successfully\n", toy);
        } catch (InputMismatchException | NullPointerException | NumberFormatException e) {
            System.out.println("Incorrect input");
        }
    }
}
