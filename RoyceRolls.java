import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class RoyceRolls {
	
	public static int flag;
	
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", ".\\Softwares\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.rolls-roycemotorcars.com/");
		
		//Click on menu
		driver.findElement(By.xpath("//span[@data-style='gradient-black' or text()='MENU']")).click();
		
		List<WebElement> menus = driver.findElements(By.xpath("//div[@class='rrmc-menu-links-container']/div/div"));
		int menusCount = menus.size();
		System.out.println("Menus Count : " + menusCount);
		
		int menuSelected = 0;
		
		for(int i=0; i<menusCount; i++) {
			menuSelected = printMenus(i, menus);
		}
		menus.get(menuSelected).findElement(By.tagName("button")).click();
		
		Thread.sleep(2000);
		List<WebElement> submenus = driver.findElements(By.xpath("//div[@class='rrmc-scroll-links']/div/button"));
		int submenusCount = submenus.size();
		System.out.println("Submenus Count : " + submenusCount);
		
		for(int i=0; i<submenusCount; i++) {
			submenus.get(i).click();
			Thread.sleep(2000);
			String name = submenus.get(i).getText();
			System.out.println("submenu " + i + " : " + name);
			capture(driver, name);
		}
	}

	private static int printMenus(int i, List<WebElement> menus) throws InterruptedException {
			Thread.sleep(1500);
			System.out.println("menu " + i + " : " + menus.get(i).getText());
			
			if(menus.get(i).getText().equalsIgnoreCase("MODELS")) {
				flag = i;
			}
			return flag;
	}
	
	public static void capture(WebDriver driver, String name) throws IOException {
		//name is taken as argument because it will not override screenshots in single variable
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		File ss = new File("./Screenshots/" + name + ".png");
		Files.copy(screenshot, ss);
	}
}
