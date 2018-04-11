package com.main.upbup.tests;

import com.main.upbup.pages.CareGiverPage;
import com.main.upbup.pages.HomePage;
import com.main.upbup.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CareGiverTest extends BaseTest{
    HomePage homePage;
    LoginPage loginPage;
    CareGiverPage careGiverPage;

    public CareGiverTest(){
        loginPage = new LoginPage(webDriver);
        homePage = loginPage.loginToUpBup("shubhamsrivastava@live.in","$Hubh@m90");
        careGiverPage = homePage.navigateToCareGiver();
    }


    //priority, alwaysRun, dependsOn, group
    @Test(dataProvider = "test")
    public void checkCareGiverExists(String uname,String pwd){
        Assert.assertTrue(careGiverPage.checkCareGiverExist("Saurabh"));
    }



    @DataProvider(name="test")
    public Object[][] getParameters(){
//        List<String> ls=new ArrayList<String>();
//        ls.add("one expected");
//        ls.add("Three expected");
//        ls.add("two expected");
//        ls.add("four expected");
//        Object[][] retkeyword={{"One", ls},
//                {"Two", ls},
//                {"Three", ls}};
//        return(retkeyword);
        return new Object[][]{{"PARA1","Val1"},{"Para2","Val2"},{"Para3","Val3"}};
    }
}


