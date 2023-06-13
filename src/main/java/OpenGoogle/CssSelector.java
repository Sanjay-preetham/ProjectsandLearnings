package OpenGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CssSelector {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	
		//driver.findElement(By.cssSelector("input[class='RNmpXc']")).click();
	// WebElement lucky= driver.findElement(By.className("RNmpXc"));
	//	WebElement lucky= driver.findElement(By.name("btnI"));
		
		
		//only this will work
		WebElement lucky= driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[2]"));
	     lucky.click();
	     Thread.sleep(3000);
	     driver.navigate().back();
		Thread.sleep(3000);
		driver.quit();
		

	}

}
