package model.service;

public class Numerator {
    private Integer ID;

    /**
     * Единый нумератор для задания id игрушки
     */
    public Numerator() {
        this.ID = 0;
    }

    /**
     * Получение следующего id игрушки
     *
     * @return целочисленное значение следующего id игрушки
     */
    public Integer nextID() {
        this.ID++;
        return this.ID;
    }
}
