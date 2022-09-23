package d20_09_2022_tests;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import d20_09_2022_pages.BuyBoxPage;
import d20_09_2022_pages.HeaderPage;
import d20_09_2022_pages.LayerCartPage;
import d20_09_2022_pages.TopMenuPage;
import p20_09_2022_pages.CartPage;
import p20_09_2022_pages.NavPage;
import p20_09_2022_pages.ProductPage;

public class AutomationPracticeTests {
	private WebDriver driver;
	private BuyBoxPage buyBoxPage;
	private HeaderPage headerPage;
	private LayerCartPage layerCartPage;
	private TopMenuPage topMenuPage;
	private String baseUrl = "http://automationpractice.com/";
	private WebDriverWait wait;
	private SoftAssert softAsert;
	
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		softAsert = new SoftAssert();
		buyBoxPage = new BuyBoxPage(driver);
		headerPage = new HeaderPage(driver , wait);
		layerCartPage = new LayerCartPage(driver , wait);
		topMenuPage = new TopMenuPage(driver ,wait);
		
	}
	@BeforeMethod
	public void before() {
		driver.get(baseUrl);
	}
	@Test (priority = 10)
	public void AddingProductToTheCart() {
		driver.get(baseUrl + "/index.php?id_product=1&controller=product");
		buyBoxPage.getScrollToByBoxPage();
		buyBoxPage.getInputQuantity().clear();
		buyBoxPage.getInputQuantity() .sendKeys("3");
		buyBoxPage.getSelectForSize("3");
		buyBoxPage.getColorElement("Blue").click();
		buyBoxPage.getAddToCartButton().click();
		layerCartPage.waitForDialogToBeVisible();
		Assert.assertEquals(layerCartPage.getQuantityShop().getText(), "3" , "ERROR: Invalid number of quantity!");
		boolean l = layerCartPage.getAttributeProduct().getText().contains("L");
		Assert.assertTrue(l , "ERROR: Invalid size");
		boolean blue = layerCartPage.getAttributeProduct().getText().contains("Blue");
		Assert.assertTrue(blue , "ERROR: Invalid color");
		Assert.assertEquals(layerCartPage.getTotalPrice().getText() , "$" +3 * 16.51 , "ERROR: Invalid total price!");
		layerCartPage.getContinueShopingButton().click();
		layerCartPage.waitForDialogToBeInvisible();
		buyBoxPage.getScrollToByBoxPage();
		buyBoxPage.getInputQuantity().clear();
		buyBoxPage.getInputQuantity() .sendKeys("1");
		buyBoxPage.getSelectForSize("1");
		buyBoxPage.getColorElement("Orange").click();
		buyBoxPage.getAddToCartButton().click();
		
		
		layerCartPage.waitForDialogToBeVisible();
		layerCartPage.getProceedToCheckoutButton().click();
		Assert.assertEquals(driver.getTitle() ,"Order - My Store",  "ERROR : Invalid title.");
	}
		@Test (priority = 20)
	public void  topMenuMouseOver() throws InterruptedException {

			topMenuPage.getScroolToWomenElement();
			softAsert.assertTrue(topMenuPage.getWomenSubMenu().isDisplayed() , "ERROR Women SubMenu is invisible");
			topMenuPage.getScroolToDressesElement();
			softAsert.assertTrue(topMenuPage.getDressesSubMenu().isDisplayed() , "ERROR Dresses Submenu is invisible");
			topMenuPage.getScroolToTShirtElement();
			Thread.sleep(3000);
			
			softAsert.assertFalse(topMenuPage.getWomenSubMenu().isDisplayed(), "ERROR In t SHIRT Women Submenu must be invisible");
			softAsert.assertFalse(topMenuPage.getDressesSubMenu().isDisplayed(), "ERROR In t SHIRT Women Submenu must be invisible");

			
			softAsert.assertAll();
			
			
		
	}
		@Test (priority = 30)
		public void phoneNumberVisibilityCheckOnResize() throws InterruptedException {
		
		headerPage.getShopPhoneElement();
		
		softAsert.assertTrue(headerPage.getShopPhoneElement().isDisplayed() , "Invalid visibility of phone number. ");
		Dimension dim = new Dimension(767,700);
				driver.manage().window().setSize(dim);
				softAsert.assertFalse(headerPage.getShopPhoneElement().isDisplayed() , "ERROR: Phone must be invisible in this resolution");
				Dimension dim1 = new Dimension(788,700);
				Thread.sleep(2000);
				driver.manage().window().setSize(dim1);
				Thread.sleep(2000);
				softAsert.assertTrue(headerPage.getShopPhoneElement().isDisplayed() , "Invalid visibility of phone number. ");
				driver.manage().window().maximize();
				softAsert.assertAll();
	}
		@Test(priority = 40)
	public void   headerLinksCheck() {
		headerPage.getContactUsLink().click();
		softAsert.assertEquals(driver.getTitle(), "Contact us - My Store");
		headerPage.getSignInLink().click();
		softAsert.assertEquals(driver.getTitle(), "Login - My Store");
		softAsert.assertAll();
		
	} @AfterClass
		public void after() {
		driver.quit();
	}
	
		
		
		
		
		
	
		
			
		

		
		
		
		
		
		
		
		
		
	

	
}
