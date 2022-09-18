package d15_09_2022;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://s.bootsnipp.com/iframe/Dq2X");
		List <WebElement> lista = driver.findElements(By.xpath("//*[@class = 'col-md-12']/div"));
		

		for (int i =0; i < lista.size();  i++) {
			driver.findElement(By.xpath("//*[@class ='col-md-12']/div[last()]/button ")) .click() ;
			
			
			
			try{
				driver.findElement(By.xpath("//*[@class ='col-md-12']/div[last() + 1]"));
				System.out.println("Element pronadjen, brisanje bezuspesno!");
				
			} catch (Exception e) {
				System.out.println("Element nije pronadjen, brisanje uspesno!");
			}
			
		
			} 
		driver.quit();
		
			
			
			
			
		
			
		}
	}


