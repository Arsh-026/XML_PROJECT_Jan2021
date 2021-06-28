package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;



public class LoginTest {
	
	WebDriver driver;
	

	@Test
	@Parameters({"username", "password"})
	public void validUserShouldBeAbleToLogin(String Username, String Password) {
		
		driver = BrowserFactory.init();
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(Username);
		loginPage.enterPassword(Password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		
		BrowserFactory.tearDown();
	
		
		
	}
	
	
	


		
	}

