package week5;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage 
{
	
	public static ChromeDriver driver;
	
	@BeforeMethod
	public void preCondition(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://leaftaps.com/opentaps/");

	}
	
	

	@AfterMethod
	public void postCondition() 
	{
		driver.close();
	}
}
