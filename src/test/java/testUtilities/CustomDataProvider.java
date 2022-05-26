package testUtilities;


import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.xml.XmlTest;

public class CustomDataProvider {
	
	@DataProvider(name = "loginDataExcel")
	
	public static Object[][] getLoginDataWithExcel(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","Login");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "CreateClientData")
	
	public static Object[][] getCreateCilentData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","Cilents");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "EditClientData")
	
	public static Object[][] getEditCilentData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditCilents");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "DeleteClientData")
	
	public static Object[][] getDeleteCilentData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","DeleteCilents");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "CreateItemData")
	
	public static Object[][] getCreateIteamData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","CreateItem");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "EditItemData")
	
	public static Object[][] getEditIteamData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditItem");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "DeleteItemData")
	
	public static Object[][] getDeleteIteamData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","DeleteItem");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "CreatePrintersData")
	
	public static Object[][] getCreatePrintersData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","CreatePrinter");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "EditPrintersData")
	
	public static Object[][] getEditPrintersData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditPrinters");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "DeletePrintersData")
	
	public static Object[][] getDeletePrintersData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","DeletePrinter");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "CreatePrintersCostData")
	
	public static Object[][] getCreatePrintersCostData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","CreatePrintersCost");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "EditPrintersCostData")
	
	public static Object[][] getEditPrintersCostData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","EditPrintersCost");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "DeletePrintersCostData")
	
	public static Object[][] getDeletePrintersCostData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","DeletePrintersCost");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "CreateQuotesData")
	
	public static Object[][] getCreateQuotesData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","Quotes_Create");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "EditQuotesData")
	
	public static Object[][] getEditQuotesData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","Quotes_Edit");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "CostComparison")
	
	public static Object[][] getCostComparisonData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","CostComparison");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	@DataProvider(name = "DeleteQuotesData")
	
	public static Object[][] getDeleteQuotesData(ITestContext ctx)
	{
		Object[][] excelFiles = null ;
		
		String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","Quotes_Delete");
			
		return filterData(excelFiles, ToRow);
		
	}
	
	private static Object[][] filterData1(Object[][] data, XmlTest xmlTest) {
		
        int rowFromJVM = Integer.parseInt(System.getProperty("row", "-1"));
        if (rowFromJVM > 0 && rowFromJVM < data.length) {
            return new Object[][] {
                data[rowFromJVM]
            };
        }
        int row = - 1;

        if (xmlTest.getAllParameters().containsKey("row")) {
            row = Integer.parseInt(xmlTest.getParameter("row"));
        }
        if (row > 0 && row < data.length) {
            return new Object[][] {
                data[row]
            };
        }
        return data;
    }
	
	private static Object[][] filterData(Object[][] data, String rows) {
      
        if(rows.isEmpty()!=true) {
        	
        	int row = Integer.parseInt(rows);
        	
        	  if (row >= 0 && row < data.length) {
                  return new Object[][] {
                      data[row]
                  };
              }
        	  
        	  
        } else if(rows.contains("-")) {
        	
        	String rowsnumber [] = rows.split("-");
        	
        	int fromrow = Integer.parseInt(rowsnumber[0]);
        	
        	int torow = Integer.parseInt(rowsnumber[1]);
        	
        	for(int i=fromrow;torow<=data.length;i++)
    		{ 
        		data=(Object[][]) data[i];
    		}
        }
      
        return data;
    }
	
	
	
}

