package d16_09_2022;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Zadatak1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		File slikaF = new File("img/front_vladica_stevanovic.png");
		String s1 = slikaF.getAbsolutePath();
		System.out.println(s1);
		File slikaL = new File("img/left_vladica_stevanovic.png");
		File slikaR = new File("img/right_vladica_stevanovic.png");
		File slikaB = new File("img/back_vladica_stevanovic.png");
		ArrayList<String> slike = new ArrayList<String>();
		slike.add(slikaF.getAbsolutePath());
		slike.add(slikaL.getAbsolutePath());
		slike.add(slikaR.getAbsolutePath());
		slike.add(slikaB.getAbsolutePath());

		driver.get("https://boomf.com/apps/proxy/boomf-bomb/i-bloody-love-you");
		List<WebElement> lista = (driver.findElements(By.xpath("//*[@class = 'sc-ivTmOn iltlXU']/div")));
	
		driver.manage().window().maximize();

//		driver.findElement(By.xpath("//*[@class = 'sc-iIPllB kJempR']")) .click();
//		driver.findElement(By.xpath("//*[@class = 'sc-cCsOjp ddfNnQ']")) .click();
//		driver.findElement(By.id("imageUpload")) .sendKeys(slikaF.getAbsolutePath());
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'sc-breuTD gmXCBU']/img[last()]")));
//		driver.findElement(By.xpath("//*[@class = 'sc-breuTD gmXCBU']/img[last()]")) .click();
//		driver.findElement(By.xpath("//*[@class ='sc-gYMRRK gMENHs']/div[3]/button")) .click();
//		driver.findElement(By.xpath("//*[@class='sc-eKBdFk iCACbi']/button")) .click();
//		
//		driver.findElement(By.xpath("//*//*[@class='sc-ivTmOn iltlXU']/div[2]/div")) .click();
//		driver.findElement(By.xpath("//*[@class='sc-cCsOjp dcdHHD']/div")) .click();
//		driver.findElement(By.id("imageUpload")) .sendKeys(slikaL.getAbsolutePath());
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'sc-breuTD gmXCBU']/img[last()]")));
////		driver.findElement(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div/div")).click();
////		driver.findElement(By.xpath("//*[@class = 'sc-fbPSWO bbpaUa']/button")) .click();
//		driver.findElement(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div/div")) .click();
//		driver.findElement(By.xpath("//*[@class = 'sc-ktCSKO ckRsqX']/div/div[3]/button")) .click();
		
		
		
		driver.findElement(By.xpath("//*[@class = 'sc-iIPllB kJempR']")) .click();
		driver.findElement(By.xpath("//*[@class = 'sc-cCsOjp ddfNnQ']")) .click();
		driver.findElement(By.id("imageUpload")) .sendKeys(slikaF.getAbsolutePath());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class = 'sc-breuTD gmXCBU']/img[last()]")));
		driver.findElement(By.xpath("//*[@class = 'sc-breuTD gmXCBU']/img[last()]")) .click();
		driver.findElement(By.xpath("//*[@class ='sc-gYMRRK gMENHs']/div[3]/button")) .click();
		driver.findElement(By.xpath("//*[@class = 'sc-gYMRRK gMENHs cropper-modal']/div/div[2]/button")) .click();
		for (int i = 1; i <= lista.size(); i++) {
			lista.get(i).click();
			driver.findElement(By.xpath("//*[@class = 'sc-iAvgwm dFRxWA']")).click();
			driver.findElement(By.id("imageUpload")).sendKeys(slike.get(i));
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last()]/div/img")));
				driver.findElement(By.xpath("//*[@class = 'sc-ftvSup fqhTDx']/div[last()]/div")) .click();
				driver.findElement(By.xpath("//*[@class ='sc-gYMRRK gMENHs']/div[3]/button")) .click();
				driver.findElement(By.xpath("//*[@class = 'sc-gYMRRK gMENHs cropper-modal']/div/div[2]/button")).click();
//				
			
			
			

		 driver.findElement(By.xpath("//*[@name = '3']")) .click();
		driver.findElement(By.xpath("//*[@class = 'sc-bczRLJ gNSlAh']")) .click();
		WebElement error = driver.findElement(By.xpath("//*[@action='error']"));
		
		if(error .isDisplayed()) {
			System.out.println("Greska");
			
		} else {
			System.out.println("Uspesno je dodato.");
		} driver.quit();

	}
}
}
