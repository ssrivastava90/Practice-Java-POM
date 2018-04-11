package com.main.upbup.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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
        String[] aLocStrategy = getStrategyLocator(loc);
        WebElement webElement=null;

        switch (aLocStrategy[0]){
            case "XPATH":
                webElement = webDriver.findElement(By.xpath(aLocStrategy[1]));
                break;
            case "ID":
                webElement = webDriver.findElement(By.id(aLocStrategy[1]));
                break;
            case "CLASSNAME":
                webElement = webDriver.findElement(By.className(aLocStrategy[1]));
                break;
        }

        if(null!=webElement) {
            if (!webElement.isDisplayed()) {
//                webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(webElement);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return webElement;
        }
        return webElement;
    }



    private List<WebElement> fetchElements(String loc,int timeout){
        String[] aLocStrategy = getStrategyLocator(loc);
        List<WebElement> webElements=null;

        switch (aLocStrategy[0]){
            case "XPATH":
                webElements = webDriver.findElements(By.xpath(aLocStrategy[1]));
                break;
            case "ID":
                webElements = webDriver.findElements(By.id(aLocStrategy[1]));
                break;
            case "CLASSNAME":
                webElements = webDriver.findElements(By.className(aLocStrategy[1]));
                break;
        }

        if(null!=webElements) {
        while((webElements.size()==0)&&(timeout>0)) {
                webDriverWait.until(ExpectedConditions.visibilityOfAllElements(webElements));
                waitFor(2);
                timeout = timeout-2;
            }
        }
        return webElements;
    }


    public void waitFor(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // get locator and strategy
    private String[] getStrategyLocator(String loc){
        String strArray[] = new String[2];
        strArray[0] = loc.split(",")[0];
        strArray[1] = loc.split(",")[1];

        return strArray;
    }


    public void typeTo(String loc,String text){
        WebElement webElement = fetchElement(loc);
        try {
            webElement.sendKeys(text);
        }catch (StaleElementReferenceException e){
            webElement = fetchElement(loc);
            webElement.sendKeys(text);
        }
    }

    public void clickOn(String loc){
        WebElement webElement = fetchElement(loc);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        try {
            webElement.click();
        }catch (StaleElementReferenceException e){
            webElement = fetchElement(loc);
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }
    }

    public List<String> getAllItemText(String loc){
        List<WebElement> listWebElement = fetchElements(loc,20);
        List<String> lString = new ArrayList<>();
        for(WebElement webElement:listWebElement){
            lString.add(webElement.getText());
        }
        return lString;
    }

    public boolean isElementDisplayed(String loc){
        WebElement webElement = fetchElement(loc);
        return webElement.isDisplayed();
    }

    public boolean isElementEnabled(String loc){
        WebElement webElement = fetchElement(loc);
        return webElement.isEnabled();
    }

}
