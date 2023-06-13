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

public class LoginTestCases {
	WebDriver driver;

	String[][] data;

	@BeforeTest
	public void open() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@DataProvider(name = "loginData")
	public String[][] Dataprovider() throws BiffException, IOException {
		data = loginExcelData();
		return data;
	}

	@Test
	public String[][] loginExcelData() throws BiffException, IOException {

		String tcFile="C:\\Users\\Sanjay\\Documents\\Selenium TestCases\\LoginTestCases.xls";
		FileInputStream excel = new FileInputStream(tcFile);
		Workbook wrkBook = Workbook.getWorkbook(excel);
		Sheet loginSheet = wrkBook.getSheet("Sheet1");

		int col = loginSheet.getColumns();
		int row = loginSheet.getRows();

		String[][] testdata = new String[row - 1][col];

		for (int i = 1; i <= row - 1; i++) {
			for (int j = 0; j < col; j++) {
				testdata[i - 1][j] = loginSheet.getCell(j, i).getContents();
				Reporter.log(loginSheet.getCell(j, i).getContents());
			}
		}
		return testdata;
	}

	@Test(dataProvider = "loginData")
	public void login(String uname, String pword) {
		driver.get("https://stage3.giottus.com/login");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


		WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/input"));
		username.sendKeys(uname);
		WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div/input"));
		password.sendKeys(pword);

		WebElement loginbtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[5]/div/button")));
		loginbtn.click();
		WebElement message = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div/div[2]/div/div")));

		Reporter.log(message.getText());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}
	@AfterTest
	public void close() {
		driver.quit();
	}

}
