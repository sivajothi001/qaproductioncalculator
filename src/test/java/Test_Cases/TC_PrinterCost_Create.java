package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_PrinterCost_Create;
import Object_Repository.Page_PrinterCost_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;
import testUtilities.XLUtility;

public class TC_PrinterCost_Create extends BaseClass{
	
		@Test(dataProvider = "CreatePrintersCostData", dataProviderClass = CustomDataProvider.class)
		
		public void CreatePrinterCost(String PrinterName,String ItemName,String SheetName) throws InterruptedException, ParseException {
		
			Page_LeftMenu menu =new Page_LeftMenu(driver);
			
			Page_StatusofText status = new Page_StatusofText(driver);
			
			Page_PrinterCost_Create prcost =new Page_PrinterCost_Create(driver);
			
			Page_PrinterCost_List lst =new Page_PrinterCost_List(driver);
			
			log.info("LOG:INFO - Create Printer Cost functionality started");
			
			menu.clickPrinterCosts();
			log.info("LOG:INFO - To Click Printer Cost Menu Button");
			
			Thread.sleep(4000);
			
			lst.clkCreatePrinterCost();
			log.info("LOG:INFO - To Click Create Printer Cost Button");
			
			log.info("LOG:INFO - To fill The Create Printer Cost form");
			prcost.CreatePrinterCost(PrinterName,ItemName);
			log.info("LOG:INFO - To Complete Create Printer Cost form");
			
			Object[][] excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx",SheetName);
			
			log.info("LOG:INFO - To Start to fill the Printer Price ");
			for(int i=1;i<=excelFiles.length;i++) {

				prcost.ClkaddPrinterCost(i);
				
				prcost.PrinterCost(Integer.toString(i), excelFiles[i-1][0].toString(), excelFiles[i-1][1].toString(), excelFiles[i-1][2].toString(), excelFiles[i-1][3].toString());
			}
			
			log.info("LOG:INFO - Complete to fill the Printer Price");
			
			prcost.ClkSavePrinterCost();
			log.info("LOG:INFO - To clicked Save Printer Cost Button");
			
			log.info("LOG:INFO - To Validate Create Printer Cost Notification");
			status.statusvalidate("Printer Cost Created");
			
			log.info("LOG:INFO - Start to Validate Create Printer Cost List");
			lst.ValidatePrintercost(PrinterName, ItemName,SheetName);
			
			log.info("LOG:INFO - Successfully Complete the Create Printer Cost Functionality");
	}
}
