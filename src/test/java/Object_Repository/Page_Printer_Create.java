package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testBase.BaseClass;

public class Page_Printer_Create extends BaseClass{
	
	WebDriver driver;
	
	public Page_Printer_Create(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[@id=\"name\"]")
	WebElement PrinterName;
	
	@FindBy(xpath ="//*[@id=\"isModifiable\"]")
	WebElement Modifiable;
	
	@FindBy(xpath ="//*[@id=\"isPricingReportVisible\"]")
	WebElement PricingReportVisible;
	
	@FindBy(xpath ="//*[text()=\"Save Printer\"]")
	WebElement SavePrinter;
	
	
	
	public  void CreatePrinter(String Name,String Modifiables,String PricingReportVisibles){
		
		
		PrinterName.clear();
		PrinterName.sendKeys(Name);
		log.info("Enter the Printer Name");
		
		if(Modifiables.equals("Yes")&& Modifiable.isSelected()==false) {
			
			Modifiable.click();
			log.info("Check the Modifiables");
			
		}else if(!Modifiables.equals("Yes")&&Modifiable.isSelected()==true){
			
			Modifiable.click();
			log.info("UnCheck the Modifiables");
		}
		

		if(PricingReportVisibles.equals("Yes")&&PricingReportVisible.isSelected()==false) {
	
			PricingReportVisible.click();
			log.info("Check the Pricing Report Visible");
	
		}else if(!PricingReportVisibles.equals("Yes")&&PricingReportVisible.isSelected()==true){
	
			PricingReportVisible.click();
			log.info("UnCheck the Pricing Report Visible");
		}
		
		
		SavePrinter.click();
		log.info("Click the Printer Save button");
		
	}

}
