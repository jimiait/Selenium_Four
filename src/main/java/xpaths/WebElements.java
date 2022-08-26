package xpaths;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebElements {

	WebDriver driver;

	@Before
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test
	public void webElement() {

		// Storing web element
		// type name = value;
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.name("username"))));

		// WebElement type Element list
		// driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");

		WebElement userNameElement = driver.findElement(By.xpath("//input[@id='username']"));
		WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement loginButtonElement = driver.findElement(By.xpath("/html/body/div/div/div/form/div[3]/button"));

//		userNameElement.clear(); //To clear
//		userNameElement.sendKeys("demo@techfios.com");
//		passwordElement.sendKeys("abc123");
//		loginButtonElement.click();

		// By type Element List
		// driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demo@techfios.com");
		
		By USER_NAME_FIELD = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD = By.xpath("//*[@id=\"password\"]");
		By LOGIN_BUTTON_FIELD = By.xpath("/html/body/div/div/div/form/div[3]/button");
		By DASHBOARD_HEADER_FIELD = By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div/h2");
		
		String userName = "demo@techfios.com";
		driver.findElement(USER_NAME_FIELD).sendKeys(userName);
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_BUTTON_FIELD).click();
		
		
		//input[@id='username']

	}
	
//	public void tearDown() {
//	driver.close();
//	driver.quit();
//	}

}
