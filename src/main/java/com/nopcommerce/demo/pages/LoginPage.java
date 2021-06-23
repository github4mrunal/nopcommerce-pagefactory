package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


/**
 * Created by Jay
 */
public class LoginPage extends Utility {
    private static final Logger log = LogManager.getLogger(LoginPage.class.getName());


//    By emailField = By.id("Email");
//    By passwordField = By.id("Password");
//    By loginBtn = By.xpath("//input[@class='button-1 login-button']");
//    By welcomeText = By.xpath("//div[@class='page-title']//h1");

    @FindBy(xpath = "//a[text()='Log in']")
    WebElement loginLink;

    @FindBy(xpath = "//input[@id='Email']")
    WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    WebElement loginBtn;

    @FindBy(xpath = "//div[@class='page-title']//h1")
    WebElement welcomeText;

    @FindBy(xpath = "//div[@class = 'message-error validation-summary-errors']")
    WebElement errormessage;

    @FindBy(xpath = "//h2[text()='Welcome to our store']")
    WebElement homePageText;

    public void clickOnLoginLink(){
        Reporter.log("Clicking on Login Link" +loginLink.toString() + "<br>");
        clickOnElement(loginLink);
        log.info("Clicking on Login Link" + loginLink.toString());
    }

    public void enterEmailId(String email) {
        Reporter.log("Entering email address : " + email + " to email field : " + emailField.toString() + "<br>");
        sendTextToElement(emailField, email);
        log.info("Entering email address : " + email + " to email field :" + emailField.toString());
    }

    public void enterPassword(String password) {
        Reporter.log("Entering password : " + password + " to password field : " + passwordField.toString() + "<br>");
        sendTextToElement(passwordField, password);
        log.info("Entering email address : " + password + " to password field :" + passwordField.toString());
    }

    public void clickOnLoginButton() throws InterruptedException {
        Thread.sleep(3000);
        Reporter.log("Clicking on login button : " + loginBtn.toString() + "<br>");
        clickOnElement(loginBtn);
        log.info("Clicking on login button :" + loginBtn.toString());
    }

    public String getWelcomeText() {
        Reporter.log("Getting text from : " + welcomeText.toString() + "<br>");
        return getTextFromElement(welcomeText);

    }

    public String getErrorMessage() {
        Reporter.log("Getting Error Message" + errormessage.toString() + "<br>");
        return getTextFromElement(errormessage);
    }

    public String getHomePageText() {
        mouseHoverToElement(homePageText);
        Reporter.log("Get homepage Msg Text" + homePageText.toString());
        log.info("Get homepage Msg Text" + homePageText.toString());
        return getTextFromElement(homePageText);


    }
}