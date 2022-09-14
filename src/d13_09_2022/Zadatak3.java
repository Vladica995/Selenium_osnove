package d13_09_2022;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");

		for (int i = 1; i <= 5; i++) {

			driver.findElement(By.xpath("//*[@class = 'btn btn-info add-new']")).click();
			driver.findElement(By.xpath("//*[@name = 'name']")).sendKeys("Vladica");
			driver.findElement(By.xpath("//*[@name = 'department']")).sendKeys("Direktor");
			driver.findElement(By.xpath("//*[@name = 'phone']")).sendKeys("060222333");
			driver.findElement(By.xpath("//*[@class = 'table table-bordered']/tbody/tr[last()]/td[last()]/a")).click();
			Thread.sleep(500);

		}
		driver.quit();

	}

}
