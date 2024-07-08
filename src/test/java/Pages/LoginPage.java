package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver = null;
	
	By input_username = By.xpath("//*[@id='user-name']");
	
	By input_password = By.xpath("//*[@id='password']");
	
	By btn_login = By.xpath("//*[@id='login-button']");
	
	By txt_error = By.xpath("//*[@data-test='error']");
	
	By txt_lockedout = By.xpath("//*[contains(text(),'Sorry, this user has been locked out.')]");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void setUsername(String username) {
		driver.findElement(input_username).sendKeys(username);
	}
	
	public void clearUsername() {
		driver.findElement(input_username).clear();
	}
	
	public void setPassword(String password) {
		driver.findElement(input_password).sendKeys(password);
	}
	
	public void clearPassword() {
		driver.findElement(input_password).clear();
	}

	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void error_isDisplayed() {
		driver.findElement(txt_error).isDisplayed();
	}
	
	public void verify_errormessage(String error_messgae) {
		driver.findElement(txt_lockedout).equals(error_messgae);
	}
	
	public void assertInputUsername() {
		driver.findElement(input_username).isDisplayed();
	}
	
	public void assertInputPassword() {
		driver.findElement(input_password).isDisplayed();
	}
}
