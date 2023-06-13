package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginpageObjects {

	@FindBy(xpath="/html/body/div[1]/div[2]/div/a[4]")
	public static WebElement login;

	@FindBy(xpath="/html/body/div[2]/div/div/div[7]/div/a")
	public static WebElement register;

	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/input")
	public static WebElement email;

	@FindBy(xpath="/html/body/div[2]/div/div/div[4]/div/input")
	public static WebElement password;

	@FindBy(xpath="/html/body/div[2]/div/div/div[5]/div/button")
	public static WebElement submitbtn;

	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/input")
	public static WebElement otp;

	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/div/div")
	public static WebElement invalidotp;

	@FindBy(xpath="/html/body/div[2]/div/div/div[4]/div/button")
	public static WebElement verify;
	
	



	
	
}
