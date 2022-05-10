package com.automation.pages;

import com.automation.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class WomenCategoryPage extends Utility {

    public WomenCategoryPage(){
        PageFactory.initElements(driver,this);
    }
    @FindBy (xpath = "//h2[contains(text(),'Women')]")
    WebElement womenTitleTextLink;

    public String verifyWomenText(){
        Reporter.log("Verifying WOMEN text"+womenTitleTextLink.toString()+"<br>");
        return getTextFromElement(womenTitleTextLink);
    }

}


