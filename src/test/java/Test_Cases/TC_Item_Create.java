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

public class TC_Item_Create extends BaseClass{
	
	
	@Test(dataProvider = "CreateItemData", dataProviderClass = CustomDataProvider.class)
	
	public void CreateItem(String Name,String AlName,String NuWidth,String NuHeight,String ClientName,String Finishingname,
			String ColorName,String SideName,String SubstrateName,String NuLeadTime,String Notesde,String InternalNotesde,
			String SmallestOrderName,String VariableName,String CarrierName,String bolHidden) throws ParseException, InterruptedException  {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_Item_Create item =new Page_Item_Create(driver);
		
		Page_Item_List lst =new Page_Item_List(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		log.info("LOG:INFO - Create Item Functionality Started");
		
		menu.clickItems();
		
		log.info("LOG:INFO - To Click Create Item Button");
		
		lst.ClkCreateItem();
		
		log.info("LOG:INFO - Start to fill create Item form");
		
		item.Item(Name, AlName, NuWidth, NuHeight, ClientName, Finishingname, ColorName, SideName, SubstrateName, NuLeadTime, Notesde, InternalNotesde,SmallestOrderName, VariableName, CarrierName, bolHidden);
		
		log.info("LOG:INFO - Completed the Create Item fill form ");
		
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
		
		log.info("LOG:INFO - To Successfully Saved Item Creation");
		
		String currenttime = DateTimeUtil.getCurrentDateTime("Europe/London", "yyyy-MM-dd HH:mm:ss");
		
		Thread.sleep(2000);
		
		log.info("LOG:INFO - To Validate Item Creation Notification");
		
		//status.statusvalidate("Item Created");
		
		log.info("LOG:INFO - To Start Validate item Create list");
		
		lst.validateItemlist(Name, AlName, NuWidth, NuHeight,ClientName, Finishingname, ColorName, SideName, SubstrateName, Notesde, InternalNotesde,SmallestOrderName,currenttime, currenttime);
	
		log.info("LOG:INFO - To Successfully Completed Item Creation Functionality ");
	}

}
