package xpaths;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DepositTest {

	WebDriver driver;

	@Before
	public void init() {

		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.techfios.com/billing/?ng=admin/");
	};

	@Test
	public void login() throws InterruptedException {
		By USER_NAME_FIELD = By.xpath("//input[@id='username']");
		By PASSWORD_FIELD = By.xpath("//input[@id='password']");
		By LOGIN_FIELD = By.xpath("//button[@name='login']");

		driver.findElement(USER_NAME_FIELD).sendKeys("demo@techfios.com");
		driver.findElement(PASSWORD_FIELD).sendKeys("abc123");
		driver.findElement(LOGIN_FIELD).click();

		Thread.sleep(4000);

		By TRANSACTIONS_BUTTON_FIELD = By.xpath("//ul[@id='side-menu']/li[5]/a");
		driver.findElement(TRANSACTIONS_BUTTON_FIELD).click();

		By NEW_DEPOSIT_BUTTON_FIELD = By.xpath("//ul[@id='side-menu']/li[5]/descendant::li[1]/a");
		driver.findElement(NEW_DEPOSIT_BUTTON_FIELD).click();
		Thread.sleep(2000);

		By CHOOSE_ACCOUNT_DROP_DOWN_BUTTON_FIELD = By.xpath("//span[@id='select2-account-container']");
		driver.findElement(CHOOSE_ACCOUNT_DROP_DOWN_BUTTON_FIELD).click();
		Thread.sleep(3000);

		By CHECKING_ACCOUNT_FIELD = By.xpath("//ul[@id='select2-account-results']/descendant::li[13]");
		driver.findElement(CHECKING_ACCOUNT_FIELD).click();

		By DESCRIPTION_FIELD = By.xpath("//input[@id='description']");
		driver.findElement(DESCRIPTION_FIELD).sendKeys("Yes, I can think of many ways to do that.");

		By DEPOSIT_AMOUNT_FIELD = By.xpath("//input[@id='amount']");
		driver.findElement(DEPOSIT_AMOUNT_FIELD).sendKeys("99000");

		By SUBMIY_BUTTON_FIELD = By.xpath("//form[@id='tform']/div[7]/div[1]/child::button");
		driver.findElement(SUBMIY_BUTTON_FIELD).submit();
	}

	// @After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
