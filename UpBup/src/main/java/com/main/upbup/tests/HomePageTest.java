package com.main.upbup.tests;

import com.main.upbup.pages.HomePage;
import com.main.upbup.pages.LoginPage;

public class HomePageTest extends BaseTest {
    HomePage homePage;

    HomePageTest(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.loginToUpBup("shubhamsrivastava@live.in","$Hubh@m90");
    }



}
