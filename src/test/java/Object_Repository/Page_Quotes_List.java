package Object_Repository;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;

public class Page_Quotes_List extends BaseClass{
	
	WebDriver driver;
	
	public Page_Quotes_List(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[@class=\"flex-none ml-6\"]/*[contains(text(),\"Create Quote\")]")
	WebElement CreateQuote;
	
	public WebElement getquotename(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[2]"));
    }
	
	public WebElement getJobnumbername(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td/*[text()='"+quotename+"']/../following-sibling::td[1]"));
    }
	
	public WebElement getTotalItemsname(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td/*[text()='"+quotename+"']/../following-sibling::td[2]"));
    }
	
	public WebElement getAuthorname(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td/*[text()='"+quotename+"']/../following-sibling::td[3]/div[1]"));
    }
	
	public WebElement getTotalname(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td/*[text()='"+quotename+"']/../following-sibling::td[4]"));
    }
	
	public WebElement btnview(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td/*[text()='"+quotename+"']/../following-sibling::td[5]//*[contains(text(),\"View\")]"));
    }
	
	public WebElement getEdit(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td/*[text()='"+quotename+"']/../following-sibling::td[5]//*[contains(text(),\"Edit\")]"));
    }
	
	public WebElement getDelete(String quotename){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td/*[text()='"+quotename+"']/../following-sibling::td[5]//*[contains(text(),\"Delete\")]"));
    }
	
	@FindBy(xpath ="//button[text()=\"Delete\"]")
	WebElement btndeleteconfirm;
	
	
	public void clkCreateQuote() {
		
		CreateQuote.click();
		log.info("LOG:INFO - To Click Create Quote button");
		
	}
	
	public void clkEditQuote(String quotename) throws InterruptedException {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", this.getEdit(quotename));
		
		log.info("LOG:INFO - To Click Edit Quote button "+quotename);
		
	}
	
	public void clkDeleteQuote(String quotename) throws InterruptedException {
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", this.getDelete(quotename));
		
		log.info("LOG:INFO - To Click Delete Quote button "+quotename);
		
		btndeleteconfirm.click();
		
	}
	
	public void validateQuoteslist(String quotename,String Jobnumber,String totalItems,String Authorname,String Totalamount) throws ParseException, InterruptedException {
		
		Thread.sleep(50000);
		
		String actquotename= this.getquotename(quotename).getText();
		log.info("LOG:INFO - To Get quote name " +actquotename);
		
		String actJobnumbername= this.getJobnumbername(quotename).getText();
		log.info("LOG:INFO - To Get Jobnumber " +actJobnumbername);
		
		String actotalItems= this.getTotalItemsname(quotename).getText();
		log.info("LOG:INFO - To Get total Items " +actotalItems);
		
		String actAuthorname= this.getAuthorname(quotename).getText();
		log.info("LOG:INFO - To Get Author name " +actAuthorname);
		
		String actTotalamount = this.getTotalname(quotename).getText();
		log.info("LOG:INFO - To Get Total Amount " +actTotalamount);
		
		Assert.assertEquals(actquotename,quotename);
		log.info("LOG:INFO - To Compare quote name " +actquotename+" and "+quotename);
		
		Assert.assertEquals(actJobnumbername,Jobnumber);
		log.info("LOG:INFO - To Compare Jobnumber " +actJobnumbername+" and "+Jobnumber);
		
		Assert.assertEquals(actotalItems,totalItems);
		log.info("LOG:INFO - To Compare total Items " +actotalItems+" and "+totalItems);
		
		Assert.assertEquals(actAuthorname,Authorname);
		log.info("LOG:INFO - To Compare Author name " +actAuthorname+" and "+Authorname);
		
		Assert.assertEquals(actTotalamount,Totalamount);
		log.info("LOG:INFO - To Compare Total amount " +actTotalamount+" and "+Totalamount);
		
	}
}
