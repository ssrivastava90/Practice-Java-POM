package com.main.upbup.pages;

import com.main.upbup.actions.BrowserActions;
import com.main.upbup.actions.WebDriverActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.main.upbup.locators.LoginPageLocators;
import sun.rmi.runtime.Log;

public class LoginPage {
    HomePage homePage;
    WebDriver driver;
    BrowserActions browserActions;
    WebDriverActions webDriverActions;
    Logger logger;

//    @FindBy(id = "username")
//    WebElement username;
//
//    @FindBy(id = "password")
//    WebElement password;
//
//    @FindBy(xpath = "//div/button[@class = 'btn btn-lg btn-primary btn-block']")
//    WebElement loginButton;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitForPageLoaded();
        browserActions = new BrowserActions(driver);
        webDriverActions = new WebDriverActions(driver);
        logger = Logger.getLogger(Log.class.getName());
    }


    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }


    public void enterUserName(String user){
        webDriverActions.typeTo(LoginPageLocators.USERNAMEF,user);
        logger.info("Entered Username " + user);
    }

    public void enterPassword(String passwrd)
    {
        webDriverActions.typeTo(LoginPageLocators.PASSWORDF,passwrd);
        logger.info("Entered Password " + passwrd);
    }


    public void pressLogin(){

        webDriverActions.clickOn(LoginPageLocators.SUBMITB);
    }

    public HomePage loginToUpBup(String user,String passwrd){
        enterUserName(user);
        enterPassword(passwrd);
        System.out.println("USERNAME: " + user);
        System.out.println("PASSWORD: " + passwrd);

        webDriverActions.clickOn(LoginPageLocators.SUBMITB);
        homePage = new HomePage(driver);
        return homePage;
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();

    }
}
