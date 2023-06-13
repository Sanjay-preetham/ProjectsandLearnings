import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingSorts {

	
	@Test
	public void sorts() throws InterruptedException {



		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/sortable");
		driver.manage().window().maximize();

		List<WebElement> box=driver.findElements(By.xpath("//*[@id='sample-box1']"));
		int boxsize=box.size();
		System.out.println(boxsize);
		for(int i=0;i<boxsize;i++) {
			System.out.println(box.get(i).getText());
		}

		WebElement work=box.get(0);
		WebElement work1=box.get(6);
		
		WebElement work2=box.get(1);
		WebElement work3=box.get(6);
		
		WebElement work4=box.get(2);
		WebElement work5=box.get(7);
		
		WebElement work6=box.get(4);
		WebElement work7=box.get(8);
		
		System.out.println(work1.getText());
		Actions builder=new Actions(driver);
		
		builder.clickAndHold(work);
		//builder.moveToElement(work1);
		builder.release(work5);
		
//		builder.clickAndHold(work2);
//		builder.moveToElement(work3);
//		builder.release(work3);
//		
//		builder.clickAndHold(work4);
//		builder.moveToElement(work5);
//		builder.release(work5);
//		
//		builder.clickAndHold(work6);
//		builder.moveToElement(work7);
//		builder.release(work7);

		
		//More to Learn
	
		builder.perform();
		Thread.sleep(3000);
		Thread.sleep(3000);
		driver.quit();

	}

}
