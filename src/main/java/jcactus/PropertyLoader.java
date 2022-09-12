package jcactus;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private String file;

    public PropertyLoader() {
        this.file = "config.properties";
    }

    public PropertyLoader(String file) {
        this.file = file;
    }

    public String getProperty (String propertyName) {

        FileInputStream fis;
        Properties property = new Properties();
        String propertyFromFile = null;

        try {
            fis = new FileInputStream("src/main/resources/".concat(file));
            property.load(fis);
            // TODO добавить исключение на случай отсутствия propertyName в файле properties
            propertyFromFile = property.getProperty(propertyName);
        } catch (IOException e) {
            new Message().errorMessage("ОШИБКА: Файл свойств отсуствует!");
        }

        return propertyFromFile;
    }

}
