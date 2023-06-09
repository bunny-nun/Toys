package model.handler;

import java.io.FileWriter;
import java.io.IOException;

public class TxtSaver extends FileHandler {
    /**
     * Класс для сохранения файла в формате .txt
     *
     * @param fileName название файла без расширения
     */
    public TxtSaver(String fileName) {
        super(fileName);
    }

    /**
     * Метод сохранения текстового файла
     *
     * @param string строковое значение для записи в файл
     * @return true если операция сохранения выполнена успешно, иначе - false
     */
    public boolean save(String string) {
        if (!string.isEmpty()) {
            try {
                FileWriter fileWriter = new FileWriter(this.fileName + ".txt", true);
                fileWriter.write(string);
                fileWriter.write("\n");
                fileWriter.close();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
