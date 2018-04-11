package com.main.upbup.tests;

import com.main.upbup.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
    LoginPage loginPage;

    @Test
    @Parameters({"username","password"})
    public void testLogin(){
        loginPage = new LoginPage(webDriver);
        loginPage.loginToUpBup("shubhamsrivastava@live.in","$Hubh@m90");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(loginPage.getCurrentURL(),"https://upbup-dev.herokuapp.com/upbup/caregiver/caregiver_children");

    }



}
