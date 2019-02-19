package com.plivo.controller;
/**
 * @author: Varnit
 * Created on 19th Feb 2019
 */
import com.plivo.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProfilePage extends Base {

    WebDriverWait wait;
    Actions actions;
    JavascriptExecutor js;
    @FindBy(xpath = "//button[contains(text(),\"Let's get started!\")]")
    WebElement letsGetStarted;
    // By letsGetStarted1;

    @FindBy(xpath = "//a[@id='add-page']")
    WebElement newPage;

    @FindBy(xpath = "//form[contains(@class,'unsubmittable')]//input[contains(@name,'name')]")
    WebElement enterNewName;

    @FindBy(xpath = "//button[contains(text(),'Create') and contains(@class,'ui-corner-all ui-button')]")
    WebElement createPage;

    @FindBy(xpath = "//a[contains(text(),'Messaging')]")
    WebElement messagingGroup;

    @FindBy(xpath = "//a[contains(text(),'Basic')]")
    WebElement basicGroup;

    @FindBy(xpath = "//li[text()='Send an SMS']")
    WebElement sendAnSms;

    @FindBy(xpath = "//li[text()='Send an Email']")
    WebElement sendAnEmail;

    @FindBy(xpath = "//div[@id='tabs-2' and @class='ui-page-panel ui-tabs-panel ui-widget-content ui-droppable']")
    WebElement dropLocation;

    @FindBy(xpath = "//div[@id='module-1']//div[contains(@class,'module-title')][contains(text(),'Start')]/parent::div/parent::div/parent::div/following-sibling::div[@class='mod-rail mod-south']/child::div")
    WebElement startLine;

    @FindBy(xpath = "//div[contains(@class,'module-title module-title-alt')][contains(text(),'Send an SMS')]/parent::div/parent::div/parent::div/following-sibling::div[@class='mod-rail mod-north']/child::div")
    WebElement sendSMSNorthPoint;

    @FindBy(xpath = "//textarea[contains(@name,'phone_constant')]")
    WebElement enterPhoneNo;

    @FindBy(xpath = "//tbody//div[contains(@class,'syn-selectappvar-wrap')]//textarea[contains(@name,'message_phrase[]')]")
    WebElement enterMessageText;

    @FindBy(xpath = "//input[contains(@name,'smtp_url')]")
    WebElement enterSMTPHost;

    @FindBy(xpath = "//input[contains(@name,'port')]")
    WebElement enterPort;

    @FindBy(xpath = "//div[contains(@class,'left')]//input[contains(@name,'username')]")
    WebElement enterUsername;

    @FindBy(xpath = "//input[contains(@name,'password')]")
    WebElement enterPassword;

    @FindBy(xpath = "//textarea[contains(@name,'from_constant')]")
    WebElement fromEmail;

    @FindBy(xpath = "//textarea[contains(@name,'to_constant')]")
    WebElement toEmail;

    @FindBy(xpath = "//textarea[contains(@name,'subject_constant')]")
    WebElement emailSubject;

    @FindBy(xpath = "//div[contains(@class,'panel-subsection')]//tbody//div[contains(@class,'syn-selectappvar-wrap')]//textarea[contains(@name,'message_phrase[]')]")
    WebElement emailMessage;

    @FindBy(xpath = "//div[contains(text(),'Send an Email')][contains(@class,'module-title')]/parent::div/parent::div/parent::div/following-sibling::div[@class='mod-rail mod-north']/child::div")
    WebElement sendEmailNorthPoint;

    @FindBy(xpath = "//div[contains(@class,'module-title module-title-alt')][contains(text(),'Send an SMS')]/parent::div/parent::div/following-sibling::div[@class='panel-bd']/child::div[@class='inner']/child::div[@class='panel-nodes-attached inner']/child::div[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']")
    WebElement sendSMSEastPoint;

    @FindBy(xpath = "//div[contains(@class,'module-title module-title-alt')][contains(text(),'Send an SMS')]/parent::div/parent::div/following-sibling::div[@class='panel-bd']/child::div[@class='inner']/child::div[@class='panel-nodes-attached inner']/child::div[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']")
    WebElement sendSMSWestPoint;

    @FindBy(xpath = "//li[text()='Hang Up or Exit']")
    WebElement exitApp;

    @FindBy(xpath = "//div[contains(text(),'Send an Email')][contains(@class,'module-title')]/parent::div/parent::div/following-sibling::div[@class='panel-bd']/child::div[@class='inner']/child::div[@class='panel-nodes-attached inner']/child::div[@class='syn-node syn-node-attached-e ui-draggable syn-node-active']")
    WebElement sendEmailEastPoint;

    @FindBy(xpath = "//div[contains(text(),'Send an Email')][contains(@class,'module-title')]/parent::div/parent::div/following-sibling::div[@class='panel-bd']/child::div[@class='inner']/child::div[@class='panel-nodes-attached inner']/child::div[@class='syn-node syn-node-attached-w ui-draggable syn-node-active']")
    WebElement sendEmailWestPoint;

    public ProfilePage() {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 10);
        actions = new Actions(driver);
        js = (JavascriptExecutor) driver;
    }

    /**
     * This method would explicitly wait for letsGetStarted button to be visible and then clicks on it
     */
    public void letsGetStarted() {
        wait.until(ExpectedConditions.visibilityOf(letsGetStarted));
        letsGetStarted.click();
    }

    /**
     * This method creates the new page
     *
     * @param pageName
     */
    public void createNewPage(String pageName) {
        newPage.click();
        enterNewName.sendKeys(pageName);
        actions.moveToElement(createPage).build().perform();
        js.executeScript("arguments[0].click();", createPage);
    }

    /**
     * This method clicks on messaging module
     */
    public void clickOnMessagingModule() {
        messagingGroup.click();
    }

    /**
     * This method drag and drop SendAnSMS component from left panel to the main app page
     *
     * @param smsXOffset
     * @param smsYOffset
     */
    public void dragComponentSendAnSMS(int smsXOffset, int smsYOffset) {
        wait.until(ExpectedConditions.elementToBeClickable(sendAnSms));
        actions.clickAndHold(sendAnSms).moveToElement(dropLocation).moveByOffset(smsXOffset, smsYOffset).release().build().perform();

    }

    /**
     * This method would join the line from start component to sendSMS component
     */
    public void joinLineStartToSendSMS() {
        actions.dragAndDrop(startLine, sendSMSNorthPoint).build().perform();
    }

    /**
     * This method would fill in the sms details
     *
     * @param phone
     * @param smsMessage
     */
    public void enterSMSDetails(String phone, String smsMessage) {
        enterPhoneNo.sendKeys(phone);
        enterMessageText.sendKeys(smsMessage);
    }

    /**
     * This method would drag the sendEmail component from left panel to the mail app page
     *
     * @param emailXOffset
     * @param emailYOffset
     */
    public void dragComponentSendEmail(int emailXOffset, int emailYOffset) {
        wait.until(ExpectedConditions.elementToBeClickable(sendAnEmail));
        actions.clickAndHold(sendAnEmail).moveToElement(dropLocation).moveByOffset(emailXOffset, emailYOffset).release().build().perform();

    }

    /**
     * This method would fill in the email details
     *
     * @param smtp
     * @param port
     * @param username
     * @param password
     * @param enterFromEmail
     * @param enterToEmail
     * @param emailSub
     * @param emailMess
     */
    public void enterEmailDetails(String smtp, String port, String username, String password, String enterFromEmail, String enterToEmail, String emailSub, String emailMess) {
        enterSMTPHost.sendKeys(smtp);
        enterPort.sendKeys(port);
        enterUsername.sendKeys(username);
        enterPassword.sendKeys(password);
        fromEmail.sendKeys(enterToEmail);
        toEmail.sendKeys(enterFromEmail);
        emailSubject.sendKeys(emailSub);
        emailMessage.sendKeys(emailMess);
    }

    /**
     * This method would join line from Not sent output port of send an SMS
     * to send an email component
     */
    public void joinLineSMStoEmail() {
        actions.dragAndDrop(sendSMSEastPoint, sendEmailNorthPoint).build().perform();
    }

    /**
     * This method clicks on Basic module on the left panel
     */
    public void clickOnBasicModule() {
        basicGroup.click();
    }

    /**
     * This method would drag and drop the Exit app component from left panel to the mail app page
     *
     * @param exitXOffset
     * @param exitYOffset
     */
    public void dragComponentExitApp(int exitXOffset, int exitYOffset) {
        wait.until(ExpectedConditions.elementToBeClickable(exitApp));
        actions.clickAndHold(exitApp).moveToElement(dropLocation).moveByOffset(exitXOffset, exitYOffset).release().build().perform();
    }

    /**
     * This method returns the list of Exit App components being dropped on the main app page from left panel
     *
     * @return
     */
    public List<WebElement> numberOfExitApp() {
        List<WebElement> exitApp = driver.findElements(By.xpath("//div[contains(text(),'Exit App')]/parent::div/parent::div/parent::div/following-sibling::div[@class='mod-rail mod-north']/child::div"));
        return exitApp;
    }


    /**
     * This method joins sent output of Sent an sms to exit app
     * joins sent output of send an email to exit app
     * joins not sent output of send an email to exit app
     */
    public void joinLinesToExitApp() {

        actions.dragAndDrop(sendSMSWestPoint, numberOfExitApp().get(0)).build().perform();
        actions.dragAndDrop(sendEmailWestPoint, numberOfExitApp().get(1)).build().perform();
        actions.dragAndDrop(sendEmailEastPoint, numberOfExitApp().get(2)).build().perform();
    }
}
