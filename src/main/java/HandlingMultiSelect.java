import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class HandlingMultiSelect {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/selectable");
		driver.manage().window().maximize();
		
	List<WebElement> listoptions=driver.findElements(By.xpath("//*[@id='selectable']"));
	int optsize=listoptions.size();
	System.out.println(optsize);
	
	  Actions builder=new Actions(driver);
	  builder.sendKeys(Keys.CONTROL).sendKeys(listoptions.get(0)).clickAndHold().sendKeys(listoptions.get(1)).perform();
	  builder.keyDown(Keys.CONTROL).click(listoptions.get(4)).click(listoptions.get(7)).build().perform();
	  Thread.sleep(3000);
	  driver.quit();
	}

}
