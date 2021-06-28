package test;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.CustomerPage;
import page.CustomerSummary;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class CustomerTest {
	
	WebDriver driver;
	
	
	@Test
	@Parameters({"username", "password", "fullName", "company", "email", "phone", "address", "city", "state", "Zip", "country"})
	public void validUserShouldBeAbleToAddCustomer(String Username, String Password, String fullName, String company, String email, String phone, String address, String city, String state, String zip, String country) {
		
		driver = BrowserFactory.init();
		 
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(Username);
		loginPage.enterPassword(Password);
		loginPage.clickSignIn();
		
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickAddCustomerButton();
		
		CustomerPage addCustomerPage = PageFactory.initElements(driver, CustomerPage.class);
		addCustomerPage.enterFullName(fullName);
		addCustomerPage.chooseCompanyOption(company);
		addCustomerPage.enterEmail(email);
		addCustomerPage.enterPhoneNumber(phone);
		addCustomerPage.enterAddress(address);
		addCustomerPage.enterCity(city);
		addCustomerPage.enterState(state);
		addCustomerPage.enterZip(zip);
		addCustomerPage.chooseCountryOption(country);
		addCustomerPage.clickSubmitButton();
		
		CustomerSummary customerSummary = PageFactory.initElements(driver, CustomerSummary.class);
		customerSummary.verifyCustomerSummary();
		
		dashboardPage.clickListCustomerButton();
		addCustomerPage.verifyEnteredNameAndDelete();
		
		BrowserFactory.tearDown();
	}
}







//https://github.com/techfios-git/POM_Project_Jan2021.git
