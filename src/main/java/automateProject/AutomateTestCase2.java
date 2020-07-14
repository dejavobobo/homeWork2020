package automateProject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomateTestCase2 {
	
	WebDriver driver;

	@Before
	public void launchBrowser() throws InterruptedException {

		// setting the properties
		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");

		// creating web driver instance (photocopy)
		driver = new ChromeDriver();

		// maximize browser
		driver.manage().window().maximize();

		// go to site
		driver.get("http://techfios.com/ibilling/?ng=admin/");
	}

	@Test
	public void loginTest1() throws InterruptedException {
		// identify the user name field
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");

		// identify the password field
		driver.findElement(By.id("password")).sendKeys("abc123");

		// identify sign in button and click
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//span[text()='Customers']")).click();
		driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@name='account']")).sendKeys("Deji Badmus");
				
		WebElement COMPANY_DROPDOWN_LOCATOR = driver.findElement(By.xpath("//select[@id='cid']"));
		Select sel2 = new Select(COMPANY_DROPDOWN_LOCATOR);
		sel2.selectByVisibleText("Techfios");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("Deji@techfios.com");
		driver.findElement(By.xpath("//input[@name='phone']")).sendKeys("6824076845");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("9737 Badmus Avenue");
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Austin");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Texas");
		driver.findElement(By.xpath("//input[@name='zip']")).sendKeys("78652");
		
		WebElement COUNTRY_DROPDOWN_LOCATOR = driver.findElement(By.xpath("//*[@id='country']"));
		Select sel = new Select(COUNTRY_DROPDOWN_LOCATOR);
		sel.selectByVisibleText("American Samoa");
		
		WebElement GROUP_DROPDOWN_LOCATOR = driver.findElement(By.xpath("//select[@name='group']"));
		Select sel1 = new Select(GROUP_DROPDOWN_LOCATOR);
		sel1.selectByVisibleText("Mid Spring 2020");
		
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("scroll(0,8000)");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@id='submit']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='List Customers']")).click();
		
		Thread.sleep(4000);
		
		WebElement SEARCH_DROPDOWN_LOCATOR = driver.findElement(By.xpath("//*[@id=\"foo_filter\"]"));
		SEARCH_DROPDOWN_LOCATOR.sendKeys("Deji Badmus");
		
		Thread.sleep(4000);
		
		SEARCH_DROPDOWN_LOCATOR.sendKeys(Keys.ENTER);
		
		Thread.sleep(4000);
		
		   WebElement VALIDATE_MY_NAME = driver.findElement(By.xpath("/html/body/section/div/div[1]/div[3]/div[1]/div/div/div[2]/table/tbody/tr[1]/td[3]/a") );
		   Assert.assertTrue(VALIDATE_MY_NAME.getText().contains("Deji Badmus") );
				
		driver.close();
		driver.quit();
		
		
	}

}
