package workFlow;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.Kyc2Objects;


public class KycVerfication2 {
	//WebDriver driver;
	@SuppressWarnings("deprecation")
	@Test
	@Parameters("driver")
	public void KycVerfyPage(WebDriver driver) throws InterruptedException {

		//driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PageFactory.initElements(driver, Kyc2Objects.class);
    	Kyc2Objects.firstName.clear();
		Kyc2Objects.firstName.sendKeys("Sanjay");
		Kyc2Objects.lastName.clear();
		Kyc2Objects.lastName.sendKeys("Karunanithi");
		Kyc2Objects.pannum.sendKeys("HCRPS1113o");
		Kyc2Objects.aadhaarnum.sendKeys("733117031333");
		Kyc2Objects.male.click();
		Thread.sleep(3000);
		Kyc2Objects.dob.click();
		Kyc2Objects.leftclick.click();
		Kyc2Objects.date.click();

		Select primarylang=new Select(Kyc2Objects.primarylang);
		primarylang.selectByValue("Tamil");

		Select secondarylang=new Select(Kyc2Objects.seclang);
		secondarylang.selectByValue("Tamil");
		
		Select state=new Select(Kyc2Objects.state);
		state.selectByValue("Tamil Nadu");
		Thread.sleep(5000);
		Kyc2Objects.submit_verfiy.click();
		
		Bankdetails bd=new Bankdetails();
		bd.bankdetail(driver);
		
		//driver.quit();
		

	}
	
	}
