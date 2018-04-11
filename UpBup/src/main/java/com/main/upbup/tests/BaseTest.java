package com.main.upbup.tests;

import com.main.upbup.base.BaseInitialization;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest extends BaseInitialization{


    public BaseTest(){
        super();
        initialization();
    }

    @BeforeTest
    public void testURL(){
//        Assert.assertEquals(webDriver.getCurrentUrl(),"https://upbup-dev.herokuapp.com/login");
        System.out.println("TEST URL OPened");
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }

}
