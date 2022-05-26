package Test_Cases;


import java.util.ArrayList;

import org.testng.annotations.Test;

import Object_Repository.Page_Login;
import Object_Repository.Page_StudioDashBoard;
import testBase.BaseClass;
import testUtilities.CustomDataProvider;

public class TC_Login extends BaseClass {
		
	@Test(dataProvider = "loginDataExcel", dataProviderClass = CustomDataProvider.class)

	public void Logintest(String roll,String UserName,String Password) throws InterruptedException {
		
		Page_Login lp =new Page_Login(driver);

		log.info("Login funcionality started");
		lp.loginToApplication(UserName, Password);
		log.info("Login funcionality Completed");
		
		Page_StudioDashBoard dsh = new Page_StudioDashBoard(driver);
		
		Thread.sleep(5000);
		
		log.info("verfing Dashboard Production Calculator button");
		dsh.isProductionCalculatorQAExists();
		
		dsh.clickProductionCalculatorQA();
		log.info("Clicked Production calculation button");
		
		Thread.sleep(5000);
		
		driver.switchTo().window(new ArrayList<>(driver.getWindowHandles()).get(1));
	}
}
