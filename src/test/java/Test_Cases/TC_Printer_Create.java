package Test_Cases;

import java.text.ParseException;

import org.testng.annotations.Test;

import Keywords.DateTimeUtil;
import Object_Repository.Page_LeftMenu;
import Object_Repository.Page_Printer_Create;
import Object_Repository.Page_Printer_List;
import Object_Repository.Page_StatusofText;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Printer_Create  extends BaseClass{
	
	
	@Test(dataProvider = "CreatePrintersData", dataProviderClass = CustomDataProvider.class)
	
	public void CreatePrinter(String PrinterName,String Modifiables,String PricingReportVisibles) throws InterruptedException, ParseException {
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_Printer_List lst =new Page_Printer_List(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_Printer_Create pri =new Page_Printer_Create(driver);
		
		log.info("LOG:INFO - Create Printer Functionality Started");
		
		menu.clickPrinters();
		
		lst.ClkCreatePrinters();
		log.info("LOG:INFO - Cliced Create Printers Button ");
		
		log.info("LOG:INFO - To Start to Fill Create Printers Form");
		pri.CreatePrinter(PrinterName, Modifiables, PricingReportVisibles);
		log.info("LOG:INFO - To Completed to Fill Create Printers Form");
		
		String currenttime = DateTimeUtil.getCurrentDateTime("Europe/London", "yyyy-MM-dd HH:mm:ss");
		
		Thread.sleep(2000);
		
		log.info("LOG:INFO - To Validate Create Printers Notification");
		status.statusvalidate("Printer Created");
		
		log.info("LOG:INFO - To Validate Create Printers List");
		lst.ValidatePrinters(PrinterName, Modifiables, PricingReportVisibles, currenttime, currenttime);
	
		log.info("LOG:INFO - Successfully Create Printers Functionality");
	}

}
