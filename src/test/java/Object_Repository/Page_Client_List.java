package Object_Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.BaseClass;

public class Page_Client_List extends BaseClass{
	
	WebDriver driver;
	
	public Page_Client_List(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getname(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']"));
    }
	
	public WebElement getmail(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//following-sibling::p"));
    }
	
	public WebElement getgreeting(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//parent::td//following-sibling::td[1]"));
    }
	
	public WebElement getsalestax(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//parent::td//following-sibling::td[2]"));
    }
	
	public WebElement getpricingmodel(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//parent::td//following-sibling::td[3]/span"));
    }
	
	public WebElement getcreateddate(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//parent::td//following-sibling::td[4]"));
    }
	
	public WebElement getupdateddate(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//parent::td//following-sibling::td[5]"));
    }
	
	public WebElement CilentDelete(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//parent::td//following-sibling::td[6]//*[contains(text(),'Delete')]"));
    }
	
	public WebElement CilentEdit(String Cilentname){
		
		return driver.findElement(By.xpath("//*[contains(@class,\"min-w-full\")]//tr//p[1][text()='"+Cilentname+"']//parent::td//following-sibling::td[6]//*[contains(text(),'Edit')]"));
    }
	
	@FindBy(xpath ="//button[text()=\"Delete\"]")
	WebElement btndeleteconfirm;
	
	public void clkCilentEdit(String Cilentname) {
		
		this.CilentEdit(Cilentname).click();
	}
	
	public void clkCilentDelete(String Cilentname) {
		
		this.CilentDelete(Cilentname).click();
		
		btndeleteconfirm.click();
	}
	
	
	public void validateCilentlist(String Name,String AccountManagerEmail,String Greeting,String Salestax,String linearpricing,String createdate,String updatedate) throws ParseException { 
		
		String actname= this.getname(Name).getText();
		log.info("LOG:INFO - To Get name " +actname);
		
		String actmail= this.getmail(Name).getText();
		log.info("LOG:INFO - To Get mail " +actmail);
		
		String actgreeting= this.getgreeting(Name).getText();
		log.info("LOG:INFO - To Get greeting " +actgreeting);
		
		String actsalestax= this.getsalestax(Name).getText();
		log.info("LOG:INFO - To Get salestax " +actsalestax);
		
		String actpricingmodel = this.getpricingmodel(Name).getText();
		log.info("LOG:INFO - To Get pricingmodel " +actpricingmodel);
		
		String actcreateddate= this.getcreateddate(Name).getText();
		log.info("LOG:INFO - To Get created date " +actcreateddate);
		
		String actupdateddate= this.getupdateddate(Name).getText();
		log.info("LOG:INFO - To Get updated date " +actupdateddate);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		Date actcreateddate1=dateFormat.parse(actcreateddate);  
		
		Date actupdateddate1=dateFormat.parse(actupdateddate); 
		
		Date updatedate1=dateFormat.parse(updatedate);
		
		Assert.assertEquals(Name,actname);
		log.info("LOG:INFO - To Compare Name " +Name+" and "+actname);
		
		Assert.assertEquals(AccountManagerEmail,actmail);
		log.info("LOG:INFO - To Compare Account Manager Email " +AccountManagerEmail+" and "+actmail);
		
		Assert.assertEquals(Greeting,actgreeting);
		log.info("LOG:INFO - To Compare Greeting " +Greeting+" and "+actgreeting);
		
		Float litersOfPetrol=Float.parseFloat(actsalestax.replace("%", ""));
		
		Float litersOfPetrol1=Float.parseFloat(Salestax);
		
		Assert.assertEquals(litersOfPetrol1,litersOfPetrol);
		log.info("LOG:INFO - To Compare Salestax " +litersOfPetrol+" and "+litersOfPetrol1);
		
		if(linearpricing.equals("Yes")) {
			
			Assert.assertEquals("Linear Pricing",actpricingmodel);
			
		}else {
			Assert.assertEquals("Non-linear Pricing",actpricingmodel);
		}
		
		if(createdate.length()!=0) {
			
			Date createdate1=dateFormat.parse(createdate); 
			
			if(actcreateddate1.compareTo(createdate1)<=5 && actcreateddate1.compareTo(createdate1)>=-5) {
				
				log.info("Create date matched");
			}else {
				log.error("Create date does nto matched");
			}
			
		}
		
		if(actupdateddate1.compareTo(updatedate1)<=5 && actupdateddate1.compareTo(updatedate1)>=-5) {
			log.info("update date matched");
		}else {
			log.error("update date does nto matched");
		}
	}
	

}
