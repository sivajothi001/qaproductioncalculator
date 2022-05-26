package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.BaseClass;

public class Page_Login extends BaseClass{
	
	
	WebDriver driver;
	
	public Page_Login(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath = "//input[@name='username']")
	WebElement txtUsername;
	
	
	@FindBy(xpath = "//input[@name='password']")
	WebElement txtPassword;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement BtnLogin;
	
	
	
	public  void loginToApplication(String uname,String pass)
	{
		
		
		txtUsername.sendKeys(uname);
		log.info("Enter the UserName");
		
		txtPassword.sendKeys(pass);
		log.info("Enter the Password");
		
		BtnLogin.click();
		log.info("Click the Submit button");
		
		try {
			
			Assert.assertTrue(driver.getTitle().contains("Studio Console"));
			log.info("verified Page title");
		}
		catch(Exception e){
			
			System.out.println("Login Page not found");
			
		}
	
		
	}

}
