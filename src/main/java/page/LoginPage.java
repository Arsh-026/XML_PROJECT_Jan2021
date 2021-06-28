package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import util.BrowserFactory;


public class LoginPage extends BasePage {
	
	WebDriver driver; 
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
//	WebElement USER_NAME = driver.findElement(By.xpath("//input[@id='username']"));
//	By USER_NAME_LOCATOR = By.xpath("//input[@id='username']"); (Cannot use these here)
	
	@FindBy(how=How.XPATH, using = "//input[@id='username']") WebElement USERNAME_FIELD;
	@FindBy(how=How.XPATH, using = "//input[@id='password']") WebElement PASSWORD_FIELD;
	@FindBy(how=How.XPATH, using ="//button[@name='login']") WebElement SIGNIN_FIELD;
	
	//Interactive Methods
	
	public void enterUserName(String userName) {
		USERNAME_FIELD.sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		PASSWORD_FIELD.sendKeys(password);
	}
	
	public void clickSignIn() {	
		SIGNIN_FIELD.click();
	}
	

}














//https://github.com/techfios-git/XML_ProjectJan2021.git
//shihab@techfios.com
//214 909 1509







