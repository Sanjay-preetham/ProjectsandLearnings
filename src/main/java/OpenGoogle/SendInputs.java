package OpenGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SendInputs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://letcode.in/edit");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.id("fullName")).sendKeys("Monkey D Luffy");
		Thread.sleep(3000);
		driver.findElement(By.id("join")).sendKeys(" Gum Gum Man",Keys.TAB);
		Thread.sleep(3000);
		driver.findElement(By.id("getMe")).getAttribute("value");
		Thread.sleep(3000);
		driver.findElement(By.id("clearMe")).clear();
		Thread.sleep(3000);
	Boolean boxfield=driver.findElement(By.id("noEdit")).isEnabled();
	Thread.sleep(3000);
	
	      if(boxfield==true)
	    	  System.out.println("Box is Enabled");
	      else
	    	  System.out.println("Box is disabled");
	     
	     String isReadableOnly= driver.findElement(By.id("dontwrite")).getAttribute("readOnly");
	     System.err.println(isReadableOnly);
	     driver.close();
	     
	}

}
