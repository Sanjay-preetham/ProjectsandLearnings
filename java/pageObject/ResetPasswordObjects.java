package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPasswordObjects {
	@FindBy(xpath="//a[contains(@class,'forgotPswdLink')]")
	public static WebElement frgtpwd;
	
	@FindBy(xpath="//div[contains(@class,'pageMessageContent')]")
	public static WebElement emailpagecont;

	@FindBy(xpath="//input[@class='formInputField']")
	public static WebElement emailField;
	
	@FindBy(xpath="//button[text()='Reset Password']")
	public static WebElement resetpassBtn;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/input")
	public static WebElement enterOtp;	
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter New Password')]")
	public static WebElement newPassword;
	
	@FindBy(xpath="//input[contains(@placeholder,'Enter Confirm Password')]")
	public static WebElement confirmPassword;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[7]/div/button")
	public static WebElement saveBtn;
	
	@FindBy(xpath="//div[contains(@class,'alertMessageContent')]")
	public static WebElement content;
	
	@FindBy(xpath="//li[contains(@data-id, '0')]")
	public static WebElement property1;
	
	@FindBy(xpath="//li[contains(@data-id, '1')]")
	public static WebElement property2;
	
	@FindBy(xpath="//li[contains(@data-id, '2')]")
	public static WebElement property3;
	
	@FindBy(xpath="//li[contains(@data-id, '3')]")
	public static WebElement property4;
	
	@FindBy(xpath="//li[contains(@data-id, '4')]")
	public static WebElement property5;
	
	

	
	
	
	
	
}
