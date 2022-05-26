package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testBase.BaseClass;
import testUtilities.XLUtility;

public class Page_CostComparesion extends BaseClass {
	
	WebDriver driver;
	
	public Page_CostComparesion(WebDriver driver)
		{
			this.driver=driver;
			
			PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath ="//*[@id=\"client\"]")
	WebElement Client;
	
	@FindBy(xpath ="//*[@id=\"search\"]")
	WebElement SearchItem;
	
	@FindBy(xpath ="//*[@id=\"searchTermPrinter\"]")
	WebElement SearchPrinter;
	
	@FindBy(xpath ="//*[contains(text(),\"Next: Compare\")]")
	WebElement btnCompare;
	
	public WebElement selectItem(String Item){
		
		return driver.findElement(By.xpath("//li//label[text()='"+Item+"']"));
    }
	
	public WebElement SelectPrinters(String Printers){
		
		return driver.findElement(By.xpath("//li//label[text()='"+Printers+"']"));
    }
	
	
	public  void CheckPrinterCostComparison(String Item,String printer){
		
		//Select lstclient = new Select(Client); 
		//lstclient.selectByVisibleText(ClientName);
		//log.info("LOG:INFO - To Select the Client " +ClientName);
		
		SearchItem.clear();
		SearchItem.sendKeys(Item);
	    log.info("LOG:INFO - To enter the Item Name " +Item);
	    
	    selectItem(Item).click();
		log.info("LOG:INFO - To Select Item Name " +Item);
		
		Object[][] lstPrinter = XLUtility.getDataFromloginSheet("Input_Data.xlsx","CostComparison");
		
		for(int i=1;i<=lstPrinter.length;i++) {
			
			SearchPrinter.clear();
			SearchPrinter.sendKeys(lstPrinter[i-1][1].toString());
		    log.info("LOG:INFO - To enter the Printer Name " +lstPrinter[i-1][1].toString());
		    
		    SelectPrinters(lstPrinter[i-1][1].toString()).click();
			log.info("LOG:INFO - To Select Printer Name " +lstPrinter[i-1][1].toString());
			
		}
		
		btnCompare.click();
		log.info("LOG:INFO - To Clicked Compare button ");
		
	}
	
	public  void ValidatePrinterCostComparison(String Item,String printer){
		
		Object[][] lstPrinter = XLUtility.getDataFromloginSheet("Input_Data.xlsx","CostComparison");
		
		for(int i=1;i<=lstPrinter.length;i++) {
		
			int PrinterCount = driver.findElements(By.xpath("//*[text()='"+lstPrinter[i-1][1].toString()+"']")).size();
			
			for(int j=1;j<=PrinterCount;j++) {
				
				String Quantity = driver.findElement(By.xpath("//tr["+Integer.toString(j)+"]//*[text()='"+lstPrinter[i-1][1].toString()+"']//following-sibling::td[1]")).getText();
				
				String Cost = driver.findElement(By.xpath("//tr["+Integer.toString(j)+"]//*[text()='"+lstPrinter[i-1][1].toString()+"']//following-sibling::td[2]")).getText();
				
				String Rank = driver.findElement(By.xpath("//tr["+Integer.toString(j)+"]//*[text()='"+lstPrinter[i-1][1].toString()+"']//preceding::td")).getText();
				
				if(driver.findElements(By.xpath("//*[text()='auto_printer_v0526134048']//following-sibling::td[1][text()='"+Quantity+"']")).size() != 0) {
					
					String ComCost = driver.findElement(By.xpath("//*[text()='auto_printer_v0526134048']//following-sibling::td[1][text()='"+Quantity+"']//following-sibling::td")).getText();
					
					String ComRank = driver.findElement(By.xpath("//*[text()='auto_printer_v0526134048']//following-sibling::td[1][text()='"+Quantity+"']]//preceding::td[2]")).getText();
					
					double dCost =  Double.parseDouble(Cost.replaceAll("\\$", ""));
							
					double dComCost =  Double.parseDouble(ComCost.replaceAll("\\$", ""));
					
					if(dCost > dComCost) {
						
						Assert.assertEquals("2",Rank);
						log.info("LOG:INFO - As expected rank 2 actual Rank " +Rank);
					}else {
						Assert.assertEquals("1",ComRank);
						log.info("LOG:INFO - As expected rank 1 actual Rank " +ComRank);
					}
					
				}else {
					
					Assert.assertEquals("1",Rank);
					log.info("LOG:INFO - As Default Rank " +Rank);		
				}
			}		
		}	
	}
}
