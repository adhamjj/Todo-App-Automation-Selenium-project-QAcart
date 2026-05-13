package com.qacart.todo.Utils;

import java.io.*;
import java.util.Properties;

public class propertiesUtils {
    public static Properties loadproperties(String filepath){
        File file=new File(filepath);
        try {
            InputStream inputStream=new FileInputStream(file);
            Properties properties=new Properties();
            properties.load(inputStream);
            inputStream.close();
            return properties;

        } catch (FileNotFoundException e) {
            throw new RuntimeException("file is not found");
        } catch (IOException e) {
            throw new RuntimeException("error while loading the properties");
        }

    }
}
