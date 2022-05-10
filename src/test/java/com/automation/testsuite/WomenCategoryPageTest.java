package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.*;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class WomenCategoryPageTest extends TestBase {

        HomePage homePage;
        SignInPage signInPage;
        CreateAccountPage createAccountPage;
        WomenCategoryPage womenCategoryPage;
        ProductPage productPage;

        @BeforeMethod
        public void inIt(){
            homePage = new HomePage();
            signInPage = new SignInPage();
            createAccountPage = new CreateAccountPage();
            womenCategoryPage = new WomenCategoryPage();
            productPage = new ProductPage();
        }
        @Test
        public void verifyUserShouldNavigateToWomenCategoryPageSuccessfully(){
            homePage.clickOnWomenTab();
            womenCategoryPage.verifyWomenText();
        }
        @Test(priority = 1, dataProvider = "productsdata", dataProviderClass = TestData.class)
        public void verifyUserShouldAddProductToTheCartSuccessfully(String product, String qty, String size, String colour) throws InterruptedException {
            homePage.clickOnWomenTab();
            productPage.addingToTheCartSuccessfully(product,qty,size,colour);

        }
}
