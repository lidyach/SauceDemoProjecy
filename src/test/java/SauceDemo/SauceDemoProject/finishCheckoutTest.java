package SauceDemo.SauceDemoProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.CheckoutOverviewPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductDetailPage;

public class finishCheckoutTest {
	
	private static WebDriver driver = null;
	
	ExtentHtmlReporter htmlReporter;
	
	ExtentReports extent;
	
	@BeforeTest
	public void setUptest() {
		
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webriver.chrome.driver", projectPath+"/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		LoginPage loginPage = new LoginPage(driver);
		
		HomePage homePage = new HomePage(driver);
		
		//Login using id: standard_user and password: secret_sauce
		loginPage.clearUsername();
		loginPage.setUsername("standard_user");
		loginPage.clearPassword();
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
		
		homePage.txtProductisDisplayed();
		homePage.btnCartisDisplayed();
	}
	
	@Test
	public void finishCheckout() throws Exception {
		
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.addScreenCaptureFromPath("screenshot.png");
	    
		CheckoutOverviewPage checkoutOverview = new CheckoutOverviewPage(driver);
		
		HomePage homePage = new HomePage(driver);
		
		LoginPage loginPage = new LoginPage(driver);
		
		ProductDetailPage pdPage = new ProductDetailPage(driver);

		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		//"Add to cart" from home page "sauce labs backpack"
		homePage.addToCartBackpack();	
		
		//Open product page for "sauce labs bike light"
		homePage.navigateToBikelight();
		//Click on "Add to cart"
		pdPage.addtoCart();
		
		//Click on shopping cart icon
		homePage.navigateToCart();
		
		//Click on "Checkout" button
		checkoutPage.checkoutCart();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Enter First Name: "dummy", Last Name: "", Zip Code: "28654"
		checkoutPage.setFirstName("dummy");
		checkoutPage.setPostalCode("28654");
				
		//Verify error message is displayed: "Error: Last Name is required"
		checkoutPage.checkoutContinue();
		checkoutPage.errorMessageisDisplayed();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Enter Last Name: "user"
		checkoutPage.setLastName("user");
				
		//Click on Continue
		checkoutPage.checkoutContinue();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
	
		//Verify products: "sauce labs backpack" and "sauce labs bike light" are displayed in checkout overview 
		checkoutOverview.assertInventoryItem1("Sauce Labs Backpack");
		checkoutOverview.assertInventoryItem2("Sauce Labs Bike Light");
		
		//Verify Price total = $43.18
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		
		checkoutOverview.assertTotalPrice("Total: $43.18");
	
		//Click on Finish 
		//Click on Back to Home
		jse.executeScript("window.scrollBy(0,250)");
		checkoutOverview.clickFinish();
		checkoutOverview.clickHome();
		
		//Verify user is on Home screen
		homePage.txtProductisDisplayed();
		homePage.btnCartisDisplayed();
		
		//Click on hamburger menu and click on "Logout"
		homePage.openBurgerMenu();
		homePage.clickLogout();
		
		//Verify user is on login screen
		loginPage.assertInputUsername();
		loginPage.assertInputPassword();
	}
	
	@AfterTest
	public void tearDown() {
		
		extent.flush();
		
		driver.close();
		
		System.out.println("Test Completed Successfully");
		
		
	}

}
