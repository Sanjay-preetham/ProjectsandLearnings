import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Buttons {

	@Test
	public void buttons() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/buttons");
		driver.manage().window().maximize();
		WebElement home=driver.findElement(By.id("home"));
		home.click();
		Thread.sleep(3000);
		driver.navigate().back();
		WebElement position=driver.findElement(By.id("position"));
		Point point=position.getLocation();
		//Thread.sleep(3000);
		int xaxis=point.getX();
		int yaxis=point.getY();
		System.out.println("x-------> "+ xaxis + "yaxis-------> "+yaxis);

		WebElement color= driver.findElement(By.id("color"));
		String bgcolor=color.getCssValue("background-color");
		System.out.println("BackGround color "+ bgcolor);
		
		WebElement size=driver.findElement(By.id("property"));
		Dimension boxsize=size.getSize();
		int height=boxsize.getHeight();
	    int width=	boxsize.getWidth();
	    System.out.println("Height is"+height);
	    System.out.println("Width is"+width);
	    
	   WebElement disButton= driver.findElement(By.id("isDisabled"));
	 Boolean isDisabled=  disButton.isEnabled();
	 
	 if(isDisabled==true)
		 System.out.println("Button is Enabled");
	 else
		 System.out.println("Button is Disabled");
	 
	 
	WebElement holdButton= driver.findElement(By.xpath("//*[@id='isDisabled']"));
	System.out.println(holdButton.isEnabled());
	Actions actions =new Actions(driver);
	//actions.moveToElement(holdButton);
	actions.clickAndHold(holdButton).perform();
	Thread.sleep(3000);
	
	driver.close();
		 
		
		

	}

}
