package Object_Repository;

import java.io.File;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.List;
import java.util.stream.IntStream;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import testBase.BaseClass;
import testUtilities.CSVUtility;
import testUtilities.UnitPriceCalculation;
import testUtilities.XLUtility;
import testUtilities.getlatestfile;

public class Page_Quotes_Create extends BaseClass{
	
	
	WebDriver driver;
	
	public Page_Quotes_Create(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath ="//*[@id=\"client\"]")
	WebElement Client;
	
	@FindBy(xpath ="//*[@id=\"selectedMeta\"]")
	WebElement SelectedItems;
	
	@FindBy(xpath ="//*[@class=\"flex justify-end\"]/button")
	WebElement ItemConfig;
	
	@FindBy(xpath ="//*[@class=\"space-y-8\"]//button[contains(text(),\"Next: Generate Quote\")]")
	WebElement GenerateQuote;
	
	@FindBy(xpath ="//*[@id=\"name\"]")
	WebElement Name;
	
	@FindBy(xpath ="//*[@id=\"jobNumber\"]")
	WebElement JobNumber;
	
	@FindBy(xpath ="//*[@id=\"client\"]")
	WebElement Clientlist;
	
	@FindBy(xpath ="//*[@id=\"projectManager\"]")
	WebElement ProjectManager;
	
	@FindBy(xpath ="//span[text()=\"Save Quote\"]")
	WebElement btnSaveQuote;
	
	@FindBy(xpath ="//*[@class=\"flex\"]//button[contains(text(),\"Download CSV\")]")
	WebElement btnDownloadCSV;
	
	@FindBy(xpath ="//*[contains(text(),\"Download PDF\")]")
	WebElement btnDownloadPDF;
	
	@FindBy(xpath ="//*[contains(text(),\"Quote Details\")]//parent::div//following-sibling::div/div")
	WebElement GrandTotal;
	
	
	public WebElement SelectItem(String Item){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"h-96 overflow-y-auto\")]//*[contains(text(),'"+Item+"')]"));
    }
	
	public WebElement quantity(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//parent::div//following-sibling::div//*[contains(@id,\"quantity\")]"));
    }
	
	public WebElement description(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//parent::div//following-sibling::div//*[contains(@id,\"description\")]"));
    }
	
	public WebElement part(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//parent::div//following-sibling::div//*[contains(@id,\"part\")]"));
    }
	
	public WebElement notes(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//parent::div//following-sibling::div//*[contains(@id,\"notes\")]"));
    }
	
	
	public WebElement getItemName(String num){
		
		return driver.findElement(By.xpath("//*[@class=\"bg-white divide-y divide-gray-200\"]/tr['"+num+"']//div[contains(@class,\"text-md\")]"));
    }
	
	public WebElement getQuantity(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//ancestor::td//following-sibling::td[1]"));
    }
	
	public WebElement getUnitPrice(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//ancestor::td//following-sibling::td[2]"));
    }
	
	public WebElement getTaxRate(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//ancestor::td//following-sibling::td[3]"));
    }
	
	public WebElement getSubTotal(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//ancestor::td//following-sibling::td[4]"));
    }
	
	public WebElement getTotalPrice(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//ancestor::td//following-sibling::td[5]"));
    }
	
	public WebElement getTotalTax(String Item){
		
		return driver.findElement(By.xpath("//*[text()='"+Item+"']//ancestor::td//following-sibling::td[6]"));
    }
	
	public WebElement getPrinterCost(String num){
		
		return driver.findElement(By.xpath("//*[text()=\"Test_Item_Mar10\"]//following-sibling::div//li["+num+"]/span"));
    }
	
	
	Page_Quotes_List lst =new Page_Quotes_List(driver);
	
	public void CreateQuote(String ClientName,String QuoteName, String JobNumbers,String ProjectManagers) throws InterruptedException, ParseException {
		
		if(driver.findElements(By.xpath("//*[@id=\"client\"]")).size() != 0) {
			
			//Select lstclient = new Select(Client); 
			
			//lstclient.selectByVisibleText(ClientName);
			
			log.info("LOG:INFO - To Select the Client " +ClientName);
			
		}

		Object[][] excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","QuotesItemsList");
		
		Object[][] EditCilents = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditCilents");
		
		int itemcount =excelFiles.length;
		
		for(int i=1;i<=itemcount;i++) {
			
			SelectItem(excelFiles[i-1][0].toString()).click();
			
			log.info("LOG:INFO - To Select The Items " +excelFiles[i-1][0].toString());
			
		}
		
		Select SelectedItem = new Select(SelectedItems);  
		List<WebElement> dd = SelectedItem.getOptions();
		
	    for (int j = 0; j < dd.size(); j++) {
	    	
	        String ite = dd.get(j).getText();

	    }
	    
	    
	    ItemConfig.click();
	    log.info("LOG:INFO - To Clicked Item Config Button " );
	    
	    for(int i=1;i<=itemcount;i++) {
	    	
		    quantity(excelFiles[i-1][0].toString()).clear();
		    quantity(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][1].toString());
		    log.info("LOG:INFO - To enter the quantity " +excelFiles[i-1][1].toString());
		    
		    description(excelFiles[i-1][0].toString()).clear();
		    description(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][2].toString());
		    log.info("LOG:INFO - To enter the description " +excelFiles[i-1][2].toString());
			
		    part(excelFiles[i-1][0].toString()).clear();
		    part(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][3].toString());
		    log.info("LOG:INFO - To enter the part " +excelFiles[i-1][3].toString());
		    
		    notes(excelFiles[i-1][0].toString()).clear();
		    notes(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][4].toString());
		    log.info("LOG:INFO - To enter the notes " +excelFiles[i-1][4].toString());
	    	
	    }
	    
	    GenerateQuote.click();
	    log.info("LOG:INFO - To Clicked Generate Quote Button " );
	    
	    String GrantTotal = GrandTotal.getText();
	    log.info("LOG:INFO - To get the Grant Total "+GrantTotal);
	    
	    log.info("LOG:INFO - Start to Validate Quote Details " );
	    for(int i=1;i<=itemcount;i++) {
	    	
		    ValidateQuoteDetails(excelFiles[i-1][0].toString(),excelFiles[i-1][1].toString(),EditCilents[0][3].toString());
	    	
	    }
	    log.info("LOG:INFO - Completed to Validate Quote Details " );
	    	    
	    Name.clear();
	    Name.sendKeys(QuoteName);
	    log.info("LOG:INFO - To enter the Quote Name " +QuoteName);
		
		JobNumber.clear();
		JobNumber.sendKeys(JobNumbers);
		log.info("LOG:INFO - To enter the JobNumber "+JobNumbers);
		
		if(driver.findElements(By.xpath("//*[@id=\"client\"]")).size() != 0) {
			
			Select lstsclient = new Select(Clientlist);  
			lstsclient.selectByVisibleText(ClientName);
			log.info("LOG:INFO - To Select the client name "+ClientName);
		}
		
		ProjectManager.clear();
		ProjectManager.sendKeys(ProjectManagers);
		log.info("LOG:INFO - To enter the ProjectManager "+ProjectManagers);
		
		Thread.sleep(4000);
		
		btnSaveQuote.click();
		log.info("LOG:INFO - To Click Save Quote " );
		
	}
	
	public void EditQuote(String ClientName,String QuoteName, String JobNumbers,String ProjectManagers) throws InterruptedException {

		Object[][] excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","QuotesItemsList");
		
		Object[][] EditCilents = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditCilents");
		
		int itemcount =excelFiles.length;
		
	    for(int i=1;i<=itemcount;i++) {
	    	
		    quantity(excelFiles[i-1][0].toString()).clear();
		    quantity(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][1].toString());
		    log.info("LOG:INFO - To enter the Quantity "+excelFiles[i-1][1].toString());
		    
		    description(excelFiles[i-1][0].toString()).clear();
		    description(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][2].toString());
		    log.info("LOG:INFO - To enter the Description "+excelFiles[i-1][2].toString());
			
		    part(excelFiles[i-1][0].toString()).clear();
		    part(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][3].toString());
		    log.info("LOG:INFO - To enter the Part "+excelFiles[i-1][3].toString());
		    
		    notes(excelFiles[i-1][0].toString()).clear();
		    notes(excelFiles[i-1][0].toString()).sendKeys(excelFiles[i-1][4].toString());
		    log.info("LOG:INFO - To enter the Notes "+excelFiles[i-1][4].toString());
	    	
	    }
	    
	    log.info("LOG:INFO - To Click Generate Quote ");
	    GenerateQuote.click();
	    
	    
	    String GrantTotal = GrandTotal.getText();
	    log.info("LOG:INFO - To get the Grant Total "+GrantTotal);
	    
	    log.info("LOG:INFO - Start to Validate Quote Details " );
	    for(int i=1;i<=itemcount;i++) {
	    	
		    ValidateQuoteDetails(excelFiles[i-1][0].toString(),excelFiles[i-1][1].toString(),EditCilents[0][3].toString());
	    	
	    }
	    log.info("LOG:INFO - Completed to Validate Quote Details " );
	    
	    Name.clear();
	    Name.sendKeys(QuoteName);
	    log.info("LOG:INFO - To enter the Quote Name "+QuoteName);
		
		JobNumber.clear();
		JobNumber.sendKeys(JobNumbers);
		log.info("LOG:INFO - To enter the Job Numbers "+JobNumbers);
		
		if(driver.findElements(By.xpath("//*[@id=\"client\"]")).size() != 0) {
			
			Select lstsclient = new Select(Clientlist);  
			lstsclient.selectByVisibleText(ClientName);
			log.info("LOG:INFO - To Select the Client Name "+ClientName);
		}
		
		ProjectManager.clear();
		ProjectManager.sendKeys(ProjectManagers);
		log.info("LOG:INFO - To enter the Project Managers "+ProjectManagers);
		
		Thread.sleep(4000);
		
		btnSaveQuote.click();
		log.info("LOG:INFO - To Click the SaveQuote button");
	    
	}
	
	
	public void ValidateQuoteDetails(String Item,String Quantity,String TaxRate) throws InterruptedException {

	    	String actItemName = getItemName(Item).getText();
	    	log.info("LOG:INFO - To Get Item Name " +actItemName);
	    	
	    	String actQuantity = getQuantity(Item).getText();
	    	log.info("LOG:INFO - To Get Quantity " +actQuantity);
	    	
	    	String actUnitPrice = getUnitPrice(Item).getText();
	    	log.info("LOG:INFO - To Get UnitPrice " +actUnitPrice);
	    	
	    	String actTaxRate = getTaxRate(Item).getText();
	    	log.info("LOG:INFO - To Get TaxRate " +actTaxRate);
	    	
	    	String actSubTotal = getSubTotal(Item).getText();
	    	log.info("LOG:INFO - To Get SubTotal " +actSubTotal);
	    	
	    	String actTotalPrice = getTotalPrice(Item).getText();
	    	log.info("LOG:INFO - To Get TotalPrice " +actTotalPrice);
	    	
	    	String actTotalTax = getTotalTax(Item).getText();
	    	log.info("LOG:INFO - To Get TotalTax " +actTotalTax);
	    	
	    	String UnitPrice = UnitPriceCalculation.getUintPrice(Quantity);
	    	
	    	double finSub = Double.parseDouble(Quantity.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "")) * Double.parseDouble(UnitPrice.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", ""));
	    	
	    	double tax  = Double.parseDouble(TaxRate.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "")) * finSub / 100;
	    	
	    	DecimalFormat df = new DecimalFormat("####0.00");
	    	
	    	double TotalPrice  = finSub+tax;
	    	
	    	Assert.assertEquals(actItemName,Item);
	    	log.info("LOG:INFO - To Compare Account Manager Email " +actItemName+" and "+Item);
	    	
	    	Assert.assertEquals(actQuantity.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", ""),Quantity.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", ""));
	    	log.info("LOG:INFO - To Compare Item Name " +actQuantity+" and "+Quantity);
	    	
	    	Assert.assertEquals(actUnitPrice.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").replaceFirst("\\.0+$", ""),UnitPrice.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").replaceFirst("\\.0+$", ""));
	    	log.info("LOG:INFO - To Compare Unit Price " +actUnitPrice+" and "+UnitPrice);
	    	
	    	Assert.assertEquals(actTaxRate.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", ""),df.format(Double.parseDouble(TaxRate)).replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", ""));
	    	log.info("LOG:INFO - To Compare Tax Rate " +actTaxRate+" and "+TaxRate);
	    	
	    	Assert.assertEquals(actSubTotal.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],Double.toString(finSub).replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
	    	log.info("LOG:INFO - To Compare SubTotal " +actSubTotal+" and "+finSub);
	    	
	    	Assert.assertEquals(actTotalPrice.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],Double.toString(TotalPrice).replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
	    	log.info("LOG:INFO - To Compare TotalPrice " +actTotalPrice+" and "+TotalPrice);
	    	
	    	Assert.assertEquals(actTotalTax.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],Double.toString(tax).replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
	    	log.info("LOG:INFO - To Compare TotalTax " +actTotalTax+" and "+tax);
	    	
	    	log.info("LOG:INFO - Start to Validate Download CSV file");
	    	ValidateDownloadCSV(actItemName,actQuantity,actTaxRate,actUnitPrice,actSubTotal,actTotalTax,actTotalPrice);	
	    	log.info("LOG:INFO - Complete the Vlidation Download CSV file");
	}
	
	public void ValidateDownloadCSV(String ItemName,String Quantity,String TaxRate,String UnitPrice,String SubTotal,String TotalTax,String TotalPrice) throws InterruptedException {
		
		new WebDriverWait(driver,600).until(ExpectedConditions.visibilityOf (this.btnDownloadCSV));
		
		Thread.sleep(500);
		
		log.info("LOG:INFO -  Start to Validate Download CSV file ");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", btnDownloadCSV);
		log.info("LOG:INFO - To Click DownloadCSV button ");
		
		File filename = getlatestfile.getLatestExcelFilefromDir();
		log.info("LOG:INFO - To get latest file from downladed driactory "+filename);
		
		
		List<String[]> allData = CSVUtility.readDataFromCustomSeparator(filename.toString());
		
		 for (String[] row : allData) {
			 
			 if(ItemName.equals(row[0])) {
				 
				 Assert.assertEquals(Quantity.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],row[1].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 log.info("LOG:INFO - To Compare Quantity " +Quantity+" and "+row[1].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 
				 Assert.assertEquals(UnitPrice.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],row[2].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 log.info("LOG:INFO - To Compare UnitPrice " +UnitPrice+" and "+row[2].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 
				 Assert.assertEquals(TaxRate.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],row[3].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 log.info("LOG:INFO - To Compare TaxRate " +TaxRate+" and "+row[3].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 
				 Assert.assertEquals(SubTotal.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],row[4].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 log.info("LOG:INFO - To Compare SubTotal " +SubTotal+" and "+row[4].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 
				 Assert.assertEquals(TotalTax.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],row[5].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 log.info("LOG:INFO - To Compare TotalTax " +TotalTax+" and "+row[5].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 
				 Assert.assertEquals(TotalPrice.replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0],row[6].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 log.info("LOG:INFO - To Compare TotalPrice " +TotalPrice+" and "+row[6].replaceAll("\\%|\\$|(?<=\\d),(?=\\d)", "").split("\\.")[0]);
				 
			 }
			 
		 }
	}
	
	public void ValidateDownloaPDF() {
		
		log.info("LOG:INFO - To Click Download PDF button ");
		btnDownloadPDF.click();
	}
	
	public void ValidatePrinterCosts() {
		
		int PrinterCount = driver.findElements(By.xpath("//*[text()=\"Test_Item_Mar10\"]//following-sibling::div//li")).size();
		
		for(int i=1;i<=PrinterCount;i++) {
			
			String PrinterCostDetails = getPrinterCost(Integer.toString(i)).getText();
			
			System.out.println(PrinterCostDetails);
			
		}
		
	}


}
