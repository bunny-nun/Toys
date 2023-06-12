package view.command;

import model.toy.Toy;
import presenter.Presenter;
import view.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Refill extends Command {

    public Refill(Menu menu, Presenter presenter) {
        super("-refill", "amend the quantity of the toy", menu, presenter);
    }

    /**
     * Принимает от пользователя id игрушки для пополнения и дополнительное количество,
     * выводит на экран данные игруки с изменным количеством и обрабатывает ошибки ввода
     */
    @Override
    public void execute() {
        try {
            Scanner scanner = this.menu.getScanner();
            System.out.println("Type the ID of the toy:");
            Integer id = Integer.parseInt(scanner.nextLine());
            System.out.println("Type the quantity to add:");
            Integer quantity = Integer.parseInt(scanner.nextLine());
            Toy toy = this.presenter.refill(id, quantity);
            System.out.printf("Toy %s is refilled successfully\n", toy);
        } catch (InputMismatchException | NullPointerException | NumberFormatException e) {
            System.out.println("Incorrect input");
        }
    }
}
