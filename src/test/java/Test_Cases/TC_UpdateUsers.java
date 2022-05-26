package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Keywords.DateTimeUtil;
import Object_Repository.Page_Client_Create;
import Object_Repository.Page_Client_List;
import Object_Repository.Page_Item_Create;
import Object_Repository.Page_Item_List;
import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_PrinterCostUpdates;
import Object_Repository.Page_PrinterCost_Create;
import Object_Repository.Page_PrinterCost_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;
import testUtilities.XLUtility;

public class TC_UpdateUsers extends BaseClass{
	
	
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
		
		cli.CreateCilent("Giant Eagle", AccountManagerEmail, Greeting, Salestax, linearpricing, ShowItemRequests);
		
		log.info("LOG:INFO - Complete the Update Client Data");
		
		log.info("LOG:INFO - To validate the Notification Message");
	
		status.statusvalidate("Client Updated");
		
		log.info("LOG:INFO - To Successfully validate the Notification Message");
		
		String currenttime = DateTimeUtil.getCurrentDateTime("Europe/London", "yyyy-MM-dd HH:mm:ss");
		
		log.info("LOG:INFO - Start Validate the Client List");
		
		status1.validateCilentlist("Giant Eagle", AccountManagerEmail, Greeting, Salestax, linearpricing, "", currenttime);
		
		log.info("LOG:INFO - Successfully Completed to Validate the Client List");
	}
	
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
		
		log.info("LOG:INFO - To Click Edit Item " +Name);
		
		lst.ClkEditItem(Name);
		
		log.info("LOG:INFO - To Start to Update the Item form");
		
		item.Item(Name, AlName, NuWidth, NuHeight, "Giant Eagle", Finishingname, ColorName, SideName, SubstrateName, NuLeadTime, Notesde, InternalNotesde,SmallestOrderName, VariableName, CarrierName, bolHidden);
		
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
		
		Thread.sleep(2000);
		
		log.info("LOG:INFO - To Validate Item Updation Notification");
		
		status.statusvalidate("Item Updated");
	
		log.info("LOG:INFO - To Successfully Completed Item Update Functionality ");
	}


	
	
	@Test(dataProvider = "EditPrintersCostData", dataProviderClass = CustomDataProvider.class)
	
	public void EditPrinterCost(String PrinterName,String ItemName,String exPrinterName,String exItemName) throws InterruptedException, ParseException {
	
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_PrinterCost_Create prcost =new Page_PrinterCost_Create(driver);
		
		Page_PrinterCost_List lst =new Page_PrinterCost_List(driver);
		
		Page_PrinterCostUpdates cost =new Page_PrinterCostUpdates(driver);
		
		log.info("LOG:INFO - Update Printer Cost functionality started");
		
		menu.clickDashBoard();
		
		log.info("LOG:INFO - To Click Printer Cost Menu Button");
		menu.clickPrinterCosts();
		
		Thread.sleep(4000);
		
		log.info("LOG:INFO - To Click Printer Cost button");
		lst.clkEditPrinterCost(exPrinterName, exItemName);
		
		log.info("LOG:INFO - Start to fill the Update Printer Cost Form");
		prcost.CreatePrinterCost("EAGLE", ItemName);
		
		Object[][] excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditPrinterCostsList");
		
		prcost.DeletePrinterprices(excelFiles.length);
		
		log.info("LOG:INFO - Start to fill the Printer Cost Updation");
		for(int i=1;i<=excelFiles.length;i++) {
				
			prcost.ClkaddPrinterCost(i);
			
			prcost.PrinterCost(Integer.toString(i), excelFiles[i-1][0].toString(), excelFiles[i-1][1].toString(), excelFiles[i-1][2].toString(), excelFiles[i-1][3].toString());
		}
		log.info("LOG:INFO - To Complete the Printer cost updation");
		
		prcost.ClkSavePrinterCost();
		log.info("LOG:INFO - To Clicked Save Printer Cost button");
		
		log.info("LOG:INFO - To Validate Update printer cost Notification ");
		//status.statusvalidate("Printer Cost Created");
		
		Thread.sleep(7000);
		
		log.info("LOG:INFO - Start To validate Update Printer Cost list ");
		lst.ValidatePrintercost("EAGLE", ItemName,"EditPrinterCostsList");
		
		log.info("LOG:INFO - Successfully completed the Update Printer Cost Functionality");
	}


	
	
}
