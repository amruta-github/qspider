import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoldCoins {
	WebDriver driver;
	Actions action;
	WebElement coins, plaincoins, laxmicoins;
	
	@BeforeMethod
	public void bm() {
		System.setProperty("webdriver.chrome.driver", ".\\Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bluestone.com/");
				
		action = new Actions(driver);
		coins = driver.findElement(By.xpath("//a[@title='Coins']"));
		action.moveToElement(coins).build().perform();
		
		plaincoins = driver.findElement(By.xpath("//li[@id='goldCoins']/div/ul/li[1]/div"));
		laxmicoins = driver.findElement(By.xpath("//li[@id='goldCoins']/div/ul/li[2]/div"));
		
	}

	@Test(priority=1)
	public void plain20gms() throws InterruptedException {
		plaincoins.findElement(By.xpath("//ul/li/span[@data-p='gold-coins-weight-20gms,m']")).click();
		
		if(driver.getTitle().contains("20 gram") && !(driver.getTitle().contains("Lakshmi"))) {
			Assert.assertTrue(true);
			Reporter.log("plain 20 gms", true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=2)
	public void plain50gms() throws InterruptedException {
		plaincoins.findElement(By.xpath("//ul/li/span[@data-p='gold-coins-weight-50gms,m']")).click();
	
		if(driver.getTitle().contains("50 gram") && !(driver.getTitle().contains("Lakshmi"))) {
			Assert.assertTrue(true);
			Reporter.log("plain 50 gms", true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=3)
	public void laxmi2gms() throws InterruptedException {	
		laxmicoins.findElement(By.xpath("//ul/li/span[@data-p='l-gold-coins-weight-2gms,m']")).click();
	
		if(driver.getTitle().contains("2 gram") && driver.getTitle().contains("Lakshmi")) {
			Assert.assertTrue(true);
			Reporter.log("laxmi 2 gms", true);
		} else {
			Assert.assertTrue(false);
		}
		driver.close();
	}
	
	@Test(priority=4)
	public void laxmi5gms() throws InterruptedException {
		laxmicoins.findElement(By.xpath("//ul/li/span[@data-p='l-gold-coins-weight-5gms,m']")).click();
		
		if(driver.getTitle().contains("5 gram") && driver.getTitle().contains("Lakshmi")) {
			Assert.assertTrue(true);
			Reporter.log("laxmi 5 gms", true);
		} else {
			Assert.assertTrue(false);
		}
		driver.close();
	}
	
	@Test(priority=5)
	public void laxmi10gms() throws InterruptedException {
		laxmicoins.findElement(By.xpath("//ul/li/span[@data-p='l-gold-coins-weight-10gms,m']")).click();
	
		if(driver.getTitle().contains("10 gram") && driver.getTitle().contains("Lakshmi")) {
			Assert.assertTrue(true);
			Reporter.log("laxmi 10 gms", true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@AfterMethod
	public void am(){

	}
}
