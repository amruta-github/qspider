import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaAssign {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".\\Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Java", Keys.ENTER);
		List <WebElement> nav = driver.findElements(By.xpath("//tr[@valign='top']/td"));
		int navcnt = nav.size();
				
		while(navcnt !=0) {
			Thread.sleep(1500);
			pageScrollDown(driver);
			driver.findElement(By.cssSelector("#pnnext")).click();
			navcnt--;
		}
	}
	
	public static void pageScrollDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

}
