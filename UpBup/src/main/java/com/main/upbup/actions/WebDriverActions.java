package com.main.upbup.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WebDriverActions {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    int wait = 10;

    public WebDriverActions(WebDriver driver){
        webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver,10);
    }


    private WebElement fetchElement(String loc){
        String strategy = loc.split(",")[0];
        String actualLoc = loc.split(",")[1];

        WebElement ele = webDriver.findElement(By.xpath("//div[@class='']"));

        if(!ele.isDisplayed()){
            ele = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("")));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return ele;
    }


    private List<WebElement> fetchElements(String loc){
        String strategy = loc.split(",")[0];
        String actualLoc = loc.split(",")[1];

        List<WebElement> elements = webDriver.findElements(By.xpath("//div[@class='']"));

        return elements;
    }


    public void typeTo(String loc,String text){

        WebElement webElement = fetchElement(loc);
        webElement.sendKeys(text);
    }

}
