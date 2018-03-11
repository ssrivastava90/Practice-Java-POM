package com.shub.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class BaseTest {
	public static WebDriver driver;
	public static Properties prop;
	public static WebDriverWait webDriverWait;
		public BaseTest() {
			try {
				prop = new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/shub/config/data.properties");
				prop.load(ip);
			} catch (FileNotFoundException e){
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public static void initialization() {
			String browser = prop.getProperty("browser");
			switch(browser) {
			case "Chrome":
				System.setProperty("webdriver.chrome.driver", "/Users/shubham/Documents/GrabTest/drivers/chromedriver");
				driver = new ChromeDriver();
				break;
			case "Firefox":
				System.setProperty("webdriver.gecko.driver", "/Users/shubham/Documents/GrabTest/drivers/geckodriver");
				//driver = new FirefoxDriver();
				break;
			}
			
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitwait")), TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageload")), TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
		}
		
		
	}

