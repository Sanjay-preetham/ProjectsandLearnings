import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandlingCalendar {

	@Test
	public  void calendar() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/calendar");
		WebElement calendar=driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[1]/nwb-date-picker/div[2]/div[2]/div[2]/div[2]/button[2]"));
		calendar.click();
		WebElement next=driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[2]/nwb-date-picker/div[2]/div[1]/div/input[1]"));
		next.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement firstdate=driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[1]/nwb-date-picker/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[9]/button"));
		firstdate.click();
//		WebElement seconddate=driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[2]/nwb-date-picker/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[13]/button"));
//		next.click();
//		seconddate.click();
		
//		next.click();
//		seconddate.click();

		System.out.println(firstdate.isSelected());	
		WebElement close=driver.findElement(By.xpath("/html/body/app-root/app-calender/section[1]/div/div/div[1]/div/div/div[1]/div[2]/nwb-date-picker/div[2]/div[2]/div[2]/div[2]/button[4]"));
		Thread.sleep(3000);
		close.click();
		driver.quit();


	}

}
