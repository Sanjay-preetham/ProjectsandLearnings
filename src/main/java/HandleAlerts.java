import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class HandleAlerts {

	@Test
	public void alerts() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/alert");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement acceptAlert=	driver.findElement(By.id("accept"));
		acceptAlert.click();
		Alert clickalert=driver.switchTo().alert();
		System.out.println(clickalert.getText());
		Thread.sleep(3000);
		clickalert.accept();


		WebElement confirmAlert= driver.findElement(By.id("confirm"));
		confirmAlert.click();
		Alert conAlert=driver.switchTo().alert();
		System.out.println(conAlert.getText());
		Thread.sleep(3000);
		conAlert.dismiss();

		WebElement promptAlert=driver.findElement(By.id("prompt"));
		promptAlert.click();
		Alert prompAlert= driver.switchTo().alert();
		System.out.println(prompAlert.getText());
		Thread.sleep(3000);
		prompAlert.sendKeys("Yeah Done it");
		prompAlert.accept();

		driver.quit();



	}

}
