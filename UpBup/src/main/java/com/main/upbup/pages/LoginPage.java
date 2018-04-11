package com.main.upbup.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    HomePage homePage;
    WebDriver driver;

    @FindBy(id = "username")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(xpath = "//div/button[@class = 'btn btn-lg btn-primary btn-block']")
    WebElement loginButton;



    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
        waitForPageLoaded();
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
        username.sendKeys(user);
    }

    public void enterPassword(String passwrd){
        password.sendKeys(passwrd);
    }


    public void pressLogin(){
        loginButton.click();
    }

    public HomePage loginToUpBup(String user,String passwrd){
        username.sendKeys(user);
        password.sendKeys(passwrd);
        System.out.println("USERNAME: " + user);
        System.out.println("PASSWORD: " + passwrd);
        loginButton.click();
        homePage = new HomePage(driver);
        return homePage;
    }

    public String getCurrentURL(){
        return driver.getCurrentUrl();

    }
}
