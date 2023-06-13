package testCases;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import jxl.read.biff.BiffException;
import pageObject.LoginpageObjects;
import pageObject.SbsPageObjects;
import workFlow.DBConnection;

public class SbsMainPage {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void before() throws ClassNotFoundException, SQLException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://stage3.giottus.com/login");
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.email.sendKeys("sanjayk@giottus.com");
		LoginpageObjects.password.sendKeys("SanJay@140998");
		LoginpageObjects.submitbtn.click();
		String otp=new DBConnection().connectDB();
		wait.until(ExpectedConditions.visibilityOf(LoginpageObjects.otp)).sendKeys(otp);;
		wait.until(ExpectedConditions.visibilityOf(LoginpageObjects.verify)).click();
	}
  
	
	//SELL
	@Test(dataProvider="SbsQTValuesSell",dataProviderClass=SbsDataprovider.class,priority=0)
	public void SbsMain(String quantity,String total) throws BiffException, IOException, InterruptedException{
		
		String text="Placing";

		Actions builder=new Actions(driver);

		Thread.sleep(1500);
		PageFactory.initElements(driver, SbsPageObjects.class);
		SbsPageObjects.BabyDogde.click();
		SbsPageObjects.sbssell.click();
		Thread.sleep(500);
		SbsPageObjects.sellTotal.clear();
		SbsPageObjects.sellQuantity.clear();

		if(!total.isEmpty()) {
			System.out.println("yes");
			System.out.println(total);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.sellTotal)).sendKeys(total);
			
		}
		else if(total.isEmpty() && quantity.isEmpty()) {
			System.out.println("yes1");
			System.out.println(quantity+"        "+total);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.sellTotal)).sendKeys(total);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.sellQuantity)).sendKeys(quantity);
			
		}
		else if(!quantity.isEmpty()){
			System.out.println("yes2");
			System.out.println(quantity);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.sellQuantity)).sendKeys(quantity);
			
		}
	
		SbsPageObjects.instantsellBtn.click();
		Thread.sleep(1500);
		System.out.println(SbsPageObjects.alertText.getText());
		System.out.println(SbsPageObjects.alertText.getText().contains(text));
		if(SbsPageObjects.alertText.getText().contains(text))
		{	
			System.out.println("Yes button");
			builder.moveToElement(SbsPageObjects.alertyesBtn).click().perform();
		}
		else
		{
			builder.moveToElement(SbsPageObjects.alertokBtn).click().perform();}	
	}
	
	//BUY
	@Test(dataProvider="SbsQTValuesBuy",dataProviderClass=SbsDataprovider.class,priority=1)
	public void SbsMain1(String quantity,String total) throws BiffException, IOException, InterruptedException{
		
		
		String text="Placing";
		Actions builder=new Actions(driver);
		Thread.sleep(1500);
		PageFactory.initElements(driver, SbsPageObjects.class);
		SbsPageObjects.sbsBuy.click();
		Thread.sleep(500);
		SbsPageObjects.buytotal.clear();
		SbsPageObjects.buyquantity.clear();

		if(!total.isEmpty()) {
			System.out.println("BUY yes");
			System.out.println(total);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.buytotal)).sendKeys(total);
			
		}
		else if(total.isEmpty() && quantity.isEmpty()) {
			System.out.println("BUY yes1");
			System.out.println(quantity+"        "+total);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.buytotal)).sendKeys(total);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.buyquantity)).sendKeys(quantity);
		}
		else if(!quantity.isEmpty()){
			System.out.println("BUY yes2");
			System.out.println(quantity);
			wait.until(ExpectedConditions.visibilityOf(SbsPageObjects.buyquantity)).sendKeys(quantity);
			
		}
		
		SbsPageObjects.instantbuyBtn.click();
		System.out.println(SbsPageObjects.alertText.getText());
		System.out.println(SbsPageObjects.alertText.getText().contains(text));
		
		if(SbsPageObjects.alertText.getText().contains(text))
		{	
			System.out.println("Yes BUY button");
			builder.moveToElement(SbsPageObjects.alertyesBtn).click().perform();
		}
		else
		{
			builder.moveToElement(SbsPageObjects.alertokBtn).click().perform();
		}
		}
	
	
	@Test(priority=2)
	public void buyClickable() {
		
		if(wait.until(ExpectedConditions.elementToBeClickable(SbsPageObjects.inrBal)) != null) 
       {
	         SbsPageObjects.inrBal.click();
	         if((SbsPageObjects.buytotal.getText()!=null) && (SbsPageObjects.buyquantity.getText()!=null))
	         {
	        	 System.out.println("Available INR Balance is Clickable");
	         }
       }
		if(wait.until(ExpectedConditions.elementToBeClickable(SbsPageObjects.buyminValue))!=null)
            {
	            SbsPageObjects.buyminValue.click();
	            if((SbsPageObjects.buytotal.getText()!=null) && (SbsPageObjects.buyquantity.getText()!=null))
		         {
		        	 System.out.println("Minimum Value is Clickable");
		         }
            }
		if(wait.until(ExpectedConditions.elementToBeClickable(SbsPageObjects.buymaxValue))!=null)
        {
            SbsPageObjects.buymaxValue.click();
            if((SbsPageObjects.buytotal.getText()!=null) && (SbsPageObjects.buyquantity.getText()!=null))
	         {
	        	 System.out.println("Maximum Value is Clickable");
	         }
        }
		
		
	}

	@Test(priority=3)
	public void sellClickable() {
		
		SbsPageObjects.sbssell.click();
		
		if(wait.until(ExpectedConditions.elementToBeClickable(SbsPageObjects.paircoinBal)) != null) 
       {
	         SbsPageObjects.paircoinBal.click();
	         if((SbsPageObjects.sellTotal.getText()!=null) && (SbsPageObjects.sellQuantity.getText()!=null))
	         {
	        	 System.out.println("Pair Coin Balance is Clickable");
	         }
       }
		if(wait.until(ExpectedConditions.elementToBeClickable(SbsPageObjects.sellminValue))!=null)
            {
	            SbsPageObjects.sellminValue.click();
	            if((SbsPageObjects.sellTotal.getText()!=null) && (SbsPageObjects.sellQuantity.getText()!=null))
		         {
		        	 System.out.println("Minimum Sell Value is Clickable");
		         }
            }
		if(wait.until(ExpectedConditions.elementToBeClickable(SbsPageObjects.sellmaxValue))!=null)
        {
            SbsPageObjects.sellmaxValue.click();
            if((SbsPageObjects.sellTotal.getText()!=null) && (SbsPageObjects.sellQuantity.getText()!=null))
	         {
	        	 System.out.println("Maximum Sell Value is Clickable");
	         }
        }
		
		
	}

	
	
	
	@AfterTest
	public void close()
	{
		driver.close();
	}

}













