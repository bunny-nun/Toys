package view.command;

import presenter.Presenter;
import view.Menu;

public class Exit extends Command {

    public Exit(Menu menu, Presenter presenter) {
        super("-exit", "exit the program", menu, presenter);
    }

    /**
     * Завершает работу приложению путем передачи в представления статуса false
     */
    @Override
    public void execute() {
        this.menu.setStatus(false);
    }
}
