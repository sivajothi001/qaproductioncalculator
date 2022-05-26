package Object_Repository;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import testBase.BaseClass;

public class Page_Item_Create extends BaseClass{
	

	WebDriver driver;
	
	public Page_Item_Create(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[@id=\"name\"]")
	WebElement ItemName;

	@FindBy(xpath ="//*[@id=\"alternateName\"]")
	WebElement AlternateName;
	
	@FindBy(xpath ="//*[@id=\"width\"]")
	WebElement Width;
	
	@FindBy(xpath ="//*[@id=\"height\"]")
	WebElement Height;
	
	@FindBy(xpath ="//*[@id=\"client\"]")
	WebElement Client;
	
	@FindBy(xpath ="//*[@id=\"finishing\"]")
	WebElement Finishing;
	
	@FindBy(xpath ="//*[@id=\"color\"]")
	WebElement Color;
	
	@FindBy(xpath ="//*[@id=\"side\"]")
	WebElement Side;
	
	@FindBy(xpath ="//*[@id=\"substrate\"]")
	WebElement Substrate;
	
	@FindBy(xpath ="//*[@id=\"leadTime\"]")
	WebElement LeadTime;
	
	@FindBy(xpath ="//*[@id=\"notes\"]")
	WebElement Notes;
	
	@FindBy(xpath ="//*[@id=\"internalNotes\"]")
	WebElement InternalNotes;
	
	@FindBy(xpath ="//*[@id=\"variable\"]")
	WebElement Variable;
	
	@FindBy(xpath ="//*[@id=\"carrier\"]")
	WebElement Carrier;
	
	@FindBy(xpath ="//*[@id=\"smallestOrder\"]")
	WebElement SmallestOrder;
	
	@FindBy(xpath ="//*[@id=\"hidden\"]")
	WebElement Hidden;
	
	@FindBy(xpath ="//*[text()=\"Save Item\"]")
	WebElement SaveItem;
	
	@FindBy(xpath ="//*[contains(text(),\"Selling Prices\")]//following-sibling::div//button")
	WebElement AddSellingPrice;	
	
	public WebElement Quantity(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[1]//input"));
    }
	
	public WebElement Cost(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[2]//input"));
    }
	
	public WebElement PricesNotes(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[3]//input"));
    }
	
	public WebElement PricesHidden(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[4]//input"));
    }
	
	
	public WebElement btnDelete(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr["+num+"]/td[5]/button"));
    }
	
	public void ClkAddSellingPrice() {
		
		AddSellingPrice.click();
		log.info("Clicked add selling price");
    }
	
	public void ClkSaveItem() {
		
		SaveItem.click();
		log.info("Clicked Save item");
    }
	
	public void DeleteSellingprices() {
		
		int sellcount = driver.findElements(By.xpath("//*[@class=\"table w-full border\"]/tbody/tr")).size();
		
		for(int i=1;i<=sellcount;i++) {
			
			if(i>2) {
				
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", this.btnDelete("1"));
				log.info("Clicked Delete Item Button");
				
			}
			
		}
    }
	
	public  void Item(String Name,String AlName,String NuWidth,String NuHeight,String ClientName,String Finishingname,
			String ColorName,String SideName,String SubstrateName,String NuLeadTime,String Notesde,String InternalNotesde,
			String SmallestOrderName,String VariableName,String CarrierName,String bolHidden) throws InterruptedException
	{
			
			Thread.sleep(7000);
			
			ItemName.clear();
			ItemName.sendKeys(Name);
			log.info("Entered the Item Name: "+Name);
			
			AlternateName.clear();
			AlternateName.sendKeys(AlName);
			log.info("Entered the Alternate Name: "+AlName);
			
			Width.clear();
			Width.sendKeys(NuWidth);
			log.info("Entered the Width: "+NuWidth);
			
			Height.clear();
			Height.sendKeys(NuHeight);
			log.info("Entered the Height: "+NuHeight);
			
			Thread.sleep(7000);
			
			Select lstclient = new Select(Client);  
			lstclient.selectByVisibleText(ClientName);
			log.info("Selected the Client: "+ClientName);
			
			Select lstFinishing = new Select(Finishing);  
			lstFinishing.selectByVisibleText(Finishingname);
			log.info("Seleted the Finishing: "+Finishingname);

			Select lstColor = new Select(Color);  
			lstColor.selectByVisibleText(ColorName);
			log.info("Selected the Color Name: "+ColorName);
			
			Select lstSide = new Select(Side);  
			lstSide.selectByVisibleText(SideName);
			log.info("Selected the Side Name: "+SideName);

			Select lstSubstrate = new Select(Substrate);  
			lstSubstrate.selectByVisibleText(SubstrateName);
			log.info("Selected the Substrate Name: "+SubstrateName);
			
			LeadTime.clear();
			LeadTime.sendKeys(NuLeadTime);
			log.info("Entered the LeadTime: "+NuLeadTime);
			
			Notes.clear();
			Notes.sendKeys(Notesde);
			log.info("Entered the Notes: "+Notesde);
			
			InternalNotes.clear();
			InternalNotes.sendKeys(InternalNotesde);
			log.info("Entered the Internal Notes: "+InternalNotesde);
			
			SmallestOrder.clear();
			SmallestOrder.sendKeys(SmallestOrderName);
			log.info("Entered the Smallest Order Number: "+SmallestOrderName);
			
			Variable.clear();
			Variable.sendKeys(VariableName);
			log.info("Entered the Variable: "+VariableName);
			
			Carrier.clear();
			Carrier.sendKeys(CarrierName);
			log.info("Entered the Carrier Name: "+CarrierName);
			
			if(bolHidden.equals("Yes")&&Hidden.isSelected()==false) {
				Hidden.click();
				log.info("Check the Hidden");
				
			}else if(!bolHidden.equals("Yes")&&Hidden.isSelected()==true){
				
				Hidden.click();
				log.info("UnCheck the Hidden");
			}
		
	}
	
	public void SellingPrices(String num,String NuQuantity,String NuCost,String Notesdetails,String Hiddendetails,String Deletecon) {
		
		this.Quantity(num).clear();
		this.Quantity(num).sendKeys(NuQuantity);
		log.info("Entered the Quantity Name: "+NuQuantity);
		
		this.Cost(num).clear();
		this.Cost(num).sendKeys(NuCost);
		log.info("Entered the Cost: "+NuCost);
		
		this.PricesNotes(num).clear();
		this.PricesNotes(num).sendKeys(Notesdetails);
		log.info("Entered the Notes details: "+Notesdetails);
		
		if(Hiddendetails.equals("Yes")&&PricesHidden(num).isSelected()==false) {
			PricesHidden(num).click();
			log.info("Check the Prices Hidden");
			
		}else if(!Hiddendetails.equals("Yes")&&PricesHidden(num).isSelected()==true){
			PricesHidden(num).click();
			log.info("UnCheck the Prices Hidden");
		}
		
		if(Deletecon.equals("Yes")) {
			btnDelete(num).click();
			log.info("clicked Delete button");
			
		}
		
		
	}
}
