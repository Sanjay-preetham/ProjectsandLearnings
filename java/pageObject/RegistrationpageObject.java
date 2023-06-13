package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationpageObject {
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div[1]/input")
	public static WebElement fname;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[3]/div[2]/input")
    public static WebElement lname;
	
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[4]/div[1]/input")
	public static WebElement phnnum;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[4]/div[2]/input")
	public static WebElement email;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[5]/div[1]/div[1]/input")
	public static WebElement passwrd;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[5]/div[2]/input")
	public static WebElement referal;
	
	@FindBy(xpath="/html/body/div[2]/div/div/div[9]/div/button")
	public static WebElement createAcc;

}
