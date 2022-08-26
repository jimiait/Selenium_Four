package xpaths;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dynamic {

	WebDriver driver;

	@Before
	public void init() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.cnn.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void dynamic() {
//cnn  //article[@class='cd cd--card cd--article cd--idx-0 cd--large cd--vertical cd--has-siblings cd--has-media cd--media__animation cd--has-banner']/descendant::strong

		driver.findElement(By.xpath("//section[@id='homepage1-zone-1']/descendant::h3[1]")).click();
		//driver.findElement(By.xpath("")).click();

	}

	//@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}
