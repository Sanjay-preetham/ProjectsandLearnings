package testCases;

import java.sql.SQLException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginpageObjects;
import pageObject.SbsPageObjects;
import workFlow.DBConnection;

public class SBSSearchcoins {
	WebDriver driver;

	@BeforeTest
	public void before() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stage3.giottus.com/login");
		PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.email.sendKeys("sanjayk@giottus.com");
		LoginpageObjects.password.sendKeys("SanJay@140998");
		LoginpageObjects.submitbtn.click();
		try {
			String otp = new DBConnection().connectDB();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(LoginpageObjects.otp));
			LoginpageObjects.otp.sendKeys(otp);
			wait.until(ExpectedConditions.visibilityOf(LoginpageObjects.verify));
			LoginpageObjects.verify.click();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Thread.sleep(1000);
		SbsPageObjects.moreCoins.click();
	}
	
	
	@Test(dataProvider="SbsSearch",dataProviderClass=SbsDataprovider.class,priority=0)
	public void searchBox(String coinValues) {
		PageFactory.initElements(driver, SbsPageObjects.class);
		
		
		
		if(!coinValues.isEmpty()) {
		SbsPageObjects.searchBox.sendKeys(coinValues);
		System.out.println(SbsPageObjects.pickcoins.getText());
		SbsPageObjects.moreCoins.clear();
		}
		
	}

	@Test
	public void morecoins() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		PageFactory.initElements(driver, SbsPageObjects.class);
		wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.moreCoins)).click();
		String coinList=SbsPageObjects.pickcoins.getText();
		
//	    Iterator<WebElement> i = coinList.iterator();
//		while(i.hasNext()) {
//		    WebElement row = i.next();
//		    System.out.println(row.getText());
//		} 
	    
      
    	   System.out.println(coinList);
    	 if(coinList.contains("Bitcoin (BTC)")) {
				wait.until(ExpectedConditions.elementToBeClickable(SbsPageObjects.maticCoin)).click();
				System.out.println(SbsPageObjects.buycoinPrice.getText());
				
			}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	


	@AfterTest
	public void close() {
		driver.quit();
	}

}
