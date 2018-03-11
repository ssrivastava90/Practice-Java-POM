package Utilities;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.shub.base.BaseTest;

public class WebDriverActions extends BaseTest {
WebElement element;
	
	private WebElement fetchElement(String locator) throws InterruptedException {
		// locator should be in Strategy,locator pattern
		String[] locSplit = locator.split(",");
		String strategy = locSplit[0];
		String exactLocator = locSplit[1];
		
		try {
		switch (strategy) {
		case "XPATH":
			element =  (WebElement) driver.findElements(By.xpath(exactLocator));
			break;
		case "ID":
			element = (WebElement) driver.findElements(By.id(exactLocator));
			break;
		case "NAME":
			element = (WebElement) driver.findElements(By.tagName(exactLocator));
			break;
		case "CLASS":
			element = (WebElement) driver.findElements(By.className(exactLocator));
			break;
		case "CSS":
			element = (WebElement) driver.findElements(By.cssSelector(exactLocator));
			break;
		}}catch(ElementNotFoundException e) {
			System.out.println("Element not found - " + exactLocator);
			
		}
	
		webDriverWait = new WebDriverWait(driver,30);
		
		webDriverWait.until(ExpectedConditions.visibilityOf(element));
				
		if(element.isDisplayed() && element.isEnabled()) {
			return element;
		}
	return null;
	} 
	
	
	private List<WebElement> fetchElements(String locator) throws InterruptedException {
		// locator should be in Strategy,locator pattern
		String[] locSplit = locator.split(",");
		String strategy = locSplit[0];
		String exactLocator = locSplit[1];
		List<WebElement> elements = new LinkedList<WebElement>();
		
		try {
		switch (strategy) {
		case "XPATH":
			elements =  driver.findElements(By.xpath(exactLocator));
			break;
		case "ID":
			elements = driver.findElements(By.id(exactLocator));
			break;
		case "NAME":
			elements = driver.findElements(By.tagName(exactLocator));
			break;
		case "CLASS":
			elements = driver.findElements(By.className(exactLocator));
			break;
		case "CSS":
			elements = driver.findElements(By.cssSelector(exactLocator));
			break;
		}}catch(ElementNotFoundException e) {
			System.out.println("Element not found - " + exactLocator);
			
		}
	
		return elements;
		
	} 

	public void clickOnElement(String loc) throws InterruptedException {
		WebElement webElement = this.fetchElement(loc);
		if(webElement!=null) {
			webElement.click();
		}
	}
		
	public void typeOnElement(String loc,String text) throws InterruptedException {
		WebElement webElement = this.fetchElement(loc);
		if(webElement!=null) {
			webElement.sendKeys(text);
		}
	}
	
	
	public String getText(String loc) throws InterruptedException {
		WebElement webElement = this.fetchElement(loc);
		if(webElement!=null) {
			return webElement.getText();
		}
		return null;
	}
	
	public String getTagName(String loc) throws InterruptedException {
		WebElement webElement = this.fetchElement(loc);
		if(webElement!=null) {
			return webElement.getTagName();
		}
		return null;
	}

	public List<WebElement> getAllElements(String loc) throws InterruptedException {
		List<WebElement> webElements = this.fetchElements(loc);
		if(webElements!=null) {
			return webElements;
		}
		return null;
	}
	
	

}
