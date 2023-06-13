package workFlow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginpageObjects;
import pageObject.RegistrationpageObject;

public class RegistrationPage {

	WebDriver driver;

	@BeforeTest
	public void openPage() throws InterruptedException{

		driver=new ChromeDriver();
		driver.get("https://stage3.giottus.com");
     	driver.manage().window().maximize();
     	PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.login.click();	 
		Thread.sleep(3000);
		LoginpageObjects.register.click();
		Thread.sleep(3000);
	}
	
	@Test
	public void regisPage() throws InterruptedException {

		PageFactory.initElements(driver, RegistrationpageObject.class);
		RegistrationpageObject.fname.sendKeys("Tester2");
		RegistrationpageObject.lname.sendKeys("One");
		RegistrationpageObject.phnnum.sendKeys("9380241515");
		RegistrationpageObject.email.sendKeys("testdemo@gmail.com");
		RegistrationpageObject.passwrd.sendKeys("Testing@11234");
		//RegistrationpageObject.referal.sendKeys("");
		Thread.sleep(3000);
		System.out.println(RegistrationpageObject.createAcc.isEnabled());
		RegistrationpageObject.createAcc.click();
		WebElement createBtn=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[9]/div/button"));
		createBtn.click();
   
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}

	

}
