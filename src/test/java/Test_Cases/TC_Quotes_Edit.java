package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_Quotes_Create;
import Object_Repository.Page_Quotes_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Quotes_Edit extends BaseClass{
	
	
	@Test(dataProvider = "EditQuotesData", dataProviderClass = CustomDataProvider.class)
	
	public void EditQuotes(String ClientName,String QuoteName, String JobNumbers,String ProjectManagers,String exQuoteName) throws InterruptedException, ParseException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_Quotes_List lst =new Page_Quotes_List(driver);
		
		Page_Quotes_Create quote =new Page_Quotes_Create(driver);
		
		log.info("LOG:INFO - To Start Edit Quotes Functionality");
		
		menu.clickQuotes();
		
		lst.clkEditQuote(exQuoteName);
		log.info("LOG:INFO - To Click Edit Quote " +exQuoteName);
		
		log.info("LOG:INFO - To Start to Update the Quote form");
		
		quote.EditQuote(ClientName, QuoteName,  JobNumbers, ProjectManagers);
		
		log.info("LOG:INFO - To Completed Update to Quote form");
	
		
		log.info("LOG:INFO - To Validate Quote Updation Notification");
		
		//status.statusvalidate("Quote Created");
		
		log.info("LOG:INFO - To Successfully Completed Quotes Update Functionality ");
		
		
	}

}
