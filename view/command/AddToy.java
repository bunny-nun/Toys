package view.command;

import model.toy.Toy;
import presenter.Presenter;
import view.Menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AddToy extends Command {

    public AddToy(Menu menu, Presenter presenter) {
        super("-add", "add new toy to the store's assortment", menu, presenter);
    }

    /**
     * Принимает значения от пользователя и создает экземпляр игрушки с заданными параметрами, обрабатывает ошибки ввода
     */
    @Override
    public void execute() {
        try {
            Scanner scanner = this.menu.getScanner();
            System.out.println("Type the name:");
            String name = scanner.nextLine();
            System.out.println("Type the quantity:");
            Integer quantity = Integer.parseInt(scanner.nextLine());
            System.out.println("Type the frequency:");
            Integer frequency = Integer.parseInt(scanner.nextLine());
            Toy toy = this.presenter.add(name, quantity, frequency);
            System.out.printf("Toy %s is added successfully\n", toy);
        } catch (InputMismatchException | NullPointerException | NumberFormatException e) {
            System.out.println("Incorrect input");
        }
    }
}
