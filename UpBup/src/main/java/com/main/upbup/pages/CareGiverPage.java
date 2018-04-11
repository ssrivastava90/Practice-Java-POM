package com.main.upbup.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CareGiverPage {
    LoginPage loginPage;
    HomePage homePage;
    CareGiverPage careGiverPage;
    WebDriver webDriver;
    WebDriverWait wait;
    public CareGiverPage(WebDriver driver){
        webDriver = driver;
        PageFactory.initElements(driver,this);
        wait = new WebDriverWait(driver,15);
    }

    public boolean checkCareGiverExist(String careGiver){
        WebElement careGiverName =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr/td[text()='" + careGiver + "']")));
        return careGiverName.isDisplayed();
    }
}
