package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class Kyc2Objects {
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[1]/input")
	public static WebElement firstName;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[2]/input")
	public static WebElement lastName;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[3]/input")
	public static WebElement pannum;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[4]/input")
	public static WebElement aadhaarnum;

	@FindBy(xpath="//*[@id='gender_male']")
	public static WebElement male;

	@FindBy(xpath="//*[@id='gender_female']")
	public static WebElement female;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[6]/input")
	public static WebElement dob;
	
	@FindBy(xpath="/html/body/div[8]")
	public static WebElement leftclick;
	
	@FindBy(xpath="/html/body/div[8]/div/table/tbody/tr[2]/td[5]/button")
	public static WebElement date;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[7]/select")
	public static WebElement primarylang;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[8]/select")
	public static WebElement seclang;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[9]/select")
	public static WebElement state;
	
	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[2]/div[10]/div/button")
	public static WebElement submit_verfiy;
	

}
