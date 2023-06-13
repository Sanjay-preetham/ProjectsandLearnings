import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class DownloadFileHandling {

	@Test
	public void downloadFile() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/file");
		driver.manage().window().maximize();
		WebElement download=driver.findElement(By.id("xls"));
		download.click();
		Thread.sleep(3000);
		File location=new File("C:\\Users\\Sanjay\\Downloads");
		File[] totalfile= location.listFiles();
		for (File file : totalfile) {
			System.out.println(file);
		}
		for (File file1 : totalfile) {
			if(file1.getName().equals("sample.xlsx")) {
				System.out.println("File Successfully Downloaded");
				break;


			}

		}
		driver.quit();
	}

}
