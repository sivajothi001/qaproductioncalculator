package Test_Cases;

import java.net.Inet4Address;
import java.net.UnknownHostException;

import org.testng.annotations.Test;

public class uuuuu {
	
	
	@Test
	public void test123() throws UnknownHostException
	{
		
		//String ToRow = ctx.getCurrentXmlTest().getParameter("row");
		
		String aaa = "http://"+Inet4Address.getLocalHost().getHostAddress()+":4444/wd/hub";
			
		System.out.println(aaa);
		
		
	}

}
