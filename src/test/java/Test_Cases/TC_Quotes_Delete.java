package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_Quotes_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Quotes_Delete extends BaseClass{
	
	@Test(dataProvider = "DeleteQuotesData", dataProviderClass = CustomDataProvider.class)
	
	public void DeleteQuotes(String QuoteName) throws InterruptedException, ParseException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_Quotes_List lst =new Page_Quotes_List(driver);
		
		log.info("LOG:INFO - Delete Quotes functionality started");
		
		menu.clickQuotes();
		log.info("LOG:INFO - To Click Quotes Menu Button");
		
		Thread.sleep(3000);
		
		lst.clkDeleteQuote(QuoteName);
		log.info("LOG:INFO - To Click Quotes Delete Button");
		
		log.info("LOG:INFO - To validate Quotes delete functionality started");
		
		status.statusvalidate("Quote Deleted");
		
		log.info("LOG:INFO - Successfully delete the Quotesfunctionality Completed");
		
	}

}
