package com.qacart.todo.pages;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.Endpoint;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToDoPages extends BasePage {
    public ToDoPages(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="[data-testid=\"welcome\"]")
    private WebElement WelcomeMessage;

    @FindBy(css="[data-testid=\"add\"]")
    private WebElement addButton;

    @FindBy(css="[data-testid=\"delete\"]")
    private WebElement deleteButton;

    @FindBy(css="[data-testid=\"todo-item\"]")
    private WebElement todoItem;

    @FindBy(css="[data-testid=\"no-todos\"]")
    private WebElement noToDoMessage;

    public ToDoPages load(){
        driver.get(ConfigUtils.geInstance().getBaseUrl() + Endpoint.TODO_PAGE_END_POINT);
        return this;
    }

    @Step
    public boolean isWelcomeMessageDisplayed(){

       return WelcomeMessage.isDisplayed();
    }

    @Step

    public NewToDoPages clickonPlusButton(){
        addButton.click();
        return new NewToDoPages(driver);
    }
    @Step
    public String getToDoText(){
       return todoItem.getText();
    }

    @Step
    public ToDoPages ClickOndeleteButton(){
        deleteButton.click();
        return this;
    }

    @Step

    public boolean isNoTodoMessageDisplayed(){
        return noToDoMessage.isDisplayed();
    }

}
