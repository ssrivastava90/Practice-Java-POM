package shubham;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.shub.base.BaseTest;
import com.shub.pages.FilesPage;
import com.shub.pages.HomePage;
import com.shub.pages.LoginPage;

public class HomePageTests extends BaseTest{
	FilesPage filespage;
	HomePage homepage;
	LoginPage loginpage;
	
	
	public HomePageTests() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
