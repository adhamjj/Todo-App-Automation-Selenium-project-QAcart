package com.qacart.todo.testcases;

import com.qacart.todo.Utils.ConfigUtils;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.pages.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;


@Feature("Auth Feature")
public class LoginTest extends BaseTest {

    @Story("Login With Email and Password")
    @Description("It will log in by filling the email anp password and navigate to the todo page")
    @Test(description = "Test the login functionality using email and password ")
    public void ShouldBeAbleTOLoginWithEmailAndPassword() {
        LoginPage LoginPage = new LoginPage(getDriver());
        boolean iswelcomedisplayed =
                LoginPage
                        .load()
                        .login(ConfigUtils.geInstance().getemail(),ConfigUtils.geInstance().getpassword())
                        .isWelcomeMessageDisplayed();


        Assert.assertTrue(iswelcomedisplayed);
    }

}
