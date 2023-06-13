

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingDragandDrop2 {

	@Test
	public void dragandDrop2() throws InterruptedException {


		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/draggable");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		WebElement drag=driver.findElement(By.xpath("//*[@id='sample-box']"));
		//WebElement drop=driver.findElement(By.id("example-boundary"));
		System.out.println(drag.getText());
		Actions builder=new Actions(driver);
		Actions hold=builder.clickAndHold();
		hold.dragAndDropBy(drag, 55, 85).build().perform();

		driver.quit();

	}

}
