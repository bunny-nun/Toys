package view.command;

import presenter.Presenter;
import view.Menu;

public class ShowAll extends Command {

    public ShowAll(Menu menu, Presenter presenter) {
        super("-show", "show all toys available in the store and their quantity", menu, presenter);
    }

    /**
     * Выводит на экран список всех игрушек в ассортименте
     */
    @Override
    public void execute() {
        System.out.println(this.presenter.showAll());
        System.out.println("END");
    }
}
