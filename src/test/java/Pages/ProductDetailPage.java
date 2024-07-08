package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailPage {
	
	WebDriver driver = null;
	
	By btn_addToCart = By.xpath("//*[@id='add-to-cart']");
	
	public ProductDetailPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void addtoCart() {
		driver.findElement(btn_addToCart).click();
	}
}
