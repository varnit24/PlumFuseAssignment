package com.plivo.controller;
/**
 * @author: Varnit
 * Created on 19th Feb 2019
 */
import com.plivo.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    @FindBy(linkText = "Create an App")
    WebElement createApp;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    /**
     * This method would return the title of home page
     *
     * @return
     */
    public String verifyHomePageTitle() {
        return driver.getTitle();
    }

    /**
     * this method would click on CreateAnApp link and returns the new object of profile page
     *
     * @return
     */
    public ProfilePage clickOnCreateAnAppLink() {
        createApp.click();
        return new ProfilePage();
    }

}
