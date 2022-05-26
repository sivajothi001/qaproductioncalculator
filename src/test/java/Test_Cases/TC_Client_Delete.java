package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Object_Repository.Page_Client_List;
import Object_Repository.Page_Item_List;
import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Client_Delete extends BaseClass{
	
		@Test(dataProvider = "DeleteClientData", dataProviderClass = CustomDataProvider.class)
			
		public void DeleteClient(String Name) throws ParseException {
			
			Page_LeftMenu menu =new Page_LeftMenu(driver);
			
			Page_Client_List lst =new Page_Client_List(driver);
			
			Page_StatusofText status = new Page_StatusofText(driver);
			
			log.info("LOG:INFO - To Click Client button");
			
			menu.clickClients();
			
			log.info("LOG:INFO - To Click Client Delete Button " +Name);
			
			lst.clkCilentDelete(Name);
			
			log.info("LOG:INFO - To validate Client delete functionality started");
			
			status.statusvalidate("Client Deleted");
			
			log.info("LOG:INFO - Successfully delete the Client functionality Completed");
				
		}
}
