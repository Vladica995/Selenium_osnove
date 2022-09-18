package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		File slikaF = new File("img/front_vladica_stevanovic.png");
		File slikaL = new File("img/left_vladica_stevanovic.png");
		File slikaR = new File("img/right_vladica_stevanovic.png");
		File slikaB = new File("img/back_vladica_stevanovic.png");

		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//*[@class = 'sc-iIPllB kJempR']")).click();
		driver.findElement(By.xpath("//*[@class = 'sc-cCsOjp ddfNnQ']")).click();
		driver.findElement(By.id("imageUpload")).sendKeys(slikaF.getAbsolutePath());
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'sc-breuTD gmXCBU']/img[last()]")));
		driver.findElement(By.xpath("//*[@class = 'sc-breuTD gmXCBU']/img[last()]")).click();
		driver.findElement(By.xpath("//*[@class ='sc-gYMRRK gMENHs']/div[3]/button")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@class = 'reactEasyCrop_CropArea reactEasyCrop_CropAreaGrid crop-area']")));
		driver.findElement(By.xpath("//*[@class = 'sc-gYMRRK gMENHs cropper-modal']/div/div[2]/button")).click();

		driver.findElement(By.xpath("//*[@class = 'sc-ivTmOn iltlXU']/div[2]")).click();
		driver.findElement(By.xpath("//*[@class = 'sc-iAvgwm dFRxWA']")).click();
		driver.findElement(By.id("imageUpload")).sendKeys(slikaL.getAbsolutePath());
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last() -1]/div/img")));
		driver.findElement(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last()-1]/div/img")).click();
		driver.findElement(By.xpath("//*[contains(text() , 'Use One Side Only')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@class = 'reactEasyCrop_CropArea reactEasyCrop_CropAreaGrid crop-area']")));
		driver.findElement(By.xpath("//*[contains(text(), 'Done')]")).click();

		driver.findElement(By.xpath("//*[@class = 'sc-ivTmOn iltlXU']/div[3]")).click();
		driver.findElement(By.xpath("//*[@class = 'sc-iAvgwm dFRxWA']")).click();
		driver.findElement(By.id("imageUpload")).sendKeys(slikaB.getAbsolutePath());
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last() -2]/div/img")));
		driver.findElement(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last() -2]/div/img")).click();
		driver.findElement(By.xpath("//*[contains(text() , 'Use One Side Only')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@class = 'reactEasyCrop_CropArea reactEasyCrop_CropAreaGrid crop-area']")));
		driver.findElement(By.xpath("//*[contains(text(), 'Done')]")).click();

		driver.findElement(By.xpath("//*[@class = 'sc-ivTmOn iltlXU']/div[4]")).click();
		driver.findElement(By.xpath("//*[@class = 'sc-iAvgwm dFRxWA']")).click();
		driver.findElement(By.id("imageUpload")).sendKeys(slikaR.getAbsolutePath());
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last() -3]/div/img")));
		driver.findElement(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last() -3]/div/img")).click();
		driver.findElement(By.xpath("//*[contains(text() , 'Use One Side Only')]")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//*[@class = 'reactEasyCrop_CropArea reactEasyCrop_CropAreaGrid crop-area']")));
		driver.findElement(By.xpath("//*[contains(text(), 'Done')]")).click();

		List<WebElement> konfete = driver.findElements(By.xpath("//*[@class = 'sc-hZgfyJ kFlYLE']/div"));
		Random r = new Random();
		int a = r.nextInt(konfete.size());
		konfete.get(a).click();

		driver.findElement(By.xpath("//*[contains(text() , 'Add to cart')]")).click();

		WebElement poruka = driver.findElement(By.xpath("//*[@action='error']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@action='error']")));
		System.out.println("Poruka je prikazana.");

		Thread.sleep(5000);
		driver.quit();

	}

}
