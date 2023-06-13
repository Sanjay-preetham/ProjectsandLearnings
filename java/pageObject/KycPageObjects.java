package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KycPageObjects {

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[8]/div[2]/a")
	public static WebElement browsefiles;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[9]/div[2]/select")
	public static WebElement addDropDown;


	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[10]/div[2]/a")
	public static WebElement addFront;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[11]/div[2]/a")
	public static WebElement addBack;

	@FindBy(xpath="/html/body/div[2]/div/div[2]/div[12]/div/div/button")
	public static WebElement nextBtn;

	

	
	

}
