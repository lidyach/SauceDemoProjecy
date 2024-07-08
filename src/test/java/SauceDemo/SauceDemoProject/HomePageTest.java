package SauceDemo.SauceDemoProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;

public class HomePageTest {
	
	private static WebDriver driver = null;
	
	@BeforeTest
	public void setUptest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		LoginPage loginPage = new LoginPage(driver);
		
		HomePage homePage = new HomePage(driver);
		
		loginPage.clearUsername();
		loginPage.setUsername("standard_user");
		loginPage.clearPassword();
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
		
		homePage.txtProductisDisplayed();
		homePage.btnCartisDisplayed();
	}
	
	@Test
	public void addtoCart() {
		
		HomePage homePage = new HomePage(driver);
		
		homePage.addToCartBackpack();
	}
	
	@Test
	public void addtoCartfromPDP() {
		
		HomePage homePage = new HomePage(driver);
		
		ProductDetailPage pdPage = new ProductDetailPage(driver);
		
		homePage.navigateToBikelight();
		pdPage.addtoCart();
		homePage.navigateToCart();
		
		
	}
	
	@AfterTest
	public void teadDownTest() {
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}

}
