import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandlingWindow {

	@Test
	public void windows() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sanjay\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://letcode.in/windows");
		
		WebElement firsthome=driver.findElement(By.id("home"));
		firsthome.click();
		String newwindow=driver.getWindowHandle();
		System.out.println(newwindow);
		System.out.println(driver.getCurrentUrl());
		
		Set<String > windowHandle=driver.getWindowHandles();
		System.out.println(windowHandle);
		List<String> list=new ArrayList<String>(windowHandle);
		driver.switchTo().window(list.get(1));
		System.out.println(driver.getCurrentUrl());
		driver.close();
		driver.switchTo().window(newwindow);
		//driver.close();
		
		WebElement windowHandles=driver.findElement(By.id("multi"));
		windowHandles.click();
		Set<String> handles=driver.getWindowHandles();
		windowHandles.click();
		List<String> list2=new ArrayList<String>(handles);
		driver.switchTo().window(list2.get(2));
		System.out.println(driver.getCurrentUrl());
		driver.switchTo().window(list2.get(1));
		System.out.println(driver.getCurrentUrl());
		
		
        driver.quit();

	}

}
