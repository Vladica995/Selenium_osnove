package d20_09_2022_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BuyBoxPage {
	WebDriver driver;
	
	
	public BuyBoxPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getInputQuantity() {
		return driver.findElement(By.xpath("//*[@name = 'qty']"));
		
	}
	public WebElement getSelectForSize(String value) {
		
		Select s = new Select(driver.findElement(By.xpath("//*[@id = 'group_1']")));
		
		s.getOptions();
		s.selectByValue(value);
		return driver.findElement(By.xpath("//*[@id = 'group_1']"));
		
		
		
	}
	public WebElement getAddToCartButton() {
		return driver.findElement(By.xpath("//*[@name = 'Submit']"));
	}
	public WebElement getAddToWishlistButton() {
	return driver.findElement(By.xpath("//*[@id ='wishlist_button']"));
	
	}
	public WebElement getColorElement(String color) {
		driver.findElements(By.xpath("//*[@id = 'color_to_pick_list']/li"));
		if(color.equals("Orange")) {
			return driver.findElement(By.xpath("//*[@id = 'color_to_pick_list']/li[1]/a"));
		} else {
			return driver.findElement(By.xpath("//*[@id = 'color_to_pick_list']/li[2]/a"));
		}

		
}
	
	public void getScrollToByBoxPage() {
		//driver.findElement(By.xpath("//*[@class = 'box-info-product']"));
		new Actions(driver)
        .scrollToElement(driver.findElement(By.xpath("//*[@class = 'box-info-product']")))
         .perform();
	}
}