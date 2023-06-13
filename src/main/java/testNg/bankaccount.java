package testNg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class bankaccount {
	WebDriver driver;
	@Test
	public void bankAccount() throws InterruptedException {


		driver = new ChromeDriver();
		driver.get("https;//stage3.giottus.com/profile");
		WebElement addBank=  driver.findElement(By.xpath("//*[@id='bank']/div[2]/button"));
		addBank.click();
		WebElement accHolderName=driver.findElement(By.xpath("//*[@id='accholdername']"));

		// Alert alert=driver.switchTo().alert();
		Actions bulider=new Actions(driver);

		bulider.sendKeys(accHolderName,"sanjay");
		Thread.sleep(3000);

		driver.quit();


	}
}
