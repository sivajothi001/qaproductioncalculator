package Test_Cases;

import org.testng.annotations.Test;

import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_Printer_List;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Printer_Delete  extends BaseClass{
	
	
	@Test(dataProvider = "DeletePrintersData", dataProviderClass = CustomDataProvider.class)
		
		public void DeleteItem(String PrinterName) throws InterruptedException {
		
		
			Page_LeftMenu menu =new Page_LeftMenu(driver);
			
			Page_Printer_List lst =new Page_Printer_List(driver);
			
			log.info("LOG:INFO - Delete Printer Functionality Started");
			
			menu.clickPrinters();
			log.info("LOG:INFO - Clicked Printer Menu Button");
			
			log.info("LOG:INFO - To Click Delete Printer Button " +PrinterName);
			lst.PrinterDelete(PrinterName);
			
			log.info("LOG:INFO - Successfully Completed Delete Printer Functionality");
	}

}
