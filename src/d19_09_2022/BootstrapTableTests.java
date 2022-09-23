package d19_09_2022;

import java.io.File;
import java.nio.file.Files;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapTableTests {
	WebDriver driver;
	WebDriverWait wait;
	private String baseUrl = "https://s.bootsnipp.com";

	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	@BeforeMethod
	public void beforeMethod() {
		driver.get(baseUrl);
	}

	 @Test (priority = 10)
	public void EditRow() {
		String firstName = "Vladica";
		String lastName = "Stevanovic";
		String middleName = "Vlada";
		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"ERROR : Title is not valid");
		driver.findElement(By.xpath("//*[@id = 'd1']/td[5]/button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id = 'up']")));
		driver.findElement(By.xpath("//*[@id = 'fn']")).clear();

		driver.findElement(By.xpath("//*[@id = 'fn']")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id = 'ln']")).clear();
		driver.findElement(By.xpath("//*[@id = 'ln']")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id = 'mn']")).clear();
		driver.findElement(By.xpath("//*[@id = 'mn']")).sendKeys(middleName);
		driver.findElement(By.xpath("//*[@id = 'up']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id = 'up']")));
		Assert.assertEquals(driver.findElement(By.id("f1")).getText(), "Vladica", "ERROR: Invalid firstname");
		Assert.assertEquals(driver.findElement(By.id("l1")).getText(), "Stevanovic", "ERROR: Invalid lastname");
		Assert.assertEquals(driver.findElement(By.id("m1")).getText(), "Vlada", "ERROR: Invalid middlename");
	}

	 @Test (priority = 20)
	public void DeleteRow() {
		String firstName = "Vladica";
		String lastName = "Stevanovic";
		String middleName = "Vlada";
		List<WebElement> lista = driver.findElements(By.xpath("//*[@class = 'row']/table/tbody/tr"));
		driver.get(baseUrl + "/iframe/K5yrx");
		
		
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"ERROR: Title is not valid");
		
		driver.findElement(By.xpath("//*[@id = 'd1']/td[6]/button")).click();
		

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id = 'del']")));
		
		driver.findElement(By.xpath("//*[@id = 'del']")).click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id = 'del']")));

		Assert.assertTrue(lista.size() < 2, "ERROR: Delete is not finished properly");
	}

	@Test(priority = 30)
	public void TakeAScreenshot() throws Exception {
		driver.get(baseUrl + "/iframe/K5yrx");
		Assert.assertEquals(driver.getTitle(), "Table with Edit and Update Data - Bootsnipp.com",
				"ERROR: Title is not valid");
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		
	
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File("img/Screenshot.png");
			FileHandler.copy(SrcFile, DestFile);
		
	}


		

		@AfterClass
		public void after() {
		driver.quit();
	}
}
