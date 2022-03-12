package week5;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DuplicateLead extends BasePage
{
	@Parameters({"username","password"})
	@Test//(dataProvider="Add",dataProviderClass = ReadExcel.class)
	public void createLead (String user,String password) throws Exception 
	{
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Find Leads")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Email")).click();
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("thiru110298@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
		String name1=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		driver.findElement(By.partialLinkText("Duplicate Lead")).click();
		
		Thread.sleep(1000);
		String title=driver.getTitle();
		System.out.println(title);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@value='Create Lead']")).click();
		String name2=driver.findElement(By.id("viewLead_firstName_sp")).getText();
		Thread.sleep(1000);
		if (name1.equalsIgnoreCase(name2)) 
		{
			System.out.println("The Duplicate name is "+name1);
		}
		else
		{
			System.out.println("No Duplicate Name");
		}
	}

}
