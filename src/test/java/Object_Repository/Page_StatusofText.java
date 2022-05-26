package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;

public class Page_StatusofText extends BaseClass{
	
	WebDriver driver;
	
	public Page_StatusofText(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	By message1= By.cssSelector(".ml-3 > .mt-1");
	
	By status1= By.xpath("//div[2]/p");
	
	public void statusvalidate(String Status)
	{
		
		String message2 =  driver.findElement(message1).getText();
		 
		String status2 =  driver.findElement(status1).getText();
		 
		//Assert.assertEquals(message2,message);
			
		Assert.assertEquals(status2,Status);
	}

}