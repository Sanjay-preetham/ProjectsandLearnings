import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandlingFrame {

	@Test
	public void frame() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/frame");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.switchTo().frame(0);
		driver.findElement(By.name("fname")).sendKeys("Naruto");
		Thread.sleep(3000);

		driver.switchTo().frame(1);
		driver.findElement(By.name("email")).sendKeys("uzumakinaruto@hokagage.com");
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
		driver.findElement(By.name("lname")).sendKeys("Uzumaki");
		Thread.sleep(3000);

		driver.switchTo().defaultContent();
		driver.findElement(By.className("card-footer-item")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);

		driver.quit();



	}

}
