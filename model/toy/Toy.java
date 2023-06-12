package model.toy;

public class Toy {
    private String name;
    private Integer id;
    private Integer quantity;
    private Integer frequency;

    /**
     * Класс игрушка
     *
     * @param name      наименование (строка)
     * @param id        id (целое число)
     * @param quantity  количество (целое число)
     * @param frequency частота выпадения (целое число)
     */
    public Toy(String name, Integer id, Integer quantity, Integer frequency) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return this.name + " (id: " +
                this.id +
                ")" +
                ", quantity = " +
                this.quantity;
    }
}
