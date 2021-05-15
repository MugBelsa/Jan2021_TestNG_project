
package seesion4_Testing;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Exercise_TestNG {

	WebDriver driver;

	@BeforeMethod
	public void launchBrowser() {

		System.out.println("=========Launch Browser");

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();

		// go to website

		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test
	public void loginTest() throws InterruptedException {

		// Element Lib

		By USER_NAME_ELEMENT = By.xpath("//input[@name=\"username\"]");
		By PASSWORD_ELEMENT = By.xpath("//input[@name=\"password\"]");
		By SUBMIT_BUTTON_ELEMENT = By.xpath("//button[@type=\"submit\"]");
		By DASHBORD_TITLE_ELEMENT = By.xpath("//span[contains(text(),'Dashboard')]");
		By CUSTOMERS_TITLE_ELEMENT = By.xpath("//span[contains(text(),'Customers')]");
		By ADD_CUSTOMER_FIELD = By.xpath("//*[@id=\"side-menu\"]/li[3]/a/span[1]");
		 
		/* * By FULL_NAME_FIELD = By.xpath("//input[@name=\"account\"]"); By
		 * COMPANY_DROPDOWN = By.xpath("//select[@class=\"form-control\"]"); By
		 * EMAIL_ELEMENT = By.xpath("//input[@id=\"email\"]"); By PHONE_ELEMENT =
		 * By.xpath("//*[@id=\"phone\"]"); By ADRESS_ELEMENT =
		 * By.xpath("//input[@name=\"address\"]"); By CITY_ELEMENT =
		 * By.xpath("//input[@name=\"city\"]"); By STATE_ELEMENT =
		 * By.xpath("//input[@name=\"state\"]"); By ZIP_POSTAL_ELEMENT =
		 * By.xpath("//input[@name=\"zip\"]"); By COUNTRY_FIELD =
		 * By.xpath("//*[@id=\"select2-country-container\"]");
		 * 
		 * By PASSWORD_EMAIL_ELEMENT = By.xpath("//input[@name=\"password\"]"); By
		 * CONFIRM_PASSWORD_EMAIL_ELEMENT = By.xpath("//input[@name=\"cpassword\"]"); By
		 * CONFIRM_YES_ELEMENT = By.xpath("//label[contains(text(),'Yes')]"); By
		 * SAVE_ELEMENT = By.xpath("//button[@id=\"submit\"]"); By LIST_CUSTOMER_FIELD =
		 * By.xpath("//a[contains(text(),'List Customers')]");
		 */

		// login data
		String loginID = "demo@techfios.com";
		String password = "abc123";

		/*
		 * // Test Data String fullName = "Test January"; String companyName =
		 * "Techfios"; //String email = "mugitech@gmail.com";
		 */
		// log In
	
		driver.findElement(USER_NAME_ELEMENT).sendKeys(loginID);
		driver.findElement(PASSWORD_ELEMENT).sendKeys(password);
		driver.findElement(SUBMIT_BUTTON_ELEMENT).click();


		// Add customer

		driver.findElement(CUSTOMERS_TITLE_ELEMENT).click();
	
	// Explicit wait
		waitForElement(driver, 5, ADD_CUSTOMER_FIELD);
		driver.findElement(ADD_CUSTOMER_FIELD).click();

		/*waitForElement(driver, 3, FULL_NAME_FIELD);
		driver.findElement(FULL_NAME_FIELD).sendKeys(fullName);
*/
		/*// generate random no
		Random rnd = new Random();
		int generateNum = rnd.nextInt(999);

		driver.findElement(FULL_NAME_FIELD).sendKeys(fullName + generateNum);

		String phoneNumber = "2564919434";
		String adress = "Dallas";
		String city = "Bedford";
		String state = "Texas";
		String country = "United State";

		driver.findElement(PHONE_ELEMENT).sendKeys(phoneNumber);
		driver.findElement(ADRESS_ELEMENT).sendKeys(adress);*/

		// dropdown
/*
		Select sel = new Select(driver.findElement(COMPANY_DROPDOWN));
		sel.selectByVisibleText(companyName);

		Select sel1 = new Select(driver.findElement(COUNTRY_FIELD));
		sel1.selectByVisibleText(country);*/

	}

	public void waitForElement(WebDriver driver, int timeInSeconds, By Locator) {

		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Locator));

	}

}
