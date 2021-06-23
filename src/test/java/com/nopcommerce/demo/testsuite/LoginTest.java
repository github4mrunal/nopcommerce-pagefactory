package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();

    @BeforeMethod(alwaysRun = true)
    public void pageSetUp(){

        loginPage = new LoginPage();
    }


    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToLoginPage() {
        loginPage.clickOnLoginLink();
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(expectedMessage,actualMessage);
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldLoginSuccessfully() throws InterruptedException {
        loginPage.clickOnLoginLink();
        Thread.sleep(3000);
        loginPage.enterEmailId("tanyanagpal7@gmail.com");
        loginPage.enterPassword("tvf2018");
        loginPage.clickOnLoginButton();

        String expectedMessage = "Welcome to our store";
        String actualMessage = loginPage.getHomePageText();
        Assert.assertEquals(actualMessage,expectedMessage);
    }


@Test(groups = {"regression"})
public void verifyUserShouldNotLoginWithInvalidCredentials() throws InterruptedException {
    loginPage.clickOnLoginLink();
    Thread.sleep(3000);
    loginPage.enterEmailId("tanyanagpal1@gmail.com");
    loginPage.enterPassword("tvf");
    loginPage.clickOnLoginButton();
    String expectedMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
            "No customer account found";
    String actualMessage = loginPage.getErrorMessage();
    Assert.assertEquals(actualMessage, expectedMessage);

}
}
