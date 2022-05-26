package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testBase.BaseClass;
import testUtilities.XLUtility;

public class Page_PrinterCostUpdates extends BaseClass{
	
	WebDriver driver;
	
	public Page_PrinterCostUpdates(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public WebElement lnkPrinterName(String PrinterName){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]"));
    }
	
	public WebElement btnView(String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[3]//following-sibling::div/*[contains(text(),\"View\")]"));
    }
	
	public WebElement lblPrinterName(String Quantity,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody//div[1]/span[text()='"+Quantity+"']//ancestor::td//preceding::td[1]"));
    }
	
	public WebElement lblBeforeQuantity(String Quantity,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody//div[1]/span[text()='"+Quantity+"']"));
    }
	
	public WebElement lblAfterQuantity(String Quantity,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody//div[1]/span[text()='"+Quantity+"']//following-sibling::span[2]"));
    }
	
	public WebElement lblQuantityUpdatedAt(String Quantity,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody//div[1]/span[text()='"+Quantity+"']//parent::div//following-sibling::div//span"));
    }
	
	public WebElement lblBeforeCost(String Quantity,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody//div[1]/span[text()='"+Quantity+"']//ancestor::td//following-sibling::td/div[1]/span[1]"));
    }
	
	public WebElement lblAfterCost(String Quantity,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody//div[1]/span[text()='"+Quantity+"']//ancestor::td//following-sibling::td/div[1]/span[3]"));
    }
	
	public WebElement lblCostUpdatedAt(String Quantity,String PrinterName,String itemname){
		
		return driver.findElement(By.xpath("//*[contains(text(),'"+PrinterName+"')]//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//*[text()='"+itemname+"']//ancestor::div[4]//following-sibling::div[@class=\"p-6\"]//tbody//div[1]/span[text()='"+Quantity+"']//ancestor::td//following-sibling::td/div[2]/span[1]"));
    }
	
	
	public void ValidatePrinterCostUpdates(String PrinterName,String itemname) {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		menu.clickCostUpdates();
		
		new WebDriverWait(driver,50000).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'"+PrinterName+"')]")));
		
		lnkPrinterName(PrinterName).click();
		
		btnView(PrinterName,itemname).click();
		
		Object[][] toPrinterCosts = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditPrinterCostsList");
		
		Object[][] fromPrinterCosts = XLUtility.getDataFromloginSheet("Input_Data.xlsx","PrinterCostsList");
		
		for(int i=1;i<=fromPrinterCosts.length;i++) {
			
			String actPrinterNames  = lblPrinterName(fromPrinterCosts[i-1][0].toString(),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Printer Name " +actPrinterNames);
			
			String actBeforeQuantity  = lblBeforeQuantity(fromPrinterCosts[i-1][0].toString(),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Before Quantity " +actBeforeQuantity);
			
			String actAfterQuantity  = lblAfterQuantity(fromPrinterCosts[i-1][0].toString(),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get After Quantity " +actAfterQuantity);
			
			String actQuantityUpdatedAt  = lblQuantityUpdatedAt(fromPrinterCosts[i-1][0].toString(),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Quantity UpdatedAt " +actQuantityUpdatedAt);
			
			String actBeforeCost  = lblBeforeCost(fromPrinterCosts[i-1][0].toString(),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get Before Cost " +actBeforeCost);
			
			String actAfterCost  = lblAfterCost(fromPrinterCosts[i-1][0].toString(),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get After Cost " +actAfterCost);
			
			String actCostUpdatedAt  = lblCostUpdatedAt(fromPrinterCosts[i-1][0].toString(),PrinterName,itemname).getText();
			log.info("LOG:INFO - To Get CostUpdatedAt " +actCostUpdatedAt);
			
			actBeforeCost = actBeforeCost.substring( 1, actBeforeCost.length() - 1 );
			
			actAfterCost = actAfterCost.substring( 1, actAfterCost.length() - 1 );
			
			Assert.assertEquals(actBeforeQuantity,fromPrinterCosts[i-1][0].toString());
			log.info("LOG:INFO - To Compare Before Quantity  " +actBeforeQuantity+" and "+fromPrinterCosts[i-1][0].toString());
			
			Assert.assertEquals(actAfterQuantity,toPrinterCosts[i-1][0].toString());
			log.info("LOG:INFO - To Compare After Quantity " +actAfterQuantity+" and "+toPrinterCosts[i-1][0].toString());
			
			Assert.assertEquals(actBeforeCost,fromPrinterCosts[i-1][1].toString());
			log.info("LOG:INFO - To Compare Before Cost " +actBeforeCost+" and "+fromPrinterCosts[i-1][1].toString());
			
			Assert.assertEquals(actAfterCost,toPrinterCosts[i-1][1].toString());
			log.info("LOG:INFO - To Compare After Cost " +actAfterCost+" and "+toPrinterCosts[i-1][1].toString());
			
			Assert.assertEquals(actPrinterNames,PrinterName);
			log.info("LOG:INFO - To Compare Printer Names " +actPrinterNames+" and "+PrinterName);
			
		}
		
	}

}
