package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_Quotes_Create;
import Object_Repository.Page_Quotes_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Quotes_Create extends BaseClass{
	
	
	
	@Test(dataProvider = "CreateQuotesData", dataProviderClass = CustomDataProvider.class)
	
	public void CreateQuotes(String ClientName,String QuoteName, String JobNumbers,String ProjectManagers) throws InterruptedException, ParseException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_Quotes_List lst =new Page_Quotes_List(driver);
		
		Page_Quotes_Create quote =new Page_Quotes_Create(driver);
		
		log.info("LOG:INFO - Create Quotes Functionality Started");
		
		menu.clickQuotes();
		
		log.info("LOG:INFO - To Click Create Quote Button");
		
		lst.clkCreateQuote();
		
		log.info("LOG:INFO - Start to fill create Quote form");
		
		quote.CreateQuote(ClientName, QuoteName, JobNumbers, ProjectManagers);
		
		log.info("LOG:INFO - Completed the Create Quote fill form ");
		
		log.info("LOG:INFO - To Validate Quote Creation Notification");
		
		Thread.sleep(2500);
		
		status.statusvalidate("Quote Created");
		
		log.info("LOG:INFO - To Successfully Completed Quotes Creation Functionality ");
		
	}

}
