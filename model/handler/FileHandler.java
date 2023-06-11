package model.handler;

public abstract class FileHandler {
    protected String fileName;

    /**
     * Абстрактный класс для записи и сохранения файлов
     *
     * @param fileName название файла без расширения
     */
    public FileHandler(String fileName) {
        this.fileName = "D:\\УЧЕБА\\Toys\\logs\\" + fileName;
    }
}
