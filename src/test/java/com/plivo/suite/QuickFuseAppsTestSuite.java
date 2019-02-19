package com.plivo.suite;

/**
 * @author: Varnit
 * Created on 19th Feb 2019
 */

import com.plivo.base.Base;
import com.plivo.controller.HomePage;
import com.plivo.controller.ProfilePage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.util.List;

public class QuickFuseAppsTestSuite extends Base {
    HomePage homePage;
    ProfilePage profilePage;

    public QuickFuseAppsTestSuite() {
        super();
    }

    @BeforeClass
    public void setUp() {
        initialize();
        homePage = new HomePage();
    }

    /**
     * This test method validates the title of home page
     * @throws InterruptedException
     */
    @Test(priority = 0)
    public void homePageTest() throws InterruptedException {
        String homePageTitle = homePage.verifyHomePageTitle();
        Reporter.log("Home page title is: " + homePageTitle);
        Assert.assertEquals(homePageTitle, "Login :: Plum Fuse");
    }

    /**
     * This method validates the end to end flow
     * It creates a new page, drag and drop send an sms component from left panel to the main app page
     * joins the line from start component to send an sms
     * enter sms details
     * drag and drop send an email from left panel to the main app page
     * enters the email details
     * join sms line to email
     * drag and drop exit app from left panel to main app page
     * join lines to the port of exit app
     * @param pageName
     * @param smsXOffSet
     * @param smsYOffSet
     * @param phone
     * @param smsMessage
     * @param emailXOffSet
     * @param emailYOffSet
     * @param smtp
     * @param port
     * @param username
     * @param pwd
     * @param fromEmail
     * @param toEmail
     * @param emailSub
     * @param emailMsg
     * @param exitXoffSet1
     * @param exitYoffset1
     * @param exitXoffSet2
     * @param exitYoffset2
     * @param exitXoffSet3
     * @param exitYoffset3
     */
    @Parameters({"pageName", "smsXOffset", "smsYOffset", "phone", "smsMessage", "emailXOffset", "emailYOffset", "smtp", "port", "username", "password", "fromEmail", "toEmail", "emailSub", "emailMessage", "exitXOffset1", "exitYOffset1", "exitXOffset2", "exitYOffset2", "exitXOffset3", "exitYOffset3"})
    @Test(priority = 1, dependsOnMethods = {"homePageTest"})
    public void profilePageFlowTest(String pageName, int smsXOffSet, int smsYOffSet, String phone, String smsMessage, int emailXOffSet, int emailYOffSet, String smtp, String port, String username, String pwd, String fromEmail, String toEmail, String emailSub, String emailMsg, int exitXoffSet1, int exitYoffset1, int exitXoffSet2, int exitYoffset2, int exitXoffSet3, int exitYoffset3) {
        profilePage = homePage.clickOnCreateAnAppLink();
        profilePage.letsGetStarted();
        profilePage.createNewPage(pageName);
        profilePage.clickOnMessagingModule();
        profilePage.dragComponentSendAnSMS(smsXOffSet, smsYOffSet);
        profilePage.joinLineStartToSendSMS();
        profilePage.enterSMSDetails(phone, smsMessage);
        profilePage.dragComponentSendEmail(emailXOffSet, emailYOffSet);
        profilePage.enterEmailDetails(smtp, port, username, pwd, fromEmail, toEmail, emailSub, emailMsg);
        profilePage.joinLineSMStoEmail();
        profilePage.clickOnBasicModule();
        profilePage.dragComponentExitApp(exitXoffSet1, exitYoffset1);
        profilePage.dragComponentExitApp(exitXoffSet2, exitYoffset2);
        profilePage.dragComponentExitApp(exitXoffSet3, exitYoffset3);
        List<WebElement> number = profilePage.numberOfExitApp();
        Assert.assertEquals(number.size(), 3, "All 3 exit apps are not dragged and dropped successfully");
        profilePage.joinLinesToExitApp();
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
