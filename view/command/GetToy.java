package view.command;

import presenter.Presenter;
import view.Menu;

public class GetToy extends Command {

    public GetToy(Menu menu, Presenter presenter) {
        super("-get", "get a toy from the store", menu, presenter);
    }

    /**
     * Получение игрушки из очереди на выдачу
     */
    @Override
    public void execute() {
        System.out.println(this.presenter.get());
    }
}
