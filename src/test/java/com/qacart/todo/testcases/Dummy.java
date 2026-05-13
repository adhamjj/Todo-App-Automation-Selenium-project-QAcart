package com.qacart.todo.testcases;

import java.io.*;
import java.util.Properties;

public class Dummy {
    public static void main(String[] args) throws IOException {
        File file=new File("src/test/java/com/qacart/todo/config/local.properties");
        InputStream inputStream=new FileInputStream(file);
        Properties properties= new Properties();
        properties.load(inputStream);
       String baseurl= properties.getProperty("baseurl");
        System.out.println(baseurl);


    }
}
