package week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateContact extends BasePage
{
	
	@Test(dataProvider="Add",dataProviderClass = ReadExcel.class)
	public void createContact (String user,String password) 
	{
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		System.out.println("\n"+driver.getTitle()+"\n");
	
		driver.findElement(By.partialLinkText("Contacts")).click();
		driver.findElement(By.partialLinkText("Create Contact")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Thirumurugan");
		driver.findElement(By.id("lastNameField")).sendKeys("G");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("G");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Test_Engineer");
		driver.findElement(By.id("createContactForm_description")).sendKeys("NOTHING");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("thiru110298@gmail.com");
		WebElement state=driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select stateName=new Select(state);
		stateName.selectByVisibleText("New York");
		driver.findElement(By.className("smallSubmit")).click();
		driver.findElement(By.partialLinkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("NOTHING");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		String title = driver.getTitle();
		System.out.println("The title of page is : "+title);
	}
}
