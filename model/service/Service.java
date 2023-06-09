package model.service;

import model.handler.TxtSaver;
import model.store.Store;
import model.toy.Toy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Service {
    private final Store store;
    private final Numerator numerator;
    private final TxtSaver saver;

    /**
     * Сервисный класс, при инициализации создает экземпляр магазина, нумератор и хэндлер
     */
    public Service() {
        this.store = new Store();
        this.numerator = new Numerator();
        this.saver = new TxtSaver("logs");
    }

    /**
     * Добавление игрушки в магазин
     *
     * @param name      наименование (строка)
     * @param quantity  количество (целое число)
     * @param frequency частота выпадения (целое число)
     * @return созданный экземпляр класса
     */
    public Toy addToy(String name, Integer quantity, Integer frequency) {
        Toy toy = new Toy(name, this.numerator.nextID(), quantity, frequency);
        this.store.addToy(toy);
        return toy;
    }

    /**
     * Получение игрушки
     *
     * @return строкое значение одной игрушки из очереди на выдачу с указанием даты и времени выдачи игрушки
     * и статуса логирования
     */
    public String getToy() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();
        String result = "[" + date.format(formatter) + "]" + " " + this.store.getToy();
        boolean saveStatus = this.saver.save(result);
        if (saveStatus) {
            return result + " (logged)";
        } else {
            return result + " (not logged)";
        }
    }

    /**
     * Удаление игрушки из ассортимента магазина
     *
     * @param id id игрушки
     * @return возвращает игрушку, удаленную из магазина
     */
    public Toy removeToy(Integer id) {
        Toy toy = this.store.getAssortment().get(id);
        this.store.removeToy(id);
        return toy;
    }

    /**
     * Дополнение количества игрушки
     *
     * @param id       id игрушки
     * @param quantity дополнительное количество игрушки для пополнения магазина
     * @return возвращает игрушку с измененным количеством
     */
    public Toy refillToy(Integer id, Integer quantity) {
        Toy toy = this.store.getAssortment().get(id);
        Integer total = toy.getQuantity() + quantity;
        toy.setQuantity(total);
        return toy;
    }

    /**
     * Показывает весь ассортимент магазина
     *
     * @return строкое значение с указанием всех игрушек в ассортименте
     */
    public String showAll() {
        return this.store.toString();
    }
}
