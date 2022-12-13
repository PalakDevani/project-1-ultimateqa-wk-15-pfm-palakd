package com.ultimateqa.testsuite;


import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)


public class LoginPageTest extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {

        loginPage = new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        loginPage.clickOnSignInLink();
        Assert.assertEquals(loginPage.getWelcomeMessage(), "Welcome Back!", "Login Page not displayed");
    }

    @Test(groups = {"smoke", "regression"})

    public void verifyTheErrorMessage() {
        loginPage.clickOnSignInLink();
        loginPage.enterEmailId("testing13@gail.com");
        loginPage.enterPassword("test34");
        loginPage.clickOnSignInButton();
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid email or password.", "Error message not displayed");

    }
}