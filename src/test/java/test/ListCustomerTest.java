package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.CustomerPage;
import page.CustomerSummary;
import page.DashboardPage;
import page.ListCustomerPage;
import page.LoginPage;
import util.BrowserFactory;

public class ListCustomerTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"username", "password", "fullName", "company", "email", "phone", "address", "city", "state", "Zip", "country"})
	public void userShouldBeAbleToUseSearchBarOnListCustomer(String Username, String Password, String fullName,
			String company, String email, String phone, String address, String city, String state, String zip,
			String country) {

		driver = BrowserFactory.init();

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.enterUserName(Username);
		loginPage.enterPassword(Password);
		loginPage.clickSignIn();

		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.validateDashboardPage();
		dashboardPage.clickCustomerButton();
		dashboardPage.clickListCustomerButton();;
//			dashboardPage.clickAddCustomerButton();

		ListCustomerPage listCustomerPage = PageFactory.initElements(driver, ListCustomerPage.class);
		listCustomerPage.clickAddCustomerOnListCustomer();
		listCustomerPage.enterFullName(fullName);
		listCustomerPage.chooseCompanyOption(company);
		listCustomerPage.enterEmail(email);
		listCustomerPage.enterPhoneNumber(phone);
		listCustomerPage.enterAddress(address);
		listCustomerPage.enterCity(city);
		listCustomerPage.enterState(state);
		listCustomerPage.enterZip(zip);
		listCustomerPage.chooseCountryOption(country);
		listCustomerPage.clickSubmitButton();

		CustomerSummary customerSummary = PageFactory.initElements(driver, CustomerSummary.class);
		customerSummary.verifyCustomerSummary();

		dashboardPage.clickListCustomerButton();
		listCustomerPage.enterNameOnSearchBarOnListCustomer();
		listCustomerPage.testListCustomerSummaryButton();
		customerSummary.verifyCustomerSummary();;
		
		BrowserFactory.tearDown();

	}



}


