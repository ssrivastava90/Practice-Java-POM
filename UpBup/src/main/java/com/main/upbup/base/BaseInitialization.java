package com.main.upbup.base;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseInitialization {

    public static WebDriver webDriver;
    public static Properties properties;
    public static WebDriverWait webDriverWait;

    public BaseInitialization(){
        try{
            properties = new Properties();
            Path propertyFile = Paths.get("src","main","java","resource");
            BufferedReader reader = new BufferedReader(new FileReader(propertyFile + File.separator + "configProperties.properties"));
            properties.load(reader);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void initialization(){
        String browser=null;
        browser = properties.getProperty("browser");
        Path driver = Paths.get("src","main","java","resource");
        switch(browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", driver + File.separator + "chromedriver");
                webDriver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", driver + File.separator + "geckodriver");
                webDriver = new FirefoxDriver();
                break;
        }

        //Setting properties
        webDriver.manage().timeouts().implicitlyWait(Integer.parseInt(properties.getProperty("wait")), TimeUnit.MILLISECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(Integer.parseInt(properties.getProperty("wait")), TimeUnit.MILLISECONDS);
        webDriver.manage().window().maximize();
        // Getting environment
        String env = properties.getProperty("environment");
        switch(env){
            case "dev":
                webDriver.get(properties.getProperty("dev"));
                break;
            case "base":
                webDriver.get(properties.getProperty("base"));
                break;
        }
        bringToFront();
    }

    private static void bringToFront(){
        //Store the current window handle
        String currentWindowHandle = webDriver.getWindowHandle();

        //run your javascript and alert code
                ((JavascriptExecutor)webDriver).executeScript("alert('Test')");
                webDriver.switchTo().alert().accept();

        //Switch back to to the window using the handle saved earlier
                webDriver.switchTo().window(currentWindowHandle);
    }
}
