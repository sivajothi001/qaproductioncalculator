package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Keywords.DateTimeUtil;
import Object_Repository.Page_Item_Create;
import Object_Repository.Page_Item_List;
import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;
import testUtilities.XLUtility;

public class TC_Item_Edit extends BaseClass{
	
	
	@Test(dataProvider = "EditItemData", dataProviderClass = CustomDataProvider.class)
	
	public void EditItem(String Name,String exName,String AlName,String NuWidth,String NuHeight,String ClientName,String Finishingname,
			String ColorName,String SideName,String SubstrateName,String NuLeadTime,String Notesde,String InternalNotesde,
			String SmallestOrderName,String VariableName,String CarrierName,String bolHidden) throws InterruptedException, ParseException {
		
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_Item_Create item =new Page_Item_Create(driver);
		
		Page_Item_List lst =new Page_Item_List(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		log.info("LOG:INFO - To Start Edit Item Functionality");
		
		menu.clickItems();
		
		log.info("LOG:INFO - To Click Edit Item " +exName);
		
		lst.ClkEditItem(exName);
		
		log.info("LOG:INFO - To Start to Update the Item form");
		
		item.Item(Name, AlName, NuWidth, NuHeight, ClientName, Finishingname, ColorName, SideName, SubstrateName, NuLeadTime, Notesde, InternalNotesde,SmallestOrderName, VariableName, CarrierName, bolHidden);
		
		log.info("LOG:INFO - To Completed Update to Item form");
		
		item.DeleteSellingprices();
		
		log.info("LOG:INFO - To Start to Update Item selling Prices ");
		
		Object[][] excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","SellingPrices");
		
		int num =excelFiles.length;
		
		for(int i=1;i<=num;i++) {
			
			if(i>2) {
				
				item.ClkAddSellingPrice();

			}
			
			item.SellingPrices(Integer.toString(i), excelFiles[i-1][0].toString(), excelFiles[i-1][1].toString(), excelFiles[i-1][2].toString(), excelFiles[i-1][3].toString(), excelFiles[i-1][4].toString());
		
			log.info("LOG:INFO - Add the Selling Quantity for " + excelFiles[i-1][0].toString()+" Price " +excelFiles[i-1][1].toString());
		}
		
		log.info("LOG:INFO - Completed the to fill the Selling Prices");
		
		item.ClkSaveItem();
		
		log.info("LOG:INFO - To Successfully Saved Item Updation");
		
		String currenttime = DateTimeUtil.getCurrentDateTime("Europe/London", "yyyy-MM-dd HH:mm:ss");
		
		Thread.sleep(2000);
		
		log.info("LOG:INFO - To Validate Item Updation Notification");
		
		status.statusvalidate("Item Updated");
		
		log.info("LOG:INFO - To Start Validate item Update list");
		
		lst.validateItemlist(Name, AlName, NuWidth, NuHeight,ClientName, Finishingname, ColorName, SideName, SubstrateName, Notesde, InternalNotesde,SmallestOrderName,currenttime, currenttime);
	
		log.info("LOG:INFO - To Successfully Completed Item Update Functionality ");
	}

}
