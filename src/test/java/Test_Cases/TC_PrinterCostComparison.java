package Test_Cases;

import org.testng.annotations.Test;
import Object_Repository.Page_CostComparesion;
import Object_Repository.Page_LeftMenu;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_PrinterCostComparison extends BaseClass{
	
	@Test(dataProvider = "CostComparison", dataProviderClass = CustomDataProvider.class)
	
	public void PrinterCostComparison(String Item,String Printer) {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_CostComparesion Compare = new Page_CostComparesion(driver);
		
		log.info("LOG:INFO - Cost Comparison functionality started");
		
		log.info("LOG:INFO - Click the Create Client button"+Item);
		
		menu.clickCostComparison();
		log.info("LOG:INFO - Click the Cost Comparison button");
		
		log.info("LOG:INFO - To Start  fill Printer Cost Comparsion");
		Compare.CheckPrinterCostComparison(Item, Printer);
		
		log.info("LOG:INFO - Successfully Completed Printer Cost Comparison");
		
	}

}
