package com.ultimateqa.pages;


import com.aventstack.extentreports.Status;
import com.ultimateqa.customlisteners.CustomListeners;
import com.ultimateqa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement signinLink;

    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement welcomeMessage;

    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "user[password]")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement signinButton;

    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement errorMessage;


    public void clickOnSignInLink() {
        Reporter.log("Click on SignInLink" + signinLink.toString());
        clickOnElement(signinLink);
        CustomListeners.test.log(Status.PASS, "Click on SignInLink");
    }

    public String getWelcomeMessage() {
        Reporter.log("Get Welcome Message" + welcomeMessage.toString());
        String message = getTextFromElement(welcomeMessage);
        CustomListeners.test.log(Status.PASS, " Get welcomeMessage");
        return message;
    }

    public void enterEmailId(String email) {
        Reporter.log("Enter email" + email + " to email field " + emailField.toString());
        sendTextToElement(emailField, email);
        CustomListeners.test.log(Status.PASS, "Enter Email Id" + email);
    }

    public void enterPassword(String password) {

        Reporter.log("Enter password" + password + " to password field " + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS, "Enter Password" + password);
    }

    public void clickOnSignInButton() {
        Reporter.log("Click on Sign In Button" + signinButton.toString());
        clickOnElement(signinButton);
        CustomListeners.test.log(Status.PASS, "Click on signinButton");

    }

    public String getErrorMessage() {
        Reporter.log("Get Error Message" + errorMessage.toString());
        String message = getTextFromElement(errorMessage);
        CustomListeners.test.log(Status.PASS, "Get errorMessage");
        return message;

    }
}
