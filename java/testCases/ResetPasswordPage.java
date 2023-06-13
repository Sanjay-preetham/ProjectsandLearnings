package testCases;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import pageObject.LoginpageObjects;
import pageObject.OtpPageObjects;
import pageObject.ResetPasswordObjects;
import workFlow.DBConnection;

public class ResetPasswordPage {
	WebDriver driver;
	String[] data;
	@BeforeTest
	public void before() throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://stage3.giottus.com");
		PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.login.click();
		Thread.sleep(2000);	
		PageFactory.initElements(driver,ResetPasswordObjects.class);	
		ResetPasswordObjects.frgtpwd.click();

	}

	@Test(dataProvider="EmailData",dataProviderClass=ForgotPassword.class )
	public void emailpage(String emailID) throws ClassNotFoundException, SQLException, InterruptedException, BiffException, IOException{

		  Thread.sleep(1500);
		String url="https://stage3.giottus.com/resetpassword";
		PageFactory.initElements(driver, ResetPasswordObjects.class);
		ResetPasswordObjects.emailField.sendKeys(emailID);
		Thread.sleep(1500);

		ResetPasswordObjects.resetpassBtn.click();	
		Thread.sleep(1500);

		if(driver.getCurrentUrl().equals(url)) {
			Reporter.log(emailID+":: "+ResetPasswordObjects.emailpagecont.getText());
		}
		Thread.sleep(2500);
	}


	@Test(priority=1)
	public void otp() throws ClassNotFoundException, SQLException, InterruptedException {
		Thread.sleep(4000);
		String otp=new DBConnection().connectDB();
		Thread.sleep(1500);
		Reporter.log("Mobile OTP is:: "+ otp);
		ResetPasswordObjects.enterOtp.sendKeys(otp);
		PageFactory.initElements(driver, OtpPageObjects.class);
		Thread.sleep(1500);
		OtpPageObjects.verifyBtn.click();}




	@Test(priority=2,dataProvider="PswrdData",dataProviderClass=ForgotPassword.class)
	public void resetPassword(String password) throws BiffException, IOException, InterruptedException
	{  
		String Url="https://stage3.giottus.com/changepassword";
		PageFactory.initElements(driver, ResetPasswordObjects.class);
		ResetPasswordObjects.newPassword.sendKeys(password);
		ResetPasswordObjects.confirmPassword.sendKeys(password);

		String colorPro1=ResetPasswordObjects.property1.getCssValue("color");
		String colorPro2=ResetPasswordObjects.property2.getCssValue("color");
		String colorPro3=ResetPasswordObjects.property3.getCssValue("color");
		String colorPro4=ResetPasswordObjects.property4.getCssValue("color");
		String colorPro5=ResetPasswordObjects.property5.getCssValue("color");

		String hex=Color.fromString(colorPro1).asHex();
		String hex1=Color.fromString(colorPro2).asHex();
		String hex2=Color.fromString(colorPro3).asHex();
		String hex3=colorPro1=Color.fromString(colorPro4).asHex();
		String hex4=Color.fromString(colorPro5).asHex();

		Reporter.log(password+":: "+hex+" RGBA Colors are: "+colorPro1);
		Reporter.log(password+":: "+hex1+" RGBA Colors are: "+colorPro2);
		Reporter.log(password+":: "+hex2+" RGBA Colors are: "+colorPro3);
		Reporter.log(password+":: "+hex3+" RGBA Colors are: "+colorPro4);
		Reporter.log(password+":: "+hex4+" RGBA Colors are: "+colorPro5);

		ResetPasswordObjects.saveBtn.click();
		Thread.sleep(1500);
		Reporter.log(password+":: "+ResetPasswordObjects.content.getText());
		if(driver.getCurrentUrl().equals(Url)) {
			ResetPasswordObjects.newPassword.clear();
			ResetPasswordObjects.confirmPassword.clear();
		}
}
	@AfterTest
	public void close() {
		driver.quit();
	}
}




