package shubham;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shub.pages.HomePage;
import com.shub.pages.LoginPage;
import com.shub.base.BaseTest;;

public class LoginPageTest extends BaseTest{

	HomePage homepage;
	LoginPage loginpage;
	
	LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
	}

	@Test
	public void checkURL() {
		Assert.assertEquals(loginpage.getURLPage(), "https://qawindows.veraqa.com/");
	}

	@Test
	public void login() throws InterruptedException {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String url = homepage.getURLFile();
		Assert.assertEquals(url, "https://qawindows.veraqa.com/dashboard");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
