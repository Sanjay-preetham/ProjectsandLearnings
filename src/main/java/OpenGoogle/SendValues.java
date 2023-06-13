package OpenGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SendValues {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://google.co.in");
		WebElement search = driver.findElement(By.className("gLFyf"));
		search.sendKeys("Giottus.com");
		search.sendKeys(Keys.ENTER);
		System.out.println("Title of the page = "+ driver.getTitle());
		Thread.sleep(3000);
		driver.close();

	}

}