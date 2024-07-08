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

public class CheckoutProductTest {
	
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
	public void addtoCart() throws Exception {
		
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.addScreenCaptureFromPath("screenshot.png");

		HomePage homePage = new HomePage(driver);
		
		//"Add to cart" from home page "sauce labs backpack"
		homePage.addToCartBackpack();
	}
	
	@Test
	public void addtoCartfromPDP() throws Exception {
		
		ExtentTest test = extent.createTest("MySecondTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.addScreenCaptureFromPath("screenshot.png");
		
		HomePage homePage = new HomePage(driver);
		
		ProductDetailPage pdPage = new ProductDetailPage(driver);
		
		//Open product page for "sauce labs bike light"
		homePage.navigateToBikelight();
		//Click on "Add to cart"
		pdPage.addtoCart();
		
		
		//Click on shopping cart icon
		homePage.navigateToCart();
	
	}
	
	@Test
	public void checkoutCart() throws Exception {
		
		ExtentTest test = extent.createTest("MyThirdTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.addScreenCaptureFromPath("screenshot.png");
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
		//Click on "Checkout" button
		checkoutPage.checkoutCart();
	}
	
	@Test
	public void continueCheckout() throws Exception{
		
		ExtentTest test = extent.createTest("MyFourthTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.addScreenCaptureFromPath("screenshot.png");
		
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		
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
		
		
	}
	
	@AfterTest
	public void tearDown() {
		
		extent.flush();
		
		driver.close();
		
		System.out.println("Test Completed Successfully");
		
		
	}
	
	

}
