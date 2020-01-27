import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Thanos {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Thanos", Keys.ENTER);	
		
		WebElement resultStats = driver.findElement(By.id("resultStats"));	
		System.out.println("Before : " + resultStats.getText());
		
		pageScrollDown(driver);
		Thread.sleep(1000);
		WebElement handImage = driver.findElement(By.xpath("//div[@class='Z4Kand MyFLjb']"));
		handImage.click();
						
	    WebDriverWait wait = new WebDriverWait(driver, 90);
		Boolean element = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("nobr")));
		
		if(element) {
			Thread.sleep(10000);
			System.out.println("After : " + resultStats.getText());
		}
		
	}

	public static void pageScrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,500)");
	}
}
