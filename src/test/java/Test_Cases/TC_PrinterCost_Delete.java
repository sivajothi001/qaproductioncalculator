package Test_Cases;

import org.testng.annotations.Test;

import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_PrinterCost_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_PrinterCost_Delete extends BaseClass {
	
	
	@Test(dataProvider = "DeletePrintersCostData", dataProviderClass = CustomDataProvider.class)
	public void DeleteItem(String PrinterName,String ItemName) throws InterruptedException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_PrinterCost_List lst =new Page_PrinterCost_List(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		log.info("LOG:INFO - Delete Printer Cost functionality started");
		
		menu.clickDashBoard();
		
		log.info("LOG:INFO - To Click Printer Cost Menu Button");
		menu.clickPrinterCosts();
		
		Thread.sleep(4000);
		
		lst.clkDeletePrinterCost(PrinterName, ItemName);
		log.info("LOG:INFO - To Click Printer Cost Delete Button");
		
		log.info("LOG:INFO - To validate Printer Cost delete functionality started");
		
		status.statusvalidate("Printer Cost Deleted");
		
		log.info("LOG:INFO - Successfully delete the Printer Cost functionality Completed");
		
	}

}
