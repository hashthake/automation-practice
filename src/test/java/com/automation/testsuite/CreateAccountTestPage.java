package com.automation.testsuite;

import com.automation.customlisteners.CustomListeners;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.HomePage;
import com.automation.pages.SignInPage;
import com.automation.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class CreateAccountTestPage extends TestBase {

    HomePage homePage;
    SignInPage signInPage;
    CreateAccountPage createAccountPage;
    @BeforeMethod
    public void inIt(){
        homePage = new HomePage();
        signInPage = new SignInPage();
        createAccountPage = new CreateAccountPage();
    }
    @Test
    public void verifyThatUserShouldCreateAccountSuccessfully(){
        homePage.clickOnSignIn();
        signInPage.enterEmail("@gmail.com");
        signInPage.clickOnCreateAcc();
        createAccountPage.fillMandetoryFields();
        createAccountPage.clickOnRegister();
        createAccountPage.verifyMyAccountText();

    }
}
