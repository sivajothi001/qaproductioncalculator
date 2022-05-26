package Object_Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.BaseClass;

public class Page_Printer_List extends BaseClass {
	
	WebDriver driver;
	
	public Page_Printer_List(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[contains(text(),\"Create Printer\")]")
	WebElement CreatePrinter;
	
	public WebElement getPrintername(String Printername){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1]/*[text()='"+Printername+"']"));
    }
	
	public List<WebElement> getmodifiable(String Printername){
		
		return driver.findElements(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1]/*[text()='"+Printername+"']//parent::td//following-sibling::td[1]//*[@fill=\"currentColor\"]"));
    }
	
	public List<WebElement> getPricingVisible(String Printername){
		
		return driver.findElements(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1]/*[text()='"+Printername+"']//parent::td//following-sibling::td[2]//*[@fill=\"currentColor\"]"));
    }
	
	public WebElement getCreateDate(String Printername){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1]/*[text()='"+Printername+"']//parent::td//following-sibling::td[3]"));
    }
	
	public WebElement getUpdatedDate(String Printername){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1]/*[text()='"+Printername+"']//parent::td//following-sibling::td[4]"));
    }
	
	public WebElement btnEdit(String Printername){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1]/*[text()='"+Printername+"']//parent::td//following-sibling::td[5]//*[contains(text(),\"Edit\")]"));
    }
	
	public WebElement btnDelete(String Printername){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1]/*[text()='"+Printername+"']//parent::td//following-sibling::td[5]//*[contains(text(),\"Delete\")]"));
    }
	
	@FindBy(xpath ="//button[text()=\"Delete\"]")
	WebElement btndeleteconfirm;
	
	public void ClkCreatePrinters(){
		
		CreatePrinter.click();
		log.info("Clicked Create printer");
    }
	
	public void ClkEditPrinters(String Printername){
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", this.btnEdit(Printername));
		log.info("Clicked Edit printer");
    }
	
	
	public void ValidatePrinters(String Printername,String Modifiable,String PricingVisible,String createdate,String updatedate) throws ParseException {
		
		String printer = this.getPrintername(Printername).getText();
		log.info("LOG:INFO - To Get Printer name " +printer);
		
		int modi= this.getmodifiable(Printername).size();
		
		int Pricingvis = this.getPricingVisible(Printername).size();
		
		String actcreatedate = this.getCreateDate(Printername).getText();
		log.info("LOG:INFO - To Get Crate Date " +actcreatedate);
		
		String actupdatedate =this.getUpdatedDate(Printername).getText();
		log.info("LOG:INFO - To Get Update Date " +actupdatedate);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date actcreateddate1=dateFormat.parse(actcreatedate);  
		
		Date actupdateddate1=dateFormat.parse(actupdatedate);
		
		Date createdate1=dateFormat.parse(createdate);  
		
		Date updatedate1=dateFormat.parse(updatedate);
		
		Assert.assertEquals(printer,Printername);
		log.info("LOG:INFO - To Compare Printer Name " +printer+" and "+Printername);
		
		if(Modifiable.equalsIgnoreCase("Yes")) {
			
			Assert.assertEquals(modi,1);
			}else {
			Assert.assertEquals(modi,0);
		}
		
		if(PricingVisible.equalsIgnoreCase("Yes")) {
			
			Assert.assertEquals(Pricingvis,1);
			
			}else {
			Assert.assertEquals(Pricingvis,0);
		}
		
		if(createdate.length()!=0) {
			
			if(actcreateddate1.compareTo(createdate1)<=5 && actcreateddate1.compareTo(createdate1)>=-5) {
				
				log.info("Printer Create date matched");
			}else {
				log.error("Printer Create date does nto matched");
			}
			
		}
		
		if(actupdateddate1.compareTo(updatedate1)<=5 && actupdateddate1.compareTo(updatedate1)>=-5) {
			log.info("Printer update date matched");
		}else {
			log.error("Printer update date does nto matched");
		}
	}
	
	public void PrinterDelete(String PrinterName) {
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		String Editlink = this.btnEdit(PrinterName).getAttribute("href");
		
		this.btnDelete(PrinterName).click();
		
		btndeleteconfirm.click();
		
		status.statusvalidate("Printer Deleted");
		
		int count = driver.findElements(By.xpath("//*[@href='"+Editlink+"']")).size();
		
		if(count>0) {
			
			log.error(PrinterName+" was not deleted");
			
		}else {
			
			log.info(PrinterName+" was deleted successfully");
		}
		
		
		
	}

}
