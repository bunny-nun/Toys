package model.store;

import model.toy.Toy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Store {
    private final HashMap<Integer, Toy> assortment;
    private final ArrayList<Toy> queue;

    /**
     * Класс магазин игрушек, при инициализации создает словарь, принимающий уникальное целое число в качестве ключа
     * и игрушку в качестве значения, а также список для создания очереди выдачи игрушек
     */
    public Store() {
        this.assortment = new HashMap<>();
        this.queue = new ArrayList<>();
    }

    public HashMap<Integer, Toy> getAssortment() {
        return assortment;
    }

    public ArrayList<Toy> getQueue() {
        return queue;
    }

    public void showQueue() {
        for (Toy toy : this.queue) {
            System.out.printf("%s ", toy.getName());
        }
    }

    /**
     * Добавление игрушки в ассортимент
     *
     * @param toy игрушка для добавления в ассортимент магазина
     */
    public void addToy(Toy toy) {
        this.assortment.put(toy.getId(), toy);
        this.queue.clear();
        fillQueue();
    }

    /**
     * Удаление игрушки из ассортимента
     *
     * @param id id игрушки, подлежащей удалению
     */
    public void removeToy(Integer id) {
        this.assortment.remove(id);
        this.queue.clear();
        fillQueue();
    }

    /**
     * Получение игрушки из очереди выдачи, проверяет размер очереди и при необходимости автозаполняет очередь,
     * проверяет наличие игрушки в достаточном количестве для выдачи и возвращает наименование игрушки,
     * удаляет ее из очереди и уменьшает количество экземпляров данной игрушки в наличии,
     * в противном случае возвращает сообщение об отсутствии игрушки в наличии
     *
     * @return строковое значение с указанием наименования игрушки или сообщения об отсутствии достаточного количества
     * игрушки
     */
    public String getToy() {
        if (this.queue.size() == 0) {
            fillQueue();
        }
        Toy toy = this.queue.get(0);
        if (toy.getQuantity() > 0) {
            int quantity = toy.getQuantity() - 1;
            toy.setQuantity(quantity);
            this.queue.remove(0);
            return toy.getName();
        } else {
            return String.format("The toy %s is out of stock, please refill or amend the assortment", toy.getName());
        }
    }

    /**
     * Пополнение очереди игрушек на выдачу на основании заданной частоты выпадения игрушек (чем выше частота,
     * тем больше игрушек попадает в список очереди), перемешивает игрушки в случайном порядке
     */
    private void fillQueue() {
        for (Toy toy : this.assortment.values()) {
            for (int i = 0; i < toy.getFrequency(); i++) {
                this.queue.add(toy);
            }
        }
        Collections.shuffle(this.queue);
    }

    @Override
    public String toString() {
        StringBuilder storeSB = new StringBuilder();
        for (Toy toy : this.assortment.values()) {
            storeSB.append(toy).append("\n");
        }
        return storeSB.toString();
    }
}
