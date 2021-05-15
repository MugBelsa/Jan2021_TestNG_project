
package seesion4_Testing;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class Homework2 {

	static WebDriver driver;

	@Before
	public void lunchBrowser() {

		System.out.println("==========Launching my Browser");
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		// go to website driver.get("https://techfios.com/billing/?ng=admin/");

		// maximize the window and delete all Cookies
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void loginTest() throws InterruptedException {

		// Using WebElement Lib

		WebElement USER_NAME_ELEMENT = driver.findElement(By.xpath("//input[@name=\"username\"]"));

		WebElement PASSWORD_ELEMENT = driver.findElement(By.xpath("//input[@name=\"password\"]"));

		WebElement SUBMITT_BUTTON_ELEMENT = driver.findElement(By.xpath("//button[@name=\"login\"]"));

		// Element using BY class

		USER_NAME_ELEMENT.clear();
		USER_NAME_ELEMENT.sendKeys("demo@techfios.com");
		PASSWORD_ELEMENT.sendKeys("abc123");
		SUBMITT_BUTTON_ELEMENT.click();

		WebElement DASHBORD_TITLE_ELEMENT = driver.findElement(By.xpath("//span[contains(text(),'Dashboard')]"));
		DASHBORD_TITLE_ELEMENT.click();

		WebElement CUSTOMER_TITLE_ELEMENT = driver.findElement(By.xpath("//span[contains(text(),'Customers')]"));
		CUSTOMER_TITLE_ELEMENT.click();

		WebElement ADD_CUSTOMER_FIELD = driver.findElement(By.xpath("//a[contains(text(),'Add Customer')]"));
		ADD_CUSTOMER_FIELD.click();

		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement NAME_ELEMENT = driver.findElement(By.xpath("//input[@name=\"account\"]"));
		NAME_ELEMENT.sendKeys("CUSTOMER_ABCD");

		wait.until(ExpectedConditions.visibilityOfAllElements(NAME_ELEMENT));

		Assert.assertTrue("Customer element not found", NAME_ELEMENT.isDisplayed());

		WebElement companydropDown = driver.findElement(By.xpath("//select[@class=\"form-control\"]"));

		wait.until(ExpectedConditions.visibilityOfAllElements(companydropDown));
		Assert.assertTrue("Company drop not found", companydropDown.isDisplayed());

		Select sel = new Select(companydropDown);
		sel.selectByVisibleText("Google");

		WebElement EMAIL_ELEMENT = driver.findElement(By.xpath("//input[@id=\"email\"]"));
		EMAIL_ELEMENT.sendKeys("CostumerABCD@techfios.com");

		
		WebElement PHONE_ELEMENT = driver.findElement(By.xpath("//input[@name=\"phone\"]"));
		PHONE_ELEMENT.sendKeys("807-174-1075");

		WebElement ADRESS_ELEMENT = driver.findElement(By.xpath("//input[@name=\"address\"]"));
		ADRESS_ELEMENT.sendKeys("Dallas");

		WebElement CITY_ELEMENT = driver.findElement(By.xpath("//input[@name=\"city\"]"));
		CITY_ELEMENT.sendKeys("Bedford");

		WebElement STATE_ELEMENT = driver.findElement(By.xpath("//input[@name=\"state\"]"));
		STATE_ELEMENT.sendKeys("Texas");

		WebElement ZIP_POSTAL_ELEMENT = driver.findElement(By.xpath("//input[@name=\"zip\"]"));
		ZIP_POSTAL_ELEMENT.sendKeys("72145");

		WebElement PASSWORD_EMAIL_ELEMENT = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		PASSWORD_EMAIL_ELEMENT.sendKeys("123456");

		WebElement CONFIRM_PASSWORD_EMAIL_ELEMENT = driver.findElement(By.xpath("//input[@name=\"cpassword\"]"));
		CONFIRM_PASSWORD_EMAIL_ELEMENT.sendKeys("123456");

		WebElement CONFIRM_YES_ELEMENT = driver.findElement(By.xpath("//label[contains(text(),'Yes')]"));
		CONFIRM_YES_ELEMENT.click();

		WebElement SAVE_ELEMENT = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
		SAVE_ELEMENT.click();

		boolean account_created;
		try {
			wait.until(ExpectedConditions
					.visibilityOf(driver.findElement(By.xpath("//h2[contains(text(),' Contacts ')]"))));
			account_created = true;
		} catch (Exception e) {
			account_created = false;

		}

		

		WebElement LIST_CUSTOMER_FIELD = driver.findElement(By.xpath("//a[contains(text(),'List Customers')]"));
		LIST_CUSTOMER_FIELD.click();

		WebElement SEARCH_KEY_FIELD = driver.findElement(By.xpath("//input[@placeholder=\"Search...\"]"));
		SEARCH_KEY_FIELD.sendKeys("CUSTOMER_ABCD");

		WebElement VERIFICATION_NAME = driver.findElement(By.xpath("//a[contains(text(),'CUSTOMER_ABC')]"));

		Assert.assertTrue("CUSTOMER_AB is inserted", VERIFICATION_NAME.isDisplayed());

		Thread.sleep(2000);

	}

	@After
	public void TearDown() {

		System.out.println("Welcome Belyse!!");
		driver.close();
		driver.quit();

	}

}
