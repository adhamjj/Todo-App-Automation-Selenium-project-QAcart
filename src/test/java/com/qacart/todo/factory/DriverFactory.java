package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    public WebDriver initializeDriver(){

        String browser=System.getProperty("browser","CHROME");
        WebDriver driver;
        switch (browser){
            case "CHROME":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--window-size=1920,1080");
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver =new FirefoxDriver();
                break;
            case"SAFARI":
                WebDriverManager.safaridriver().setup();
                driver =new SafariDriver();
                break;
            default:
                throw new RuntimeException("the browser is not supported");

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;

    }

}
