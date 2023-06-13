package OpenGoogle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Dummy {

	public static void main(String[] args) throws BiffException, IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://stage3.giottus.com/register");
		List<String[]> testData = TestDataUtil.readTestData("C:\\Users\\Sanjay\\Documents\\dummy.csv");

		for (String[] data : testData) {
			String firstName = data[0];
			String lastNamee = data[1];
			String mobNum   = data[2];
			String mail= data[3];
			String pwor=  data[4];
			String ref= data[5];

			WebElement firstName11=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[1]/input"));
			firstName11.sendKeys(firstName);
			Thread.sleep(1000);
			WebElement lastName=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div[2]/input"));
			lastName.sendKeys(lastNamee);
			Thread.sleep(1000);
			WebElement phnNum=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[1]/input"));
			phnNum.sendKeys(mobNum);
			Thread.sleep(1000);
			WebElement mailId=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[4]/div[2]/input"));
			mailId.sendKeys(mail);
			Thread.sleep(1000);
			WebElement password2=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[5]/div[1]/div[1]/input"));
			password2.sendKeys(pwor);
			Thread.sleep(1000);
			WebElement referal=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[5]/div[2]/input"));
			referal.sendKeys(ref);
			Thread.sleep(1000);
			WebElement createBtn=driver.findElement(By.xpath("/html/body/div[2]/div/div/div[9]/div/button"));
			createBtn.click();

			//    		WebElement msg=wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div"))));
			//    		System.out.println(msg.getText())

		}
		//driver.quit();

	}
}
class TestDataUtil{
	public static List<String[]> readTestData(String FilePath) {
		List<String[]> testData = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
			String line;
			int count =0;
			while ((line = br.readLine()) != null) {
				count++;
				if(count==1) {
					continue;
				}
				String[] data = line.split(",");
				testData.add(data);
			}
		} catch (IOException e) {
			System.err.println("Error reading test data from file: " + e.getMessage());
		}

		return testData;
	}
}






