package testCases;

import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginpageObjects;
import pageObject.SbsPageObjects;
import workFlow.DBConnection;

public class SbsHighLight {

	WebDriver driver;

	@BeforeTest
	public void before() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stage3.giottus.com");
		PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.login.click();	 
		LoginpageObjects.email.sendKeys("sanjayk@giottus.com");
		LoginpageObjects.password.sendKeys("SanJay@140998");
		LoginpageObjects.submitbtn.click();
		try {
			String otp = new DBConnection().connectDB();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(LoginpageObjects.otp));
			LoginpageObjects.otp.sendKeys(otp);
			wait.until(ExpectedConditions.visibilityOf(LoginpageObjects.verify));
			LoginpageObjects.verify.click();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
		Thread.sleep(1500);
	}

	@Test(priority=0)
	public void highlight() throws InterruptedException {
		PageFactory.initElements(driver,SbsPageObjects.class);
		Thread.sleep(1500);
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(SbsPageObjects.BabyDogde)));			
		String headerbg=SbsPageObjects.header.getCssValue("background-color");
		System.out.println("Header BackGround Color: "+headerbg);
		
		String bbydoge =SbsPageObjects.BabyDogde.getCssValue("background-color");
		System.out.println(bbydoge);

		Actions builder=new Actions(driver);	
		builder.moveToElement(SbsPageObjects.SHIB).perform();
		String shib = SbsPageObjects.SHIB.getCssValue("background-color");
		System.out.println("Before Pointing SHIB: "+ headerbg);
		System.out.println("After Pointing SHIB: "+ shib);

		builder.moveToElement(SbsPageObjects.BTC).perform();
		String afterbtc = SbsPageObjects.BTC.getCssValue("background-color");
		System.out.println("Before Pointing BTC: "+ headerbg);
		System.out.println("After pointing BTC: "+ afterbtc);

		builder.moveToElement(SbsPageObjects.ETH).perform();
		String eth = SbsPageObjects.ETH.getCssValue("background-color");
		System.out.println("Before Pointing ETH: "+headerbg);
		System.out.println("After pointing ETH: "+ eth);

		builder.moveToElement(SbsPageObjects.BAT).perform();
		String bat = SbsPageObjects.BAT.getCssValue("background-color");
		System.out.println("Before Pointing BAT: "+headerbg);
		System.out.println("After pointing BAT: "+ bat);

		builder.moveToElement(SbsPageObjects.WBTC).perform();
		String wbtc = SbsPageObjects.WBTC.getCssValue("background-color");
		System.out.println("Before Pointing WBTC: "+headerbg);
		System.out.println("After pointing WBTC: "+ wbtc);

		builder.moveToElement(SbsPageObjects.REP).perform();
		String rep = SbsPageObjects.REP.getCssValue("background-color");
		System.out.println("Before Pointing REP: "+headerbg);
		System.out.println("After pointing REP: "+ rep);

	}
	
	@Test(priority=1)
	public void highlightCoinPicker() throws InterruptedException {
		PageFactory.initElements(driver,SbsPageObjects.class);
		SbsPageObjects.moreCoins.click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		String repcoin=SbsPageObjects.repcoin.getCssValue("backgroun-color");
		System.out.println("Rep Coin BackGround Color before Pointing: "+repcoin);
		
		Actions builder=new Actions(driver);
		builder.moveToElement(SbsPageObjects.repcoin).perform();
		String afterrepcoin=SbsPageObjects.repcoin.getCssValue("background-color");
		System.out.println("Rep Coin BackGround Color after Pointing: "+afterrepcoin);
		
		String matic=SbsPageObjects.maticCoin.getCssValue("background-color");
		System.out.println("Matic Coin BackGround Color before Pointing: "+matic);
		
		builder.moveToElement(SbsPageObjects.maticCoin).perform();
		String aftermatic=SbsPageObjects.maticCoin.getCssValue("background-color");
		System.out.println("Matic Coin BackGround Color after Pointing: "+aftermatic);
		
		
	}

	@AfterTest
	public void close() {
		driver.close();
	}

}
