package Utilities;
import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.shub.base.BaseTest;

public class BrowserActions extends BaseTest{	
	
	public void switchFrame() {
		driver.switchTo().frame(0);
	}
	
	public void clearCache() {
		driver.manage().deleteAllCookies();
	}
	
	public void sleep(long waitTime) throws InterruptedException{
		Thread.sleep(waitTime);
	}
	
	public void switchToTab(String name) {
		Set<String> allHandles = driver.getWindowHandles();
		int ind = 0;
		for(String nam:allHandles) {
			if(name.equalsIgnoreCase(nam)) {
				break;
			}
			ind++;
		}
		
		driver.switchTo().window(name);
	}
	
	public Set<String> getAllTabs() {
		Set<String> allHandles = driver.getWindowHandles();
		return allHandles;
	}
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
}
