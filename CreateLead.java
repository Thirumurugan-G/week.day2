package week5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateLead extends BasePage
{
	
	@Test(dataProvider="Add",dataProviderClass = ReadExcel.class)
	public void createLead (String user,String password) 
	{
		driver.findElement(By.id("username")).sendKeys(user);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.partialLinkText("CRM/SFA")).click();
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("G");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("02/11/98");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("7708921844");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("*1108");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("thiru110298@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.testleaf.com");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Thirumurugan");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("no 1,pillaiyar koil st,keelkattalai");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("no 1,pillaiyar koil st,keelkattalai");
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		WebElement country=driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select countryName=new Select(country);
		countryName.selectByVisibleText("India");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600117");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("044");
		WebElement state=driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select stateName=new Select(state);
		stateName.selectByVisibleText("TAMILNADU");
		driver.findElement(By.className("smallSubmit")).click();
	}

}
