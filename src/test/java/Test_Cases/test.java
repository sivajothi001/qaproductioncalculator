package Test_Cases;

import java.io.File;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.util.Formatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.io.Charsets;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import testUtilities.CSVUtility;
import testUtilities.UnitPriceCalculation;
import testUtilities.XLUtility;
import testUtilities.getlatestfile;

public class test {
	

	
	@Test
	public void test123()
	{
		Object[][] excelFiles = null ;
		
		//String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		excelFiles = XLUtility.getDataFromloginSheet("Input_Data.xlsx","eeee");
			
		System.out.println("test "+excelFiles);
		
		
	}
	
	}
	



