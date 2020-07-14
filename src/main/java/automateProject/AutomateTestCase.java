package automateProject;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateTestCase {
	
	WebDriver driver;
	
	@Before
	public void launchbrowser() {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://www.techfios.com/ibilling/?ng=admin/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
	}
	
	@Test
	public void interactWithWebElement() throws Exception {
		
		driver.findElement(By.id("username")).sendKeys("demo@techfios.com");
		driver.findElement(By.id("password")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[contains(text(),'Transactions')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'New Deposit')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("account")).sendKeys("Homeloan870");
		
		driver.findElement(By.xpath("//input[@name='description']")).sendKeys("Deji Deposit");
		driver.findElement(By.id("amount")).sendKeys("1000000");
		driver.findElement(By.id("submit")).click();
		Thread.sleep(5000);
	}
	
	@After
	public void tearDown(){
	driver.close();		//close browser
	driver.quit();		//close code
	}
}
	
	