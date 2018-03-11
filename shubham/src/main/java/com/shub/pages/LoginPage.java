package com.shub.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.Function;
import com.shub.base.BaseTest;

import Utilities.BrowserActions;
import Utilities.WebDriverActions;

//import ru.stqa.selenium.wait.ExpectedConditions;


public class LoginPage extends BaseTest{
	private BrowserActions browserActions;
	private WebDriverActions webDriverActions;
	
	
	//Page Factory Object Repo
	@FindBy(xpath="//input[@placeholder='Email address']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement userlogin;
	
	@FindBy(xpath="//button[text()='Continue']")
	WebElement continueButton;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement userPassword;
	
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
		this.browserActions = new BrowserActions();
		this.webDriverActions = new WebDriverActions();
	}
	
	public String getURLPage() {
		return browserActions.getUrl();
	}
	
	
	public HomePage login(String un, String pwd) throws InterruptedException {
		
		webDriverWait = new WebDriverWait(driver,30);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		
		Thread.sleep(2000);
		username.sendKeys(un);
		By by = By.xpath("//input[@type='password']");
//		webDriverWait = new WebDriverWait(driver, 20);
		WebElement webElement = webDriverWait.until(ExpectedConditions.elementToBeClickable(password));

//		webDriverWait.until(ExpectedConditions.elementToBeClickable(password));		
		continueButton.click();
		
		Thread.sleep(2000);

		password.sendKeys(pwd);
		continueButton.click();
		return new HomePage();
	}

	
	
}
