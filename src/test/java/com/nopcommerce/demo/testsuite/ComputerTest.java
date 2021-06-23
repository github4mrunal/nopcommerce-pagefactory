package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.*;


public class ComputerTest extends TestBase {
        ComputerPage computerPage;

        @BeforeMethod(alwaysRun = true)

        public void registerPageSetUp(){
            computerPage=new ComputerPage();
        }
        //Click On computer-1
        @Test(groups = {"sanity", "smoke", "regression"})
        public void navigateToDesktop() throws InterruptedException {

            computerPage.hoverComputerTab();
          //  computerPage.clickOnComputersTab();
            Thread.sleep(3000);
            computerPage.clickOnDesktopOption();
           String expectedDesktoptext = "Desktops";  //verify Register text
            String actualDesktopText = computerPage.getDeskTopText();
            Assert.assertEquals(expectedDesktoptext, actualDesktopText);
        }

        @Test(groups = {"smoke", "regression"})
        public void navigateToNotebooks() throws InterruptedException {
            computerPage.hoverComputerTab();
            //computerPage.clickOnComputersTab();
            Thread.sleep(3000);
            computerPage.clickOnNoteBookOption();
            String expectedNotebookText = "Notebooks";  //verify Register text
            String actualNotebookText = computerPage.getNotebookText();
            Assert.assertEquals(expectedNotebookText, actualNotebookText);
        }

        @Test(groups = {"regression"})
        public void navigateToSoftware() throws InterruptedException {
            computerPage.hoverComputerTab();
           // computerPage.clickOnComputersTab();
            computerPage.clickOnSoftwareOption();
            String expectedSoftwareText = "Software";  //verify Register text
            String actualSoftwareText = computerPage.getSoftwareText();
            Assert.assertEquals(expectedSoftwareText, actualSoftwareText);
        }


    }


