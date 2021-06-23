package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.pages.RegisterationPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import javax.annotation.processing.SupportedAnnotationTypes;

public class RegisterationTest extends TestBase {
    SoftAssert softAssert = new SoftAssert();
    RegisterationPage registerationPage = new RegisterationPage();

    @BeforeMethod(alwaysRun = true)
    public void pageSetUpRegister() {
        registerationPage = new RegisterationPage();

    }

    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToRegisterPage() throws InterruptedException {

        registerationPage.clickOnRegisterLink();
        String expectedRegPageText = "Register";
        String actualRegPageText = registerationPage.regPageTextIs();
        softAssert.assertEquals( actualRegPageText,expectedRegPageText );
        softAssert.assertTrue( true );

    }
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNotRegisterWithIncompleteDetails() throws InterruptedException {
        registerationPage.clickOnRegisterLink();
        String expectedRegPageText = "Register";
        String actualRegPageText = registerationPage.regPageTextIs();
        softAssert.assertEquals( actualRegPageText,expectedRegPageText );
        softAssert.assertTrue(true);
        Thread.sleep(3000);
        registerationPage.clickOnRegisterButton();

        String expectedFirstNameErrorMsg = "First name is required.";
        String actualFirstNameErrorMsg = registerationPage.getFirstNameErrorMessage();
        softAssert.assertEquals( actualFirstNameErrorMsg,expectedFirstNameErrorMsg );
        softAssert.assertTrue( true );



    }


    @Test(groups = {"regression"})
    public void verifyUserRegisterSuccessfully() throws InterruptedException {
        registerationPage.clickOnRegisterLink();
        String expectedRegPageText = "Register";
        String actualRegPageText = registerationPage.regPageTextIs();
        softAssert.assertEquals( actualRegPageText,expectedRegPageText );
        softAssert.assertTrue( true );
        Thread.sleep(3000);
        registerationPage.clickOnGenderRadioButton();
        registerationPage.enterFirstNameField("Mikesh");
        registerationPage.enterLastNameField("Chaudhary");
        registerationPage.enterDateOfBirth("1");
        registerationPage.enterMonthOfBirth("January");
        registerationPage.enterYearOfBirth("1990");
        registerationPage.enterEmail("tanyanagpal7@gmail.com");
        registerationPage.setCompanyName("Permanent Roommates");
        registerationPage.setPassword("tvf2018");
        registerationPage.setConfirmPassword("tvf2018");
        registerationPage.clickOnRegisterButton();
        String expectedRegMessage = "Your registration completed";
        String actualRegmessage =registerationPage.registerationSuccessText();
        softAssert.assertEquals(actualRegmessage,expectedRegMessage);
        softAssert.assertTrue( true );
        registerationPage.clickingOnLogout();
    }



}
