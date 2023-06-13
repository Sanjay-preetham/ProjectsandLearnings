import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class HandlingDragDrop {

	@Test
	public  void dragandDrop() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sanjay\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");		
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://letcode.in/dropable");
		WebElement source=	driver.findElement(By.id("draggable"));
		WebElement target=	driver.findElement(By.id("droppable"));
		
		System.out.println(source.getText());	
		System.out.println(target.getText());
		
		Actions builder=new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		
	
		
		System.out.println(target.getText());
		Thread.sleep(3000);	
		driver.quit();



	}

}
