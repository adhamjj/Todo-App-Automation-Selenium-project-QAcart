package com.qacart.todo.base;

import com.qacart.todo.Utils.CookiesUtils;
import com.qacart.todo.factory.DriverFactory;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.http.Cookie;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.List;

public class BaseTest {
    protected ThreadLocal<WebDriver> driver= new ThreadLocal<>();

    public void setDriver(WebDriver driver){
        this.driver.set(driver);

    }
    public WebDriver getDriver(){
        return this.driver.get();
    }

    @BeforeMethod
    public void setup(){
        WebDriver driver= new DriverFactory().initializeDriver();
        setDriver(driver);
       // getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       // getDriver().manage().window().maximize();
    }
    @AfterMethod
    public void teardown(ITestResult result){
        String testCaseName =result.getMethod().getMethodName();
        File destFile=new File("target" + File.separator + "screenshots" + File.separator +testCaseName+".png");
        takeScreenshot(destFile);
        getDriver().quit();

    }
    @Step
    public void InjectCookiesToBrowser(List<Cookie>restAssuredCookies){
        List<org.openqa.selenium.Cookie>selenuimCookies=CookiesUtils.convertRestAssuredCookiesToSeleniumCookies(restAssuredCookies);
        for(org.openqa.selenium.Cookie cookie:selenuimCookies){
            getDriver().manage().addCookie(cookie);
        }

    }
    public void takeScreenshot(File destFile){
        File file =((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(file, destFile);
            InputStream is=new FileInputStream(destFile);
            Allure.addAttachment("screenshot", is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
