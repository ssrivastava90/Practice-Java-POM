package com.main.upbup.pages;

import com.main.upbup.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest{

    HomePage homePage;
    CareGiverPage careGiverPage;
    WebDriver driver;

    //Locators
//    @FindBy(xpath = "//a[@class = 'k-button k-button-icontext k-grid-caregivers k-state-border-down']")
    @FindBy(xpath = "//td/a[text()='Caregivers']")
    WebElement careGiver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public CareGiverPage navigateToCareGiver(){
        careGiver.click();
        careGiverPage = new CareGiverPage(driver);
        return careGiverPage;
    }
}
