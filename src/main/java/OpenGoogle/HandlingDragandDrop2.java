package OpenGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HandlingDragandDrop2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	WebElement drag=driver.findElement(By.id("form:conpnl"));
	System.out.println(drag.getText());
	Actions builder=new Actions(driver);
	
	builder.dragAndDropBy(drag, 198, 198).perform();
	driver.quit();
	
		

	}

}
