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

public class TC_Printer_Edit  extends BaseClass{
	
	
	@Test(dataProvider = "EditPrintersData", dataProviderClass = CustomDataProvider.class)
	
	public void EditPrinter(String PrinterName,String exPrinterName,String Modifiables,String PricingReportVisibles) throws InterruptedException, ParseException {
		
		
		Page_LeftMenu menu =new Page_LeftMenu(driver);
		
		Page_Printer_List lst =new Page_Printer_List(driver);
		
		Page_StatusofText status = new Page_StatusofText(driver);
		
		Page_Printer_Create pri =new Page_Printer_Create(driver);
		
		log.info("LOG:INFO - Edit Printer Functionality Started");
		
		menu.clickPrinters();
		
		log.info("LOG:INFO - To Click Edit printer buttion "+exPrinterName);
		lst.ClkEditPrinters(exPrinterName);
		
		log.info("LOG:INFO - To Update Printer Form");
		pri.CreatePrinter(PrinterName, Modifiables, PricingReportVisibles);
		log.info("LOG:INFO - Completed to Printer Update Form");
		
		String currenttime = DateTimeUtil.getCurrentDateTime("Europe/London", "yyyy-MM-dd HH:mm:ss");
		
		Thread.sleep(2000);
		
		log.info("LOG:INFO - To Validate Create Printers Notification");
		status.statusvalidate("Printer Updated");
		
		log.info("LOG:INFO - To Validate Update Printers List");
		lst.ValidatePrinters(PrinterName, Modifiables, PricingReportVisibles, currenttime, currenttime);
		
		log.info("LOG:INFO - Successfully Update Printers Functionality");
	}

}
