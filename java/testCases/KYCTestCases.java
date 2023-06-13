package testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import pageObject.Kyc2Objects;
import pageObject.KycPageObjects;
import pageObject.LoginpageObjects;
import workFlow.DBConnection;

public class KYCTestCases {

	WebDriver driver;
	String[][] data;

	@DataProvider(name = "KycData")
	public String[][] Dataprovider() throws BiffException, IOException, InterruptedException {
		Thread.sleep(3000);
		data = kycExcelData();
		return data;
	}

	@SuppressWarnings("deprecation")
	public String[][] kycExcelData() throws BiffException, IOException, InterruptedException {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String kycFile="C:\\Users\\Sanjay\\Documents\\Selenium TestCases\\KYCTestCases.xls";
		FileInputStream excel = new FileInputStream(kycFile);
		Workbook workbook = Workbook.getWorkbook(excel);
		Sheet kycsheet = workbook.getSheet("Sheet1");
		int row = kycsheet.getRows();
		int col = kycsheet.getColumns();

		String[][] testSheetdata = new String[row - 1][col];

		for (int i = 1; i < row; i++) {
			for (int j = 0; j < col; j++) {
				testSheetdata[i - 1][j] = kycsheet.getCell(j, i).getContents();
			}
}
		return testSheetdata;
	}

	@Test(dataProvider = "KycData")
	public void kyc2Page(String panFName, String panLName, String PanNum, String aadhaarNum)
			throws InterruptedException {

		PageFactory.initElements(driver, Kyc2Objects.class);
		Kyc2Objects.firstName.clear();
		Kyc2Objects.firstName.sendKeys(panFName);
		Kyc2Objects.lastName.clear();
		Kyc2Objects.lastName.sendKeys(panLName);
		Kyc2Objects.pannum.clear();
		Kyc2Objects.pannum.sendKeys(PanNum);
		Kyc2Objects.aadhaarnum.clear();
		Kyc2Objects.aadhaarnum.sendKeys(aadhaarNum);
		Kyc2Objects.male.click();
		Thread.sleep(3000);
		Kyc2Objects.dob.click();
		Kyc2Objects.leftclick.click();
		Kyc2Objects.date.click();

		Select primarylang = new Select(Kyc2Objects.primarylang);
		primarylang.selectByValue("Tamil");

		Select secondarylang = new Select(Kyc2Objects.seclang);
		secondarylang.selectByValue("Tamil");

		Select state = new Select(Kyc2Objects.state);
		state.selectByValue("Tamil Nadu");
		Thread.sleep(5000);
		Kyc2Objects.submit_verfiy.click();
	}

	@BeforeTest
	public void open() throws InterruptedException, AWTException {
		driver = new ChromeDriver();
		driver.get("https://stage3.giottus.com");
		driver.manage().window().maximize();
		PageFactory.initElements(driver, LoginpageObjects.class);
		LoginpageObjects.login.click();
		Thread.sleep(1000);
		LoginpageObjects.email.sendKeys("sanjay.preetham14@gmail.com");
		LoginpageObjects.password.sendKeys("SanJay@140998");
		Thread.sleep(1000);
		LoginpageObjects.submitbtn.click();

		Thread.sleep(1000);

		String url = driver.getCurrentUrl();
		Reporter.log(url);

		if (url.equalsIgnoreCase("https://stage3.giottus.com/mobileotp")) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			try {
				String otp = new DBConnection().connectDB();
				LoginpageObjects.otp.sendKeys(otp);
				LoginpageObjects.verify.click();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			Reporter.log(LoginpageObjects.invalidotp.getText());
		}

		Thread.sleep(5000);
		PageFactory.initElements(driver, KycPageObjects.class);
		KycPageObjects.browsefiles.click();

		String panCard = "C:\\Users\\Sanjay\\Downloads\\Pan Card (1).pdf";
		gettingPdf(panCard);

		Select aadharselect = new Select(KycPageObjects.addDropDown);
		aadharselect.selectByValue("Aadhaar");

		KycPageObjects.addFront.click();
		Thread.sleep(3000);
		String aadhar = "C:\\Users\\Sanjay\\Downloads\\AadhaarCard.pdf";
		gettingPdf(aadhar);

		KycPageObjects.addBack.click();
		Thread.sleep(3000);
		String aadhar1 = "C:\\Users\\Sanjay\\Downloads\\AadhaarCard.pdf";
		gettingPdf(aadhar1);
		Thread.sleep(3000);

		KycPageObjects.nextBtn.click();
		Thread.sleep(3000);
	}

	public void gettingPdf(String file) throws AWTException {

		StringSelection selection = new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
