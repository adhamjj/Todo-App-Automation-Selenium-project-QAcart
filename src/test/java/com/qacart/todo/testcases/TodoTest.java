package com.qacart.todo.testcases;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TasksApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewToDoPages;
import com.qacart.todo.pages.ToDoPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.time.Duration;
@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("Add Todo")
    @Test(description = "Should be able to add a new todo correctly")
    public void ShouldBeAbleToAddNewTodo()  {

        RegisterApi registerApi=new RegisterApi();
        registerApi.register();


       NewToDoPages newToDoPages=new NewToDoPages(getDriver());
       newToDoPages.load();
        InjectCookiesToBrowser(registerApi.getcookies());
       String actualresult= newToDoPages
               .load()
               .addNewTask("Learn Selenium")
               .getToDoText();


        Assert.assertEquals(actualresult,"Learn Selenium");

    }
    @Story("Delete Todo")
    @Test(description = "Should be able to delete a todo correctly")
    public void ShouldBeAbleToDeleteTodo(){

        RegisterApi registerApi=new RegisterApi();
        registerApi.register();

        TasksApi tasksApi=new TasksApi();
        tasksApi.addTask(registerApi.getToken());

        ToDoPages toDoPages=new ToDoPages(getDriver());
        toDoPages.load();
        InjectCookiesToBrowser(registerApi.getcookies());

        boolean isNoTodoMessageDisplayed= toDoPages
                .load()
                .ClickOndeleteButton()
                .isNoTodoMessageDisplayed();



        Assert.assertTrue(isNoTodoMessageDisplayed);




    }
}
