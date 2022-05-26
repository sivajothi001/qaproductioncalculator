package Test_Cases;


import java.text.ParseException;

import org.testng.annotations.Test;
import Keywords.DateTimeUtil;
import Object_Repository.Page_Client_List;
import Object_Repository.Page_Client_Create;
import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Client_Create extends BaseClass {
	
	@Test(dataProvider = "CreateClientData", dataProviderClass = CustomDataProvider.class)
	
	public void CreateCilents(String Name,String AccountManagerEmail,String Greeting,String Salestax,String linearpricing,String ShowItemRequests) throws ParseException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_Client_Create cli = new Page_Client_Create(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_Client_List lst =new Page_Client_List(driver);
		
		log.info("LOG:INFO - Create Client functionality started");
		
		menu.clickClients();
		
		log.info("LOG:INFO - Click the Client button");
		
		cli.clkbtncreateclient();
		
		log.info("LOG:INFO - Click the Create Client button");
		
		cli.CreateCilent(Name, AccountManagerEmail, Greeting, Salestax, linearpricing, ShowItemRequests);
		
		log.info("LOG:INFO - To Client Create Submitted");
		
		log.info("LOG:INFO - To validate the Notification Message");
	
		status.statusvalidate("Client Created");
		
		log.info("LOG:INFO - To Successfully validate the Notification Message");
		
		String currenttime = DateTimeUtil.getCurrentDateTime("Europe/London", "yyyy-MM-dd HH:mm:ss");
		
		log.info("LOG:INFO - Start Validate the Client List");
		
		lst.validateCilentlist(Name, AccountManagerEmail, Greeting, Salestax, linearpricing, currenttime, currenttime);
		
		log.info("LOG:INFO - Successfully Completed to Validate the Client List");

	}

}
