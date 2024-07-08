package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	WebDriver driver = null;
	
	By btn_checkout = By.xpath("//*[@id='checkout']");
	
	By input_firstName = By.xpath("//*[@id='first-name']");
	
	By input_lastName = By.xpath("//*[@id='last-name']");
	
	By input_postalCode = By.xpath("//*[@id='postal-code']");
	
	By txt_errorMessage = By.xpath("//*[text()='Error: Last Name is required']");
	
	By btn_continue = By.xpath("//*[@id='continue']");
	
	public CheckoutPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void checkoutCart() {
		driver.findElement(btn_checkout).click();
	}
	
	public void setFirstName(String txt) {
		driver.findElement(input_firstName).sendKeys(txt);
	}
	
	public void setLastName(String txt) {
		driver.findElement(input_lastName).sendKeys(txt);
	}
	
	public void setPostalCode(String txt) {
		driver.findElement(input_postalCode).sendKeys(txt);
	}
	
	public void errorMessageisDisplayed() {
		driver.findElement(txt_errorMessage).isDisplayed();
	}
	
	public void checkoutContinue() {
		driver.findElement(btn_continue).click();
	}
}
