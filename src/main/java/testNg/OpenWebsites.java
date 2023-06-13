package testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class OpenWebsites {
	WebDriver driver;
	long startTime;
	long endTime;
	@BeforeSuite
	public void Openbrowser() {
		startTime=System.currentTimeMillis();
		driver = new ChromeDriver();
	}
	@Test
	public void openGoogle() {
	driver.get("https://google.co.in");
	}
	@Test
	public void openBing() {
		driver.get("https://Bing.com");
		}
	@Test
	public void openYahoo() {
		driver.get("https://Yahoo.com");
		}
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
		endTime=System.currentTimeMillis();
		long totalTime=endTime-startTime;
		System.out.println("TotalTime: "+totalTime );
	}

}
