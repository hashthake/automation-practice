package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CreateAccountPage extends HomePage {

    public CreateAccountPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameLink;
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameLink;
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordLink;
    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressLink;
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityLink;
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement stateLink;
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipPostalLink;
    @FindBy(xpath = "//select[@id='id_country']")
    WebElement countryLink;
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobilePhoneLink;
    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement registerLink;
    @FindBy(xpath = "//input[@id='email_create']")
    WebElement emailCreateAccLink;
    @FindBy(xpath = "//button[@id='SubmitCreate']")
    WebElement createAccountLink;
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountTextLink;

    public void fillMandetoryFields() {
        Reporter.log("Entering firstname" + firstNameLink.toString()+ "<br>");
        sendTextToElement(firstNameLink, "Carl");
        Reporter.log("Entering lastname" + lastNameLink.toString()+ "<br>");
        sendTextToElement(lastNameLink, "Host");
        Reporter.log("Entering password" + passwordLink.toString()+ "<br>");
        sendTextToElement(passwordLink, "ABCD123");
        Reporter.log("Entering address" + addressLink.toString()+ "<br>");
        sendTextToElement(addressLink, "20 Carl Street");
        Reporter.log("Entering city" + cityLink.toString()+ "<br>");
        sendTextToElement(cityLink, "London");
        Reporter.log("Selecting the state" + stateLink.toString()+ "<br>");
        sendTextToElement(stateLink, "Florida");
        Reporter.log("Entering postalcode" + zipPostalLink.toString()+ "<br>");
        sendTextToElement(zipPostalLink, "12345");
        Reporter.log("Entering contact number" + mobilePhoneLink.toString()+ "<br>");
        sendTextToElement(mobilePhoneLink, "01234567891");
    }

    public void clickOnRegister() {
        Reporter.log("Clicking on register link" + registerLink.toString()+ "<br>");
        clickOnElement(registerLink);
    }
    public String verifyMyAccountText(){
        Reporter.log("Verifying the message" + myAccountTextLink.toString()+ "<br>");
       return getTextFromElement(myAccountTextLink);
    }







}
