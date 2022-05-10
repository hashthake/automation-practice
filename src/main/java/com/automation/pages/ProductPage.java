package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class ProductPage extends HomePage{

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[2]/div[1]/div[2]/h5[1]/a[1]")
    WebElement blouseLink;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[3]/div[1]/div[2]/h5[1]/a[1]")
    WebElement printedDressLink;
    @FindBy(xpath = "//a[contains(text(),'Printed Chiffon Dress')]")
    WebElement printedChiffonDressLink;
    @FindBy(xpath = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[2]/ul[1]/li[5]/div[1]/div[2]/h5[1]/a[1]")
    WebElement printedSummerDressLink;
    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement blouseQtyLink;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement printedDressQtyFieldLink;
    @FindBy(xpath = "//input[@id='quantity_wanted']")
    WebElement printedChiffonDressQtyFieldLink;
    @FindBy(xpath = "//i[@class='icon-plus']")
    WebElement printedSummerDressQty;
    @FindBy(id = "group_1")
    WebElement printedSummerDressSize;
    @FindBy(xpath = "(//a[@id='color_14'])[1]")
    WebElement printedSummerDressColour;
    @FindBy(id = "group_1")
    WebElement printedChiffonDressSize;
    @FindBy(xpath = "(//a[@id='color_15'])[1]")
    WebElement printedChiffonDressColour;
    @FindBy(id = "group_1")
    WebElement printedDressSize;
    @FindBy(xpath = "(//a[@id='color_13'])[1]")
    WebElement printedDressColour;
    @FindBy(xpath = "(//select[@id='group_1'])[1]")
    WebElement blouseSize;
    @FindBy(xpath = "(//a[@id='color_8'])[1]")
    WebElement blouseColour;
    @FindBy(xpath = "//span[normalize-space()='Add to cart']")
    WebElement addToCartButton;
    @FindBy(xpath = "(//h2[normalize-space()='Product successfully added to your shopping cart'])[1]")
    WebElement popUpMessageTextLink;
    @FindBy(xpath = "//span[@title='Close window']")
    WebElement popUpCloseButtonLink;


    public void clickOnTheProduct(String product) {
        if (product.equalsIgnoreCase("Blouse")) {
            clickOnElement(blouseLink);
        } else if (product.equalsIgnoreCase("Printed Dress")) {
            clickOnElement(printedDressLink);
        } else if (product.equalsIgnoreCase("Printed Chiffon Dress")) {
            clickOnElement(printedChiffonDressLink);
        } else if (product.equalsIgnoreCase("Printed Summer Dress with Price $28.98")) {
            clickOnElement(printedSummerDressLink);
        }
    }

    public void changeQty(String qty) {
        if (qty.equalsIgnoreCase("2")) {
            clickOnElement(blouseQtyLink);
        } else if (qty.equalsIgnoreCase("3")) {
            clearTextFromField(By.xpath("//input[@id='quantity_wanted']"));
            sendTextToElement(printedDressQtyFieldLink, "3");
        } else if (qty.equalsIgnoreCase("4")) {
            clearTextFromField(By.xpath("//input[@id='quantity_wanted']"));
            sendTextToElement(printedChiffonDressQtyFieldLink, "4");
        } else if (qty.equalsIgnoreCase("2")) {
            clickOnElement(printedSummerDressQty);
        }
    }

    public void selectSize(String size)  {
        if (size.equalsIgnoreCase("M")) {
            selectByVisibleTextFromDropDown(blouseSize, "M");
        } else if (size.equalsIgnoreCase("L")) {
            //pmClickOnElement(printedDressSize);
            selectByVisibleTextFromDropDown(printedDressSize, "L");
            //Thread.sleep(2000);
        } else if (size.equalsIgnoreCase("S")) {
            //pmClickOnElement(printedChiffonDressSize);
            selectByVisibleTextFromDropDown(printedChiffonDressSize, "S");
            //Thread.sleep(2000);
        } else if (size.equalsIgnoreCase("M")) {
            selectByVisibleTextFromDropDown(printedSummerDressSize, "M");
            //Thread.sleep(2000);
        }
    }

    public void selectColour(String colour) {
        if (colour.equalsIgnoreCase("White")) {
            clickOnElement(blouseColour);
        } else if (colour.equalsIgnoreCase("Orange")) {
            clickOnElement(printedDressColour);
        } else if (colour.equalsIgnoreCase("Green")) {
            clickOnElement(printedChiffonDressColour);
        } else if (colour.equalsIgnoreCase("Blue")) {
            clickOnElement(printedSummerDressColour);
        }
    }

    public void addToCart() throws InterruptedException {
        Reporter.log("Adding to cart" + addToCartButton.toString() + "<br>");
        clickOnElement(addToCartButton);
        Thread.sleep(3500);
    }

    public void addingToTheCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {

        clickOnTheProduct(product);
        changeQty(qty);
        selectSize(size);
        selectColour(colour);
        addToCart();
        Thread.sleep(3500);
        verifyPopUpMessage();
        Thread.sleep(3500);
        closeThePopUpMessage();
    }

    public String verifyPopUpMessage() throws InterruptedException {
        Reporter.log("Verifying the popup Message" + popUpMessageTextLink.toString() + "<br>");
        return getTextFromElement(popUpMessageTextLink);
    }

    public void closeThePopUpMessage() {
        Reporter.log("Closing the popup message" + popUpCloseButtonLink.toString() + "<br>");
        clickOnElement(popUpCloseButtonLink);
    }
}
