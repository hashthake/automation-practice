package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends Utility {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//a[@title='Women']")
    WebElement womenLink;
    @FindBy (xpath = "//a[@title='Women']")
    WebElement dressesLink;
    @FindBy (xpath = "//header/div[3]/div[1]/div[1]/div[6]/ul[1]/li[1]/ul[1]/li[1]/ul[1]/li[1]/a[1]")
    WebElement tShirtLink;
    @FindBy (xpath = "//a[contains(text(),'Sign in')]")
    WebElement signInLink;
    @FindBy (xpath = "//header/div[3]/div[1]/div[1]/div[1]/a[1]/img[1]")
    WebElement logoLink;

    public void clickOnSignIn(){
        Reporter.log("Clicking on SignIn" + signInLink.toString()+ "<br>");
        clickOnElement(signInLink);
    }
    public void clickOnWomenTab(){
        Reporter.log("Clicking on WOMEN tab" + womenLink.toString()+ "<br>");
        clickOnElement(womenLink);
    }

}
