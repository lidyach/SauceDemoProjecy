package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
	
	WebDriver driver = null;

	By txt_inventory_item1 = By.xpath("(//*[@data-test='inventory-item-name'])[1]");
	
	By txt_inventory_item2 = By.xpath("(//*[@data-test='inventory-item-name'])[2]");
	
	By txt_price_total = By.xpath("//*[@data-test='total-label']");
	
	By btn_finish = By.xpath("//*[@id='finish']");
	
	By btn_home = By.xpath("//*[@id='back-to-products']");
	
	public CheckoutOverviewPage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void assertInventoryItem1(String text) {
		driver.findElement(txt_inventory_item1).equals(text);
	}
	
	public void assertInventoryItem2(String text) {
		driver.findElement(txt_inventory_item2).equals(text);
	}
	
	public void assertTotalPrice(String text) {
		driver.findElement(txt_price_total).equals(text);
	}
	
	public void clickFinish() {
		driver.findElement(btn_finish).click();
	}
	
	public void clickHome() {
		driver.findElement(btn_home).click();
	}
}
