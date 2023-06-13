import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {


		//WebDriverManager.chromedriver().setup();
		long time=System.currentTimeMillis();
		WebDriver driver=new ChromeDriver();		
		driver.get("https://google.co.in");
	
		long endTime=System.currentTimeMillis();
		long totalTime=endTime-time;
		System.out.println("TotalTime: "+totalTime );
		driver.quit();





	}

}
