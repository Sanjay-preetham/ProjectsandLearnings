package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OtpPageObjects {
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div/input")
	public static WebElement enterCode;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[4]/div/button")
	public static WebElement verifyBtn;
	
	@FindBy(xpath="//*[contains(@class,'pageMessageContent')]")
	public static WebElement content;

}
