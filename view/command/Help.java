package view.command;

import presenter.Presenter;
import view.Menu;

public class Help extends Command {

    public Help(Menu menu, Presenter presenter) {
        super("-help", "show all available commands with their descriptions", menu, presenter);
    }

    /**
     * Вывод списка допустимых в приложении команд
     */
    @Override
    public void execute() {
        for (Command command : this.menu.getMenuList().values()) {
            System.out.printf("%s -- %s\n", command.getName(), command.getDescription());
        }
    }
}
