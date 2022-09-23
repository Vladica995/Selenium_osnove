package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderPage {
    WebDriver driver;
    WebDriverWait wait;
    
   public HeaderPage(WebDriver driver, WebDriverWait wait) {
    	this.driver = driver;
    	this.wait = wait;
    }
    
    
    public WebElement getShopPhoneElement() {
    	return driver.findElement(By.xpath("//*[@class = 'shop-phone']"));
    	
    }
    public WebElement getContactUsLink() {
    	return driver.findElement(By.xpath("//*[@id = 'contact-link']/a"));
    	
    }
    public WebElement getSignInLink() {
    	return driver.findElement(By.xpath("//*[@class ='login']"));
    }
    public void getResolutionChange() {
		//driver.findElement(By.xpath("//*[@class = 'box-info-product']"));
		new Actions(driver)
		.keyDown(Keys.CONTROL)
        .sendKeys("+")
        .perform();
	}
}
