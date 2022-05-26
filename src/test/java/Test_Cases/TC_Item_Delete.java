package Test_Cases;

import org.testng.annotations.Test;

import Object_Repository.Page_Item_List;
import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Item_Delete extends BaseClass{
	
	
	@Test(dataProvider = "DeleteItemData", dataProviderClass = CustomDataProvider.class)
	
	public void DeleteItem(String Name) throws InterruptedException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_Item_List lst =new Page_Item_List(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		log.info("LOG:INFO - To Start Item Delete Functionality");
		
		menu.clickItems();
		
		log.info("LOG:INFO - To Click Item Delete Button "+Name);
		
		lst.ItemsDelete(Name);
		
		log.info("LOG:INFO - To Start to Validate Item Creation Notification");
		
		status.statusvalidate("Item Deleted");
		
		log.info("LOG:INFO - To Successfully Completed Item Creation Functionality ");
	}

}
