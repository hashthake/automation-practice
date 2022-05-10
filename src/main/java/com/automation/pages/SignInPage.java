package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SignInPage extends Utility {

    public SignInPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//h1[contains(text(),'Authentication')]")
    WebElement authenticationText;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailFieldLink;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordFieldLink;
    @FindBy(xpath = "//button[@id='SubmitLogin']")
    WebElement signInTab;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreateAccLink;
    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement createAccountLink;
    @FindBy(xpath = "//li[contains(text(),'An email address required.')]")
    WebElement errorMessageLink;
    @FindBy(xpath = "//a[@title='Log me out']")
    WebElement signOutLink;

    public String verifyAuthMessage() {
        Reporter.log("Verifying the message" + authenticationText.toString()+ "<br>");
        return getTextFromElement(authenticationText);
    }

    public void enterEmail(String emailAddress) {
        Reporter.log("Entering the email : " + emailCreateAccLink.toString() + "<br>");
        sendTextToElement(emailCreateAccLink, emailAddress);
    }

    public void clickOnCreateAcc() {
        Reporter.log("Clicking on create account" + createAccountLink.toString() + "<br>");
        clickOnElement(createAccountLink);
    }

    public void enterUsername(String username) {
        Reporter.log("Entering username" + emailFieldLink.toString() + "<br>");
        sendTextToElement(emailFieldLink, username);
    }

    public void enterPassword(String password) {
        Reporter.log("Entering the password " + passwordFieldLink.toString() + "<br>");
        sendTextToElement(passwordFieldLink, password);
    }

    public void clickOnSigninButton() {
        Reporter.log("Clicking on Signin button : " + signInTab.toString() + "<br>");
        clickOnElement(signInTab);
    }

    public void verifyErrorMessage() {
        String errorMessage = null;
        Reporter.log("Verifing the error message : " + errorMessageLink.toString() + "<br>");
        if (errorMessage == "An email address required.") {
            getTextFromElement(errorMessageLink);
        } else if (errorMessage == "Password is required.") {
            getTextFromElement(errorMessageLink);
        } else if (errorMessage == "Invalid email address.") {
            getTextFromElement(errorMessageLink);
        } else if (errorMessage == "Invalid email address.") {
            getTextFromElement(errorMessageLink);
        }
    }

    public void loginToApplication(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickOnSigninButton();
        //verifyErrorMessage(errorMessage);
    }
    public String verifySignOutLink(){
        Reporter.log("Verifying Signout link : " + signOutLink.toString() + "<br>");
       return getTextFromElement(signOutLink);
    }
    public void clickOnSignOut(){
        Reporter.log("Clicking on SignOut : " + signOutLink.toString() + "<br>");
        clickOnElement(signOutLink);
    }
    public String verifySignInLink(){
        Reporter.log("Verifying SignIn link : " + signInTab.toString() + "<br>");
        return getTextFromElement(signInTab);
    }

}
