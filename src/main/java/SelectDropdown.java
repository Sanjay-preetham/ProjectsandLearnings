import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SelectDropdown {

	@Test
	public void dropd() { 
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Sanjay\\Downloads\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://letcode.in/dropdowns");
		driver.manage().window().maximize();
	
		
	WebElement selectfruits=	driver.findElement(By.id("fruits"));
	  Select selfruits=new Select(selectfruits);
	  selfruits.selectByVisibleText("Banana");
	  selfruits.selectByValue("2");
	WebElement firstFruit=selfruits.getFirstSelectedOption();
      System.out.println(firstFruit.getText());
      
      
	  WebElement myCountry= driver.findElement(By.id("country"));
	  Select country=new Select(myCountry);
	  country.selectByValue("India");
	  WebElement firstSel=country.getFirstSelectedOption();
	  System.out.println(firstSel.getText());
	  
	  WebElement myHeros= driver.findElement(By.id("superheros"));
	  Select heros=new Select(myHeros);
	boolean isMul=  heros.isMultiple();
	if(isMul==true)
		System.out.println("Yes It is Multiple");
	else
		System.out.println("No It is Not Multiple");
	heros.selectByIndex(0);
	heros.selectByValue("bt");
	List<WebElement> allHeros=heros.getAllSelectedOptions();
	allHeros.forEach(i->System.out.println(i.getText()));	
	
	  
		WebElement langs=driver.findElement(By.id("lang"));
		Select language=new Select(langs);
		language.selectByValue("java");
           List<WebElement> lang=language.getOptions();		
           lang.forEach(j->System.out.print(j.getText() + "\t"));
           

          
          driver.close();
	}
		
		
	}


