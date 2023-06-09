package view.command;

import presenter.Presenter;
import view.Menu;

public abstract class Command {
    private final String name;
    private final String description;
    protected final Menu menu;
    protected final Presenter presenter;

    /**
     * Абстрактный класс команды меню
     *
     * @param name        текстовое значение команды, вводимой пользователем
     * @param description описание команды (для отображения в help)
     * @param menu        экземпляр класса меню
     * @param presenter   экземпляр класса презентер
     */
    public Command(String name, String description, Menu menu, Presenter presenter) {
        this.name = name;
        this.description = description;
        this.menu = menu;
        this.presenter = presenter;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Абстрактный метод выполнения команды
     */
    public abstract void execute();
}
