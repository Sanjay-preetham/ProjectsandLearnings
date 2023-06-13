package testCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class RegistrationPageTestCases {

	WebDriver driver;
	String[][] data;

	@DataProvider(name="regData")
	public String[][] Dataprovider() throws BiffException, IOException
	{
		data=regExcelData();
		return data;
	}
	@Test
	public String[][] regExcelData() throws BiffException, IOException{

		String regTCFile="C:\\Users\\Sanjay\\Documents\\Selenium TestCases\\RegistrationPAgeTestCases.xls";
		FileInputStream excel=new FileInputStream(regTCFile);
		Workbook wrkBook =Workbook.getWorkbook(excel);
		Sheet loginSheet=wrkBook.getSheet("Sheet1");

		int col=loginSheet.getColumns();
		int row=loginSheet.getRows();

		String[][] testdata=new String[row-1][col];
		for(int i=1;i<row;i++) {
			for(int j=0;j<col;j++) {		
				testdata[i-1][j]=loginSheet.getCell(j, i).getContents();
				
			}
		}
		return testdata;
	}

	@Test(dataProvider="regData")
	public void regPage(String firstname,String lastNamee,String mobnum,String mail,String passwor,String ref) throws InterruptedException  {
		driver.get("https://stage3.giottus.com/register");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));

		WebElement firstName=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[1]/input"));
		firstName.sendKeys(firstname);
		WebElement lastName=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/input"));
		lastName.sendKeys(lastNamee);
		WebElement phnNum=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[1]/input"));
		phnNum.sendKeys(mobnum);
		WebElement mailId=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[2]/input"));
		mailId.sendKeys(mail);
		WebElement password=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[5]/div[1]/div[1]/input"));
		password.sendKeys(passwor);
		WebElement referal=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[5]/div[2]/input"));
		referal.sendKeys(ref);
		WebElement createBtn=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[9]/div/button"));
		createBtn.click();
     	WebElement pmContent=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div"))));
	
     	Reporter.log(pmContent.getText());
		Thread.sleep(1000);
	}

	@BeforeTest
	public void open() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();

	}

	@AfterTest
	public void close() {
		driver.quit();
	}



}
