package workFlow;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.KycPageObjects;

public class KycPage {

//	WebDriver driver;
//	@BeforeTest
//	public void openKyc() throws InterruptedException {
//		Login login = new Login();
//		login.login();
//		
//		driver=new ChromeDriver();
//		driver.get("https://stage3.giottus.com/KYC");
//
//	}
	@Test
	@Parameters("driver")
	public void kycFirst(WebDriver driver) throws AWTException, InterruptedException {

        PageFactory.initElements(driver, KycPageObjects.class);
		KycPageObjects.browsefiles.click();
		Thread.sleep(3000);
		
		String panCard="C:\\Users\\Sanjay\\Downloads\\Pan Card (1).pdf";
		gettingPdf(panCard);
		
		Select aadharselect=new Select(KycPageObjects.addDropDown);
		aadharselect.selectByValue("Aadhaar");
		
		KycPageObjects.addFront.click();
		Thread.sleep(3000);
		String aadhar="C:\\Users\\Sanjay\\Downloads\\AadhaarCard.pdf";
		gettingPdf(aadhar);

		KycPageObjects.addBack.click();
		Thread.sleep(3000);
		String aadhar1="C:\\Users\\Sanjay\\Downloads\\AadhaarCard.pdf";
		gettingPdf(aadhar1);
		Thread.sleep(3000);
		
		KycPageObjects.nextBtn.click();
		
     	KycVerfication2 kyc2=new KycVerfication2();
	    kyc2.KycVerfyPage(driver);
		
		

	}
	@Test
	public void gettingPdf(String file) throws AWTException {
		StringSelection selection =new StringSelection(file);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V );
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
//	@AfterTest
//	public void closeKyc() {
//		driver.quit();
	}

