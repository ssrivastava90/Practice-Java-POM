package main.java.com.shub.pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import main.java.com.shub.base.BaseTest;

public class LoginPage extends BaseTest{

	
	//Page Factory Object Repo
	@FindBy(name="emailAddress")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement userlogin;
	
	@FindBy(xpath="//button[@text='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement userPassword;
	
	
	LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public String getURLPage() {
		return driver.getCurrentUrl();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		By by = By.xpath("//input[@type='password']");
//		webDriverWait = new WebDriverWait(driver, 20);
//		WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(password));
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(password));
//		
		
//		password.sendKeys(pwd);
//		
//		return new HomePage();
	}
	
	
}
