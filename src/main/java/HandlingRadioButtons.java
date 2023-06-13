import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandlingRadioButtons {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Sanjay\\\\Downloads\\\\chromedriver_win32\\\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");		
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://letcode.in/radio");

		WebElement yesButton=driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[1]/div/label[1]"));
		WebElement noButton=driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[1]/div/label[2]"));
		yesButton.click();
		Boolean ybutton =yesButton.isSelected();
		if(ybutton==true)
			System.out.println("already Selected");
		else
			noButton.click();
		Thread.sleep(3000);

		WebElement disableradio=driver.findElement(By.id("maybe"));
		boolean disradio=disableradio.isEnabled();
		String words=disableradio.getText();
		System.out.println(words);
		System.out.println(disradio);


		WebElement one= driver.findElement(By.id("foo"));
		WebElement two=driver.findElement(By.id("notfoo"));
		Boolean foo=one.isSelected();
		Boolean bar=two.isSelected();
		if(foo==true)
			System.out.println("Foo is selected so it is "+foo);
		else
			System.out.println("Bar is selected so it is"+bar);

		WebElement checkbox=driver.findElement(By.xpath("/html/body/app-root/app-radio-check/section[1]/div/div/div[1]/div/div/div[6]/label[2]/input"));
		boolean tick=checkbox.isSelected();
		System.out.println("True in the sense it is tricked id not"+tick);

		driver.quit();


	}

}
