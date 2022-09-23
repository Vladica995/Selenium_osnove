package d13_09_2022;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		Thread.sleep(2000);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name = 'username']")) .sendKeys("Admin");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@name = 'password']")) .sendKeys("admin123");
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class = 'oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")) .click();
//		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@placeholder = 'Search']")) .sendKeys("Me");
		driver.findElement(By.xpath("//*[@class = 'oxd-text oxd-text--span oxd-main-menu-item--name']")) .click();
//		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@class = 'oxd-userdropdown-tab']")) .click();
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@class = 'oxd-dropdown-menu']/li[last()]/a")) .click();
//		Thread.sleep(5000);
		driver.quit();
		
		
		
		
		

	}

}
