package pageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SbsPageObjects {
	
	//MainFrameObjects
	@FindBy(xpath="//div[@class='simpleBuySell']//div[@class='header']")
	public static WebElement header;
	
	@FindBy(xpath="//a[text()='BABYDOGE']")
	public static WebElement BabyDogde;
	
	@FindBy(xpath="//a[text()='SHIB']")
	public static WebElement SHIB;
	
	@FindBy(xpath="//a[text()='BTC']")
	public static WebElement BTC;
	
	@FindBy(xpath="//a[text()='ETH']")
	public static WebElement ETH;
	
	@FindBy(xpath="//a[text()='BAT']")
	public static WebElement BAT;
	
	@FindBy(xpath="//a[text()='WBTC']")
	public static WebElement WBTC;
	
	@FindBy(xpath="//a[text()='REP']")
	public static WebElement REP;
	
	//MoreCoins
	
	@FindBy(xpath="//a[@class='sbsShowAllLink']")
	public static WebElement moreCoins;	
	
	@FindBy(xpath="//img[@alt='close']")
	public static WebElement closedialogBox;
	
	@FindBy(xpath="//input[@placeholder='Search coin']")
	public static WebElement searchBox;	
	
	@FindBy(xpath="//div[@class='simpleCoinPicker dialog ']//div[@class='row'][2]")
	public static WebElement pickcoins;
	
	@FindBy(xpath="//div[@data-coin='MATIC']")
	public static WebElement maticCoin;
	
	@FindBy(xpath="//div[@data-coin='DOGE']")
	public static WebElement dogeCoin;
	
	@FindBy(xpath="//div[@data-coin='BTC']")
	public static WebElement bitCoin;
	
	@FindBy(xpath="//div[@data-coin='REP']")
	public static WebElement repcoin;
	
	@FindBy(xpath="//div[@data-coin='TUSD']")
	public static WebElement rtusdCoin;
	
	
	// Main Page Objects:
	
	@FindBy(xpath="//span[@class='blue basecoinBalance']")
	public static WebElement inrBal; 
	
	@FindBy(xpath="//a[@id='trigger_1_1']")
	public static WebElement sbsBuy;
	
	@FindBy(xpath="//div[@class='label buyFee']/div[1]")
	public static WebElement buyfees;
	
	@FindBy(xpath="//div[@class='limitsSection']")
	public static WebElement buymm_value;
	
	@FindBy(xpath="//div[@class='label buyFee']//div[@class='limitsSection']//span[1]")
	public static WebElement buyminValue;
	
	@FindBy(xpath="//div[@class='label buyFee']//div[@class='limitsSection']//span[2]")
	public static WebElement buymaxValue;
	
	@FindBy(xpath="//div[@data-for='buy']//div[@class='col-6'][1]//input[1]")
	public static WebElement buyquantity;
	
	@FindBy(xpath="//div[@data-for='buy']//div[@class='col-6'][2]//input[1]")
	public static WebElement buytotal;
	
	@FindBy(xpath="//div[@data-for='buy']//button[@class='placeOrderBtn']")
	public static WebElement instantbuyBtn;
	
	@FindBy(xpath="//div[@data-for='buy']//div[contains(@class,'coinPriceSection')]")
	public static WebElement buycoinPrice;
	
	//SELL OBJECTS
	
	@FindBy(xpath="//a[@id='trigger_1_2']")
	public static WebElement sbssell;
	
	@FindBy(xpath="//span[@class='blue paircoinBalance']")
	public static WebElement paircoinBal;
	
	@FindBy(xpath="//div[@class='label sellFee']/div[1]")
	public static WebElement sellfees;
	
	@FindBy(xpath="//div[@data-for='sell']//div[@class='col-6'][1]//input[1]")
	public static WebElement sellQuantity;
	
	@FindBy(xpath="//div[@data-for='sell']//div[@class='col-6'][2]//input[1]")
	public static WebElement sellTotal;
	
	@FindBy(xpath="//div[@class='label sellFee']//div[@class='limitsSection']//span[1]")
	public static WebElement sellminValue;
	
	@FindBy(xpath="//div[@class='label sellFee']//div[@class='limitsSection']//span[2]")
	public static WebElement sellmaxValue;
	
	@FindBy(xpath="//div[@data-for='sell']//button[@class='placeOrderBtn']")
	public static WebElement instantsellBtn;
	
	@FindBy(xpath="//div[@data-for='sell']//div[contains(@class,'coinPriceSection')]")
	public static WebElement sellcoinPrice;

	
	
	
	//Alert
	@FindBy(xpath="//div[@class='row footer']//button[text()='Ok']")
	public static WebElement alertokBtn;
	
	@FindBy(xpath="//button[normalize-space()='Yes']")
	public static WebElement alertyesBtn;
	
	@FindBy(xpath="//button[text()='No']")
	public static WebElement alertnoBtn;
	
	@FindBy(xpath="//div[@class='row body']")
	public static WebElement alertText;

	
	
	
	

}
