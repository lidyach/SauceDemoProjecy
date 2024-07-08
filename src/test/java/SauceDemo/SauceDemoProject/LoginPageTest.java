package SauceDemo.SauceDemoProject;

import java.io.IOException;

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

import Pages.HomePage;
import Pages.LoginPage;

public class LoginPageTest {
	
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
		
	}
	
	@Test
	public void loginFailed() throws Exception {
		
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.addScreenCaptureFromPath("screenshot.png");
		
		LoginPage loginPage = new LoginPage(driver);		
		
		//Login using id: locked_out_user and password: secret_sauce
		//Verify error message : Sorry, this user has been locked out.
		loginPage.setUsername("locked_out_user");
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
		loginPage.error_isDisplayed();
		loginPage.equals("Epic sadface: Sorry, this user has been locked out.");
		
		
	}
	
	@Test
	public void loginSuccess() throws Exception {
		
		ExtentTest test = extent.createTest("MySecondTest", "Sample description");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
	    test.info("This step shows usage of info(details)");
	    test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
	    test.addScreenCaptureFromPath("screenshot.png");
		
		LoginPage loginPage = new LoginPage(driver);
		
		////Login using id: standard_user and password: secret_sauce
		loginPage.clearUsername();
		loginPage.setUsername("standard_user");
		loginPage.clearPassword();
		loginPage.setPassword("secret_sauce");
		loginPage.clickLogin();
		
	}
	
	@AfterTest
	public void teadDownTest() {
		
		extent.flush();
		
		HomePage homePage = new HomePage(driver);
		
		homePage.txtProductisDisplayed();
		homePage.btnCartisDisplayed();
		
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}

}
