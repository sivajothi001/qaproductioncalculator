package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;
import testUtilities.XLUtility;

public class Page_PrinterCost_List extends BaseClass{
	
	WebDriver driver;
	
	public Page_PrinterCost_List(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[contains(text(),\"Create Printer Pricing\")]")
	WebElement btnPrinterPricing;
	
	public WebElement lnkItemName(String PrinterName){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]"));
    }
	
	public WebElement btnDetails(String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[3]//following-sibling::div/*[text()=\"Details\"]"));
    }
	
	public WebElement btnEdit(String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[3]//following-sibling::div/*[text()=\" Edit \"]"));
    }
	
	public WebElement btnDelete(String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[3]//following-sibling::div/*[text()=\" Delete \"]"));
    }
	
	public WebElement lblPrinterName(String num,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody/tr["+num+"]/td[1]"));
    }
	
	public WebElement lblQuantity(String num,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody/tr["+num+"]/td[2]"));
    }
	
	public WebElement lblCost(String num,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody/tr["+num+"]/td[3]"));
    }
	
	public WebElement lblNotes(String num,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody/tr["+num+"]/td[4]"));
    }
	
	public WebElement lblCreateAt(String num,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody/tr["+num+"]/td[5]"));
    }
	
	@FindBy(xpath ="//button[text()=\"Delete\"]")
	WebElement btndeleteconfirm;
	
	public void clkCreatePrinterCost() {
		
		btnPrinterPricing.click();
		log.info("LOG:INFO - To Click Create Printer Cost Button ");
	}
	
	public void clkEditPrinterCost(String PrinterName,String itemname) {
		
		log.info("LOG:INFO - To Click Printer Name Menu Button "+PrinterName);
		
		new WebDriverWait(driver,50000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'"+PrinterName+"')]")));
		
		lnkItemName(PrinterName).click();
		log.info("LOG:INFO - To Click Printer Name Menu Button ");
		
		btnEdit(PrinterName,itemname).click();
		log.info("LOG:INFO - To Click Item Edit Button ");
	}
	
	public void clkDeletePrinterCost(String PrinterName,String itemname) {
		
		log.info("LOG:INFO - To Click Printer Name Menu Button "+PrinterName);
		
		new WebDriverWait(driver,50000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'"+PrinterName+"')]")));
		
		lnkItemName(PrinterName).click();
		log.info("LOG:INFO - To Click Printer Name Menu Button ");
		
		btnDelete(PrinterName,itemname).click();
		log.info("LOG:INFO - To Click Item Delete Button ");
		
		btndeleteconfirm.click();
	}
	
	public void ValidatePrintercost(String PrinterName,String itemname,String Sheetname) throws InterruptedException {
		
		new WebDriverWait(driver,50000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'"+PrinterName+"')]")));
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", this.lnkItemName(PrinterName));
		
		btnDetails(PrinterName,itemname).click();
		
		Object[][] excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx",Sheetname);
		
		int nums =excelFiles.length;
		
		for(int i=1;i<=nums;i++) {
			
			String actPrinterName = lblPrinterName(Integer.toString(i),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Printer Name " +actPrinterName);
			
			String actQuantity = lblQuantity(Integer.toString(i),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Quantity " +actQuantity);
			
			String actCost = lblCost(Integer.toString(i),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Cost " +actCost);
			
			String actNotes = lblNotes(Integer.toString(i),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Notes " +actNotes);
			
			actCost = actCost.substring( 1, actCost.length() - 1 );
			
			Assert.assertEquals(actPrinterName,PrinterName);
			log.info("LOG:INFO - To Compare Printer Name " +actPrinterName+" and "+PrinterName);
			
			Assert.assertEquals(actQuantity,excelFiles[i-1][0].toString());
			log.info("LOG:INFO - To Compare Quantity " +actQuantity+" and "+excelFiles[i-1][0].toString());
			
			Assert.assertEquals(actCost,excelFiles[i-1][1].toString());
			log.info("LOG:INFO - To Compare Cost " +actCost+" and "+excelFiles[i-1][1].toString());
			
			Assert.assertEquals(actNotes,excelFiles[i-1][2].toString());
			log.info("LOG:INFO - To Compare Notes " +actNotes+" and "+excelFiles[i-1][2].toString());
			
		}
		
		
		
	}

}
