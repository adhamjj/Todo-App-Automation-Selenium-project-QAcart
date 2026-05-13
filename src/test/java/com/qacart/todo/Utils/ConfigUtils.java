package com.qacart.todo.Utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils(){
     String env=  System.getProperty("env","PRODUCTION");
     switch (env){
         case"PRODUCTION":
             properties =propertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/production.properties");
             break;
         case "local":
             properties =propertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/local.properties");
             break;
         default:
             throw new RuntimeException("Environment is not supported");
     }


    }
    public static ConfigUtils geInstance(){
        if (configUtils== null){
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public  String getemail() {
        String prop = properties.getProperty("email");
        if (prop != null) return prop;
        throw new RuntimeException("could not find email");

    }
    public  String getBaseUrl() {
        String prop = properties.getProperty("baseurl");
        if (prop != null) return prop;
        throw new RuntimeException("could not find baseurl");

    }
    public  String getpassword() {
        String prop = properties.getProperty("password");
        if (prop != null) return prop;
        throw new RuntimeException("could not find password");

    }

}
