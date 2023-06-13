
package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObject.LoginpageObjects;
import pageObject.OtpPageObjects;
import workFlow.DBConnection;

public class OtpTestcases {

	WebDriver driver;

	String[] data;
	boolean disable;

	@DataProvider(name = "otpData")
	public String[] dataprovider() throws BiffException, IOException {

		data = excelData();
		return data;
	}

	public String[] excelData() throws BiffException, IOException {

		String otpFile="C:\\Users\\Sanjay\\Documents\\Selenium TestCases\\OtpTestCases.xls";
		FileInputStream excel = new FileInputStream(otpFile);
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet sheet = workbook.getSheet("Sheet1");
		int row = sheet.getRows();
		String[] otpSheet = new String[row - 1];
		for (int i = 1, j = 0; i <= row - 1; i++) {
			otpSheet[i - 1] = sheet.getCell(j, i).getContents();
		}
		return otpSheet;
	}

	@Test(dataProvider = "otpData")
	public void otptc(String otpData) throws InterruptedException {
	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement verifyBtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[4]/div/button")));
		
		int counter = 0;
		for(int i=0;i<otpData.length();i++) {
			if(otpData.charAt(i) >= '0' && otpData.charAt(i) <= '9')
				counter++;
		}
		Reporter.log("Total Numbers present in otp "+"("+otpData+")"+" is: "+counter);

		if (counter == 6 ) {
			PageFactory.initElements(driver, OtpPageObjects.class);

			OtpPageObjects.enterCode.sendKeys(otpData);
			Reporter.log("Verify Button is Enabled : "+verifyBtn.isEnabled());

			OtpPageObjects.verifyBtn.click();

			try {
			
				Reporter.log(OtpPageObjects.content.getText());
			}
			catch (StaleElementReferenceException e) {
			
				Reporter.log(OtpPageObjects.content.getText());
			}
		}
		else {

			PageFactory.initElements(driver, OtpPageObjects.class);

			OtpPageObjects.enterCode.sendKeys(otpData);
			Reporter.log("Verify Button is Enabled : "+OtpPageObjects.verifyBtn.isEnabled());

			OtpPageObjects.verifyBtn.click(); 
			Reporter.log(OtpPageObjects.content.getText());
			OtpPageObjects.enterCode.clear();
		}
	}

	@AfterTest
	public void close() throws ClassNotFoundException, SQLException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String otp=new DBConnection().connectDB();
		WebElement enterCode = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[3]/div/input")));
		WebElement verifyBtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[4]/div/button")));

		Reporter.log("Valid OTP is :"+ otp);
		enterCode.sendKeys(otp);
		verifyBtn.click();

		driver.quit();
	}

	@BeforeTest
	public void open() throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://stage3.giottus.com");
		driver.manage().window().maximize();
		Thread.sleep(1000);

		PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.login.click();

		LoginpageObjects.email.sendKeys("sanjay.preetham14@gmail.com");
		LoginpageObjects.password.sendKeys("SanJay@140998");
		Thread.sleep(1500);

		LoginpageObjects.submitbtn.click();

		Reporter.log("Present URL :"+driver.getCurrentUrl());

	}
}

