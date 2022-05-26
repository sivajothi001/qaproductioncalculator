package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.BaseClass;

public class Page_PrinterCost_Create extends BaseClass{
	
	WebDriver driver;
	
	public Page_PrinterCost_Create(WebDriver driver)
		{
			this.driver=driver;
			
			PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath ="//*[@id=\"searchTermItem\"]")
	WebElement SearchItem;
	
	
	@FindBy(xpath ="//*[@id=\"searchTermPrinter\"]")
	WebElement SearchPrinter;
	
	@FindBy(xpath ="//*[text()=\"Save Printer Cost\"]")
	WebElement SavePrinterCost;
	
	@FindBy(xpath ="//*[contains(text(),\"Printer Costs (\")]//following-sibling::div/button")
	WebElement AddPrinterCost;
	
	public WebElement SelectItem(String Item){
		
		return driver.findElement(By.xpath("//h3[text()=\"Item Selection\"]//following-sibling::div//li//*[text()='"+Item+"']"));
    }
	
	public WebElement SelectPrinter(String Printer){
		
		return driver.findElement(By.xpath("//h3[text()=\"Printer Selection\"]//following-sibling::div//li//*[text()='"+Printer+"']"));
    }
	
	public WebElement Quantity(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[1]//input"));
    }
	
	public WebElement Cost(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[2]//input"));
    }
	
	public WebElement PricesNotes(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[3]//input"));
    }
	
	public WebElement btnDelete(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[4]/button"));
    }
	
	public  void ClkSavePrinterCost(){
		
		SavePrinterCost.click();
		log.info("LOG:INFO - To Click Save Printer Cost Buttion ");
		
	}
	
	public  void ClkaddPrinterCost(int num){
		
		int sellcount = driver.findElements(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[1]//input")).size();
		
		if(sellcount == 0) {
		
			AddPrinterCost.click();
		}
		
	}
	
	public  void CreatePrinterCost(String PrinterName,String ItemName){
		
		
	    new WebDriverWait(driver,600).until(ExpectedConditions.visibilityOf (this.SearchItem));
		
		SearchItem.clear();
		SearchItem.sendKeys(ItemName);
		log.info("Entered the Item Name: "+ItemName);
		
		SelectItem(ItemName).click();
		log.info("To Click Search buttion ");
		
		SearchPrinter.clear();
		SearchPrinter.sendKeys(PrinterName);
		log.info("Entered the Printer Name: "+PrinterName);
		
		SelectPrinter(PrinterName).click();
		log.info("To Select Printer Name ");
		
	}
	
	public void PrinterCost(String num,String NuQuantity,String NuCost,String Notesdetails,String Deletecon) {
		
		this.Quantity(num).clear();
		this.Quantity(num).sendKeys(NuQuantity);
		log.info("Entered the Quantity Name: "+NuQuantity);
		
		this.Cost(num).clear();
		this.Cost(num).sendKeys(NuCost);
		log.info("Entered the Cost: "+NuCost);
		
		this.PricesNotes(num).clear();
		this.PricesNotes(num).sendKeys(Notesdetails);
		log.info("Entered the Notes details: "+Notesdetails);
		
		if(Deletecon.equals("Yes")) {
			btnDelete(num).click();
			log.info("clicked Delete button");
			
		}
		
		
	}
	
	public void DeletePrinterprices(int num) {
		
		int sellcount = driver.findElements(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr")).size();
		
		if(num < sellcount) {
			
			for(int i=sellcount;i>num;i--) {
				
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", this.btnDelete(Integer.toString(i)));
			
		}
			
		}
		
		log.info("clicked Delete Printer Cost button");
		

    }

}
