package workFlow;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pageObject.BankDetailsObjects;

public class Bankdetails {

	@Test
	@Parameters("driver")
	public void bankdetail(WebDriver driver)

	{
		PageFactory.initElements(driver,BankDetailsObjects.class);
		BankDetailsObjects.AccHolderName.sendKeys("Sanjay");
		BankDetailsObjects.accNum.sendKeys("123456799012");
		BankDetailsObjects.accNum2.sendKeys("123456799012");
		BankDetailsObjects.ifsc.sendKeys("ICIC0000104");
		BankDetailsObjects.upi.sendKeys("sanjay.preetham14@okhdfc.bank");

		Select bankType=new Select(BankDetailsObjects.bankaccType);
		bankType.selectByValue("0");

		BankDetailsObjects.addAcc.click();
		driver.quit();
	}
	
}
