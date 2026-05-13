package com.qacart.todo.pages;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.Endpoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NewToDoPages extends BasePage {

    public NewToDoPages(WebDriver driver) {
        super(driver);
    }


   @FindBy(css="[data-testid=\"new-todo\"]")
    private WebElement newToDoInput;

    @FindBy(css="[data-testid=\"submit-newTask\"]")
    private WebElement newToDoSubmit;

    @Step
    public NewToDoPages load(){
        driver.get(ConfigUtils.geInstance().getBaseUrl() + Endpoint.NEW_TODO_END_POINT);
        return this;
    }
    @Step
    public ToDoPages addNewTask(String item){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(newToDoInput));

        newToDoInput.sendKeys(item);
        newToDoSubmit.click();
        return new ToDoPages(driver);


    }

}
