package workFlow;

import java.awt.AWTException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginpageObjects;

public class Login {
	WebDriver driver;

	@Test
	public void login() throws InterruptedException{
		
		PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.login.click();	 
		Thread.sleep(3000);
		LoginpageObjects.email.sendKeys("");
		LoginpageObjects.password.sendKeys("");
		Thread.sleep(3000);
		LoginpageObjects.submitbtn.click();

		Thread.sleep(5000);

		String url=driver.getCurrentUrl();
		System.out.println(url);

		if(url.equalsIgnoreCase("https://stage3.giottus.com/mobileotp")) {
			Thread.sleep(5000);
			try {
				String otp = new DBConnection().connectDB();
				LoginpageObjects.otp.sendKeys(otp);
				LoginpageObjects.verify.click();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println(LoginpageObjects.invalidotp.getText());
		}
		KycPage kycPage=new KycPage();
		try {
			kycPage.kycFirst(driver);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	@BeforeTest
	public void open() {
		driver=new ChromeDriver();
		driver.get("https://stage3.giottus.com");
		driver.manage().window().maximize();
//		RegistrationPage rgpage=new RegistrationPage();
//		try {
//			rgpage.mainPage(driver);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}

	@AfterTest
	public void kyc() throws InterruptedException
	{
		KycPage kycPage=new KycPage();
		try {
			kycPage.kycFirst(driver);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

}
