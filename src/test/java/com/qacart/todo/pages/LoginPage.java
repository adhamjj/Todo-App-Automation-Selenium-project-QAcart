package com.qacart.todo.pages;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.Utils.propertiesUtils;
import com.qacart.todo.base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Properties;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);

    }

    @FindBy(css="[data-testid=\"email\"]")
    private static WebElement emailInput;

    @FindBy(css="[data-testid=\"password\"]")
    private static WebElement passwordInput;

    @FindBy(css="[data-testid=\"submit\"]")
    private WebElement submit;

    @Step("Load the login page")
    public LoginPage load(){

      //  Properties props= propertiesUtils.loadproperties("src/test/java/com/qacart/todo/config/production.properties");
        driver.get(ConfigUtils.geInstance().getBaseUrl());
        return this;
    }

    @Step
    public ToDoPages login(String email, String password){
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        submit.click();

        return new ToDoPages(driver);
    }

    }



