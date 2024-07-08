package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	WebDriver driver = null;
	
	By txt_product =  By.xpath("//*[text()='Products']");
	
	By btn_cart = By.xpath("//*[@id='header_container']//*[@id='shopping_cart_container']");
	
	By btn_addToCartBackpack = By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']");
	
	By btn_addToCartBikeLight = By.xpath("//*[@id='add-to-cart-sauce-labs-bike-light']");
	
	By btn_addToCartBolttshirt = By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']");
	
	By btn_addToCartFleeceJacket = By.xpath("//*[@id='add-to-cart-sauce-labs-fleece-jacket']");
	
	By btn_addToCartOnesie = By.xpath("//*[@id='add-to-cart-sauce-labs-onesie']");
	
	By btn_addToCarttshirtred = By.xpath("//*[@id='add-to-cart-test.allthethings()-t-shirt-(red)']");
	
	By txt_backPack = By.xpath("//*[text()='Sauce Labs Backpack']");
	
	By txt_bikeLight = By.xpath("//*[text()='Sauce Labs Bike Light']");
	
	By txt_boltTshirt = By.xpath("//*[text()='Sauce Labs Bolt T-Shirt']");
	
	By txt_onesie = By.xpath("//*[text()='Sauce Labs Onesie']");
	
	By txt_fleeceJacket = By.xpath("//*[text()='Sauce Labs Fleece Jacket']");
	
	By txt_redTshirt = By.xpath("//*[text()='Test.allTheThings() T-Shirt (Red)']");
	
	By btn_removeBackpack = By.xpath("//*[@id='remove-sauce-labs-backpack']");
	
	By btn_removeBikeLight = By.xpath("//*[@id='remove-sauce-labs-bike-light']");
	
	By btn_removeBoltTshirt = By.xpath("//*[@id='remove-sauce-labs-bolt-t-shirt']");
	
	By btn_removeFleeceJacket = By.xpath("//*[@id='remove-sauce-labs-fleece-jacket']");
	
	By btn_removeOnesei = By.xpath("//*[@id='remove-sauce-labs-onesie']");
	
	By btn_removeRedTshirt = By.xpath("//*[@id='remove-test.allthethings()-t-shirt-(red)']");
	
	By btn_burgerMenu = By.xpath("//*[@id='react-burger-menu-btn']");
	
	By btn_Logout= By.xpath("//*[@id='logout_sidebar_link']");
	
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void txtProductisDisplayed() {
		driver.findElement(txt_product).isDisplayed();
	}
	
	public void btnCartisDisplayed() {
		driver.findElement(btn_cart).isDisplayed();
	}
	
	public void navigateToCart() {
		driver.findElement(btn_cart).click();
	}
	
	public void addToCartBackpack() {
		driver.findElement(btn_addToCartBackpack).click();
	}
	
	public void addToCartBikelight() {
		driver.findElement(btn_addToCartBikeLight).click();
	}
	
	public void addToCartBolttshirt() {
		driver.findElement(btn_addToCartBolttshirt).click();
	}
	
	public void addToCartFleecejacket() {
		driver.findElement(btn_addToCartFleeceJacket).click();
	}
	
	public void addToCartOnesie() {
		driver.findElement(btn_addToCartOnesie).click();
	}
	
	public void addToCartTshirtred() {
		driver.findElement(btn_addToCarttshirtred).click();
	}
	
	public void navigateToBackpack() {
		driver.findElement(txt_backPack).click();
	}
	
	public void navigateToBikelight() {
		driver.findElement(txt_bikeLight).click();
	}
	
	public void navigateToBolttshirt() {
		driver.findElement(txt_boltTshirt).click();
	}
	
	public void navigateToOnesie() {
		driver.findElement(txt_onesie).click();
	}
	
	public void navigateToFleecejacket() {
		driver.findElement(txt_fleeceJacket).click();
	}
	
	public void navigateToTshirtred() {
		driver.findElement(txt_redTshirt).click();
	}
	
	public void removeBackpackisDisplayed() {
		driver.findElement(btn_removeBackpack).isDisplayed();
	}
	
	public void removeBikelightisDisplayed() {
		driver.findElement(btn_removeBikeLight).isDisplayed();
	}
	
	public void removeBolttshirtisDisplayed() {
		driver.findElement(btn_removeBoltTshirt).isDisplayed();
	}
	
	public void removeFleecejacketisDisplayed() {
		driver.findElement(btn_removeFleeceJacket).isDisplayed();
	}
	
	public void removeOnesieisDisplayed() {
		driver.findElement(btn_removeOnesei).isDisplayed();
	}
	
	public void removeRedTshirtisDisplayed() {
		driver.findElement(btn_removeRedTshirt).isDisplayed();
	}
	
	public void removeBackpack() {
		driver.findElement(btn_removeBackpack).click();
	}
	
	public void removeBikelight() {
		driver.findElement(btn_removeBikeLight).click();
	}
	
	public void removeBolttshirt() {
		driver.findElement(btn_removeBoltTshirt).click();
	}
	
	public void removeFleecejacket() {
		driver.findElement(btn_removeFleeceJacket).click();
	}
	
	public void removeOnesie() {
		driver.findElement(btn_removeOnesei).click();
	}
	
	public void removeRedTshirt() {
		driver.findElement(btn_removeRedTshirt).click();
	}
	
	public void openBurgerMenu() {
		driver.findElement(btn_burgerMenu).click();
	}
	
	public void clickLogout() {
		driver.findElement(btn_Logout).click();
	}
	
}
