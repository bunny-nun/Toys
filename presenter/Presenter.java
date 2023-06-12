package presenter;

import model.service.Service;
import model.toy.Toy;
import view.View;

public class Presenter {
    private final Service service;

    /**
     * Класс презентер
     *
     * @param view    представление
     * @param service сервис
     */
    public Presenter(View view, Service service) {
        this.service = service;
        view.setPresenter(this);
    }

    /**
     * Добавление игрушки
     *
     * @param name      наименование (строка)
     * @param quantity  количество (целое число)
     * @param frequency частота выпадения (целое число)
     * @return созданный экземпляр игрушки
     */
    public Toy add(String name, Integer quantity, Integer frequency) {
        return this.service.addToy(name, quantity, frequency);
    }

    /**
     * Получение игрушки из очереди
     *
     * @return строковое значение результата выполнения
     */
    public String get() {
        return this.service.getToy();
    }

    /**
     * Удаление игрушки из ассортимента магазина
     *
     * @param id id игрушки
     * @return удаленную игрушку
     */
    public Toy remove(Integer id) {
        return this.service.removeToy(id);
    }

    /**
     * Пополнение количества игрушки
     *
     * @param id       id игрушки
     * @param quantity дополнительное количество
     * @return игрушку с измененным количеством
     */
    public Toy refill(Integer id, Integer quantity) {
        return this.service.refillToy(id, quantity);
    }

    /**
     * Отображение ассортимента магазина
     *
     * @return строковое значение всех игрушек в магазине
     */
    public String showAll() {
        return this.service.showAll();
    }
}
