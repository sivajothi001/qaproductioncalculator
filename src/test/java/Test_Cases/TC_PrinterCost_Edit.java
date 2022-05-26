package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_PrinterCostUpdates;
import Object_Repository.Page_PrinterCost_Create;
import Object_Repository.Page_PrinterCost_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;
import testUtilities.XLUtility;

public class TC_PrinterCost_Edit extends BaseClass{
	
	
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
		
		log.info("LOG:INFO - To Click Edit Printer Cost button");
		lst.clkEditPrinterCost(PrinterName, ItemName);
		
		log.info("LOG:INFO - Start to fill the Update Printer Cost Form");
		prcost.CreatePrinterCost(PrinterName, ItemName);
		
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
		
		Thread.sleep(5000);
		
		log.info("LOG:INFO - To Validate Update printer cost Notification ");
		//status.statusvalidate("Printer Cost Created");
		
		log.info("LOG:INFO - Start To validate Update Printer Cost list ");
		lst.ValidatePrintercost(PrinterName, ItemName,"EditPrinterCostsList");
		
		log.info("LOG:INFO - Start To validate Update Printer Cost list Page ");
		cost.ValidatePrinterCostUpdates(PrinterName,ItemName);
		log.info("LOG:INFO - Validate Complete the Printer Cost Update Page  ");
		
		log.info("LOG:INFO - Successfully completed the Update Printer Cost Functionality");
	}

}
