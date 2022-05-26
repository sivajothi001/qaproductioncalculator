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

public class TC_Client_Edit extends BaseClass {
	
	
	@Test(dataProvider = "EditClientData", dataProviderClass = CustomDataProvider.class)
	
	public void EditCilents(String Name,String AccountManagerEmail,String Greeting,String Salestax,String linearpricing,String ShowItemRequests,String fromcilent) throws ParseException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_Client_Create cli = new Page_Client_Create(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_Client_List status1 = new Page_Client_List(driver);
		
		log.info("LOG:INFO - To Click Client button");
		
		menu.clickClients();
		
		log.info("LOG:INFO - To Click edit Client button " +fromcilent);
		
		status1.clkCilentEdit(fromcilent);
		
		log.info("LOG:INFO - To Start to Update the Client Data's");
		
		cli.CreateCilent(Name, AccountManagerEmail, Greeting, Salestax, linearpricing, ShowItemRequests);
		
		log.info("LOG:INFO - Complete the Update Client Data");
		
		log.info("LOG:INFO - To validate the Notification Message");
	
		status.statusvalidate("Client Updated");
		
		log.info("LOG:INFO - To Successfully validate the Notification Message");
		
		String currenttime = DateTimeUtil.getCurrentDateTime("Europe/London", "yyyy-MM-dd HH:mm:ss");
		
		log.info("LOG:INFO - Start Validate the Client List");
		
		status1.validateCilentlist(Name, AccountManagerEmail, Greeting, Salestax, linearpricing, "", currenttime);
		
		log.info("LOG:INFO - Successfully Completed to Validate the Client List");
	}
	

}
