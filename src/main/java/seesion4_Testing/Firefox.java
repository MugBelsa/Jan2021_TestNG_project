package seesion4_Testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Firefox {

	WebDriver driver;
	String browser = "chrome";

	@BeforeMethod
	public void lunchBrowser() {

		System.out.println("==========Launching my Browser");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		// go to website
		driver.get("https://www.ebay.com/");

		// maximize the window and delete all Cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
    @Test
	public void Register() {

		WebElement REGISTER_FIELD = driver.findElement(By.xpath("//a[contains(text(),'register')]"));
		REGISTER_FIELD.click();
		/*
		 * WebElement CREATE_ACCAOUNT =
		 * driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[3]/h1"));
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, 10);
		 * wait.until(ExpectedConditions.visibilityOfAllElements(REGISTER_FIELD));
		 * 
		 * Assert.assertTrue(REGISTER_FIELD.isDisplayed()); REGISTER_FIELD.click();
		 */
	}

	
	//@AfterMethod
	public void TearDown() {

		driver.quit();
	}

}
