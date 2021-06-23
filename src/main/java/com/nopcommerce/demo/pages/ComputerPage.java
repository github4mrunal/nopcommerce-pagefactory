package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utility.Utility;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


    public class ComputerPage extends Utility {
        private static final Logger log= LogManager.getLogger(ComputerPage.class.getName());

        HomePage homepage = new HomePage();

        @FindBy(xpath="//body[1]/div[6]/div[2]/ul[1]/li[1]/a[1]")
        WebElement hoverComputerTab;
        @FindBy(xpath ="//body[1]/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[1]/a[1]" )
        WebElement clickOnDesktop;
        @FindBy(xpath = "//body[1]/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[2]/a[1]")
        WebElement clickOnNoteBooks;
        @FindBy(xpath = "//body[1]/div[6]/div[2]/ul[1]/li[1]/ul[1]/li[3]/a[1]")
        WebElement clickOnSoftWare;
        @FindBy(xpath = "//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]/h1[1]")
        WebElement desktopText;
        @FindBy(xpath="//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]/h1[1]")
        WebElement notebookText;
        @FindBy(xpath="//body[1]/div[6]/div[3]/div[1]/div[3]/div[1]/div[1]/h1[1]")
        WebElement softwareText;


        public void clickOnComputersTab() throws InterruptedException {
            homepage.selectMenu( "Computers" );

        }

        public void hoverComputerTab(){
            mouseHoverToElement(hoverComputerTab);
        }


        public void clickOnDesktopOption() throws InterruptedException {
            Reporter.log("Clicking on Desktop options:" + clickOnDesktop.toString() + "<br>");
            Thread.sleep(3000);
            clickOnElement( clickOnDesktop );
            log.info("Clicking on Desktop options:" + clickOnDesktop.toString());
        }
        public void clickOnNoteBookOption() throws InterruptedException {
            Thread.sleep( 2000 );
            Reporter.log("Clicking on notebook options:" + clickOnNoteBooks.toString() + "<br>");
            clickOnElement( clickOnNoteBooks);
            log.info("Clicking on Desktop options:" + clickOnNoteBooks.toString());
        }
        public void clickOnSoftwareOption() throws InterruptedException {
            Thread.sleep( 2000 );
            Reporter.log("Clicking on software options:" + clickOnSoftWare.toString() + "<br>");
            clickOnElement( clickOnSoftWare);
            log.info("Clicking on Desktop options:" + clickOnSoftWare.toString());
        }
        public String getDeskTopText(){
            Reporter.log("Desktop text:" + desktopText.toString() + "<br>");
            log.info("Desktop Text:" + desktopText.toString());
            return getTextFromElement(desktopText);
        }

        public String getNotebookText(){
            Reporter.log("Notebook text:" + notebookText.toString() + "<br>");
            log.info("Desktop Text:" + notebookText.toString());
            return getTextFromElement(notebookText);
        }

        public String getSoftwareText(){
            Reporter.log("Notebook text:" + softwareText.toString() + "<br>");
            log.info("Desktop Text:" + softwareText.toString());
            return getTextFromElement(softwareText);
        }



    }


