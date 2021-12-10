package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {
	public  final String USERNAME = "yogitagbelavanak_Q93Vc7";
	public  final String AUTOMATE_KEY = "pWnzzbTY8e1DDX8zznpf";
	public  final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	 WebDriver driver;

	@Given("browser is open")
	public void browser_is_open() throws Throwable {
	String browserVar=System.getProperty("browser");
		if(browserVar.equalsIgnoreCase("chrome")) {
	   WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
		}
		else if(browserVar.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	/*	DesiredCapabilities capsHashtable=new DesiredCapabilities();
		capsHashtable.setCapability("browser", "safari");
		capsHashtable.setCapability("browser_version", "13.1");
		capsHashtable.setCapability("os", "OS X");
		capsHashtable.setCapability("os_version", "Catalina");
    	capsHashtable.setCapability("build", "browserstack-build-1");
		capsHashtable.setCapability("name", "Login Test");
		
		 driver=new RemoteWebDriver(new URL(URL), capsHashtable);*/
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("user enters url")
	public void user_enters_url() {
		
	  driver.get("http://demowebshop.tricentis.com/login");
	}

	@When("user enters valid username and password")
	public void user_enters_valid_username_and_password() {
	 driver.findElement(By.id("Email")).sendKeys("angel@furrbaby.com");
	 driver.findElement(By.id("Password")).sendKeys("Bones");
	 driver.findElement(By.xpath("//insetCapability[@value='Log in']")).click();
	 
	}

	@Then("user is logged in")
	public void user_is_logged_in() {
	   Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed(), "User is logged in");
	   driver.close();
	}

	
}
