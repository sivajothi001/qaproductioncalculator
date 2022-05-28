package Test_Cases;

import java.io.File;
import java.net.Inet4Address;
import java.net.UnknownHostException;
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
	public void test123() throws UnknownHostException
	{
		
		//String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		String aaa = "http://"+Inet4Address.getLocalHost().getHostAddress()+":4444/wd/hub";
			
		System.out.println(aaa);
		
		
	}
	
	}
	



