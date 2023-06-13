package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BankDetailsObjects {
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/input")
	public static WebElement AccHolderName;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[2]/input")
	public static WebElement ifsc;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[3]/input")
	public static WebElement accNum;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[4]/input")
	public static WebElement accNum2;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[5]/input")
	public static WebElement upi;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[6]/select")
	public static WebElement bankaccType;
	
	@FindBy(xpath="/html/body/div[2]/div[2]/div[7]/div/button")
	public static WebElement addAcc;
	
	
	
	
	
	
	

}
