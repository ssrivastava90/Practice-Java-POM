package com.main.upbup.actions;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BrowserActions {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    int wait = 10;

    public BrowserActions(WebDriver driver){
        webDriver = driver;
        webDriverWait = new WebDriverWait(webDriver,10);
    }


    public void switchTabs(String name) {
        Set<String> allTabs = webDriver.getWindowHandles();
        String tabNameWanted = null;
        for (String tabName : allTabs) {
            if (tabName.equalsIgnoreCase(name)) {
                tabNameWanted = tabName;
                break;
            }
        }
        if (null == tabNameWanted) {
            System.out.print("Cannot be done");
        } else {
            webDriver.switchTo().window(tabNameWanted);
        }
    }


    public void navigateForward(){
        webDriver.navigate().forward();
    }

    public void navigateBackward(){
        webDriver.navigate().back();
    }

    public void refresh(){
        webDriver.navigate().refresh();
    }
}
