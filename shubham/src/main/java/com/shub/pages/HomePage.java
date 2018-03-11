package com.shub.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.shub.base.BaseTest;

public class HomePage extends BaseTest {
	
	
	//Object repo
	@FindBy(xpath="//a[@text='23r34t']")
	WebElement Logo;
	
	
	@FindBy(xpath="//a[@text='SecureFiles']")
	WebElement SecureFiles;
	
	@FindBy(xpath="//span[@text='4']")
	WebElement GroupCount;

	@FindBy(xpath="//li/a[@text='Files']")
	WebElement FilesLink;
	
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	
	public FilesPage clickFileLink() {
		FilesLink.click();
		return new FilesPage();
	} 
	
	public String getURLFile() {
		return driver.getCurrentUrl();
	}
	
	
	
	
	
}
