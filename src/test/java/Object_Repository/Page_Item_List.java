package Object_Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class Page_Item_List extends BaseClass{
	
	WebDriver driver;
	
	public Page_Item_List(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[contains(text(),\"Create Item\")]")
	WebElement btnCreateItem;
	
	public WebElement getItemname(String itemname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1][text()='"+itemname+"']"));
    }
	
	public WebElement getClientname(String itemname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1][text()='"+itemname+"']//following-sibling::td[1]"));
    }
	
	public WebElement getCreateDate(String itemname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1][text()='"+itemname+"']//following-sibling::td[2]"));
    }
	public WebElement getUpdatedDate(String itemname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1][text()='"+itemname+"']//following-sibling::td[3]"));
    }
	public WebElement ItemDetails(String itemname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1][text()='"+itemname+"']//following-sibling::td[4]//*[text()=\" Details \"]"));
    }
	public WebElement ItemEdit(String itemname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1][text()='"+itemname+"']//following-sibling::td[4]//*[text()=\" Edit \"]"));
    }
	public WebElement ItemDelete(String itemname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//td[1][text()='"+itemname+"']//following-sibling::td[4]//*[text()=\" Delete \"]"));
    }
	
	public void ClkCreateItem(){
		
		btnCreateItem.click();
		log.info("Clicked Create item button");
    }
	
	public void ClkEditItem(String itemname){
		
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", this.ItemEdit(itemname));
		log.info("Clicked Edit item button");
    }
	
	public void validateItemlist(String ItemName,String AlName,String NuWidth,String NuHeight,String ClientName,String Finishingname,
			String ColorName,String SideName,String SubstrateName,String Notesde,String InternalNotesde,
			String SmallestOrderName,String createdate,String updatedate) throws ParseException, InterruptedException {
		
		String actItemName= this.getItemname(ItemName).getText();
		log.info("LOG:INFO - To Get Item name " +actItemName);
		
		String actClientName= this.getClientname(ItemName).getText();
		log.info("LOG:INFO - To Get Client name " +actClientName);
		
		String actcreatedate= this.getCreateDate(ItemName).getText();
		log.info("LOG:INFO - To Get Create Date " +actcreatedate);
		
		String actupdatedate= this.getUpdatedDate(ItemName).getText();
		log.info("LOG:INFO - To Get Update Date " +actupdatedate);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date actcreateddate1=dateFormat.parse(actcreatedate);  
		
		Date actupdateddate1=dateFormat.parse(actupdatedate);
		
		Date createdate1=dateFormat.parse(createdate);  
		
		Date updatedate1=dateFormat.parse(updatedate);
		
		Assert.assertEquals(ItemName,actItemName);
		log.info("LOG:INFO - To Compare Item Name " +ItemName+" and "+actItemName);
		
		Assert.assertEquals(ClientName,actClientName);
		log.info("LOG:INFO - To Compare Client Name " +ClientName+" and "+actClientName);
		
		if(createdate.length()!=0) {
			
			if(actcreateddate1.compareTo(createdate1)<=5 && actcreateddate1.compareTo(createdate1)>=-5) {
				
				log.info("Item Create date matched");
			}else {
				log.error("Item Create date does nto matched");
			}
			
		}
		
		if(actupdateddate1.compareTo(updatedate1)<=5 && actupdateddate1.compareTo(updatedate1)>=-5) {
			log.info("Item update date matched");
		}else {
			log.error("Item update date does nto matched");
		}
		
		this.ValidateItemDetails(ItemName, AlName, NuWidth, NuHeight, ClientName, Finishingname, ColorName, SideName, SubstrateName, Notesde, InternalNotesde, SmallestOrderName);
	}
	
	@FindBy(xpath ="//*[contains(text(),\"Item Name\")]//following-sibling::dd")
	WebElement ItemNames;
	
	@FindBy(xpath ="//*[contains(text(),\"Alternative Name\")]//following-sibling::dd")
	WebElement AlternativeName;
	
	@FindBy(xpath ="//*[contains(text(),\"Dimensions\")]//following-sibling::dd")
	WebElement Dimensions;
	
	@FindBy(xpath ="//*[contains(text(),\"Smallest Order\")]//following-sibling::dd")
	WebElement SmallestOrder;
	
	@FindBy(xpath ="//*[contains(text(),\"Client\")]//following-sibling::dd")
	WebElement Client;
	
	@FindBy(xpath ="//*[contains(text(),\"Notes\")]//following-sibling::dd")
	WebElement Notes;
	
	@FindBy(xpath ="//*[contains(text(),\"Internal Notes\")]//following-sibling::dd")
	WebElement InternalNotes;
	
	@FindBy(xpath ="//*[contains(text(),\"Substrate\")]//following-sibling::dd")
	WebElement Substrate;
	
	@FindBy(xpath ="//*[contains(text(),\"Color\")]//following-sibling::dd")
	WebElement Color;
	
	@FindBy(xpath ="//*[contains(text(),\"Finishing\")]//following-sibling::dd")
	WebElement Finishing;
	
	@FindBy(xpath ="//*[contains(text(),\"Side\")]//following-sibling::dd")
	WebElement Side;
	
	@FindBy(xpath ="//*[contains(text(),\" Close \")]")
	WebElement btnClose;
	
	@FindBy(xpath ="//button[text()=\"Delete\"]")
	WebElement btndeleteconfirm;
	
	public WebElement Quantity(String num){
		
		return driver.findElement(By.xpath("//*[contains(text(),\"Selling Prices\")]//parent::div//following-sibling::table/tbody/tr["+num+"]/td[1]"));
    }
	public WebElement Cost(String num){
		
		return driver.findElement(By.xpath("//*[contains(text(),\"Selling Prices\")]//parent::div//following-sibling::table/tbody/tr["+num+"]/td[2]"));
    }
	public WebElement Notes(String num){
		
		return driver.findElement(By.xpath("//*[contains(text(),\"Selling Prices\")]//parent::div//following-sibling::table/tbody/tr["+num+"]/td[3]"));
    }
	
	public void ValidateItemDetails(String ItemName,String AlName,String NuWidth,String NuHeight,String ClientName,String Finishingname,
			String ColorName,String SideName,String SubstrateName,String Notesde,String InternalNotesde,
			String SmallestOrderName) throws InterruptedException {
		
		String dimensions =NuWidth+" / "+NuHeight;
		
		this.ItemDetails(ItemName).click();
		
		Thread.sleep(4000);
		
		String actItemNamne =ItemNames.getText();
		log.info("LOG:INFO - To Get Item name " +actItemNamne);
		
		String actAltername =AlternativeName.getText();
		log.info("LOG:INFO - To Get Alter name " +actAltername);
		
		String actdimensions = Dimensions.getText();
		log.info("LOG:INFO - To Get dimensions " +actdimensions);
		
		String actSmallestOrder= SmallestOrder.getText();
		log.info("LOG:INFO - To Get SmallestOrder " +actSmallestOrder);
		
		String actClient =Client.getText();
		log.info("LOG:INFO - To Get Client name " +actClient);
		
		String actNotes =Notes.getText();
		log.info("LOG:INFO - To Get Notes " +actNotes);
		
		String actInternalNotes =InternalNotes.getText();
		log.info("LOG:INFO - To Get InternalNotes " +actInternalNotes);
		
		String actSubstrate =Substrate.getText();
		log.info("LOG:INFO - To Get Substrate " +actSubstrate);
		
		String actColor= Color.getText();
		log.info("LOG:INFO - To Get Color " +actColor);
		
		String actFinishing =Finishing.getText();
		log.info("LOG:INFO - To Get Finishing " +actFinishing);
		
		String actSide = Side.getText();
		log.info("LOG:INFO - To Get Side " +actSide);
		
		Assert.assertEquals(ItemName,actItemNamne);
		log.info("LOG:INFO - To Compare Name " +ItemName+" and "+actItemNamne);
		
		Assert.assertEquals(AlName,actAltername);
		log.info("LOG:INFO - To Compare Name " +AlName+" and "+actAltername);
		
		Assert.assertEquals(dimensions,actdimensions);
		log.info("LOG:INFO - To Compare Name " +dimensions+" and "+actdimensions);
		
		Assert.assertEquals(ClientName,actClient);
		log.info("LOG:INFO - To Compare Name " +ClientName+" and "+actClient);
		
		Assert.assertEquals(Finishingname,actFinishing);
		log.info("LOG:INFO - To Compare Name " +Finishingname+" and "+actFinishing);
		
		Assert.assertEquals(ColorName,actColor);
		log.info("LOG:INFO - To Compare Name " +ColorName+" and "+actColor);
		
		Assert.assertEquals(SideName,actSide);
		log.info("LOG:INFO - To Compare Name " +SideName+" and "+actSide);
		
		Assert.assertEquals(SubstrateName,actSubstrate);
		log.info("LOG:INFO - To Compare Name " +SubstrateName+" and "+actSubstrate);
		
		Assert.assertEquals(Notesde,actNotes);
		log.info("LOG:INFO - To Compare Name " +Notesde+" and "+actNotes);
		
		Assert.assertEquals(InternalNotesde,actInternalNotes);
		log.info("LOG:INFO - To Compare Name " +InternalNotesde+" and "+actInternalNotes);
		
		Assert.assertEquals(SmallestOrderName,actSmallestOrder);
		log.info("LOG:INFO - To Compare Name " +SmallestOrderName+" and "+actSmallestOrder);
		
		btnClose.click();
		log.info("LOG:INFO - To Click Close Button" );

	}
	
	public void ItemsDelete(String ItemName) {
		
		String Editlink = this.ItemEdit(ItemName).getAttribute("href");
		
		this.ItemDelete(ItemName).click();
		
		btndeleteconfirm.click();
		
		int count = driver.findElements(By.xpath("//*[@href='"+Editlink+"']")).size();
		
		if(count>0) {
			
			log.error(ItemName+" was not deleted");
			
		}else {
			
			log.info(ItemName+" was deleted successfully");
		}
		
		
		
	}

}
