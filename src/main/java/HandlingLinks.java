import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandlingLinks {

	@Test
	public  void links() throws InterruptedException {
	
	System.setProperty("webdriver.chrome.driver",
			"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(options);
	driver.get("https://facebook.com");
	driver.manage().window().maximize();
	driver.navigate().back();
	Thread.sleep(3000);
	driver.close();


}
}
