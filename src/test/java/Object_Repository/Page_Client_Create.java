package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import testBase.BaseClass;

public class Page_Client_Create extends BaseClass{

	WebDriver driver;
	
	public Page_Client_Create(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath ="//*[contains(text(),'Create Client')]")
	WebElement createcilent;
	
	@FindBy(xpath = "//*[@id=\"name\"]")
	WebElement txtname;
	
	@FindBy(xpath = "//*[@id=\"accManagerEmail\"]")
	WebElement txtAccountManagerEmail;
	
	@FindBy(xpath = "//*[@id=\"greet\"]")
	WebElement txtgreeting;
	
	@FindBy(xpath = "//*[@id=\"salesTax\"]")
	WebElement txtsalestax;
	
	@FindBy(xpath = "//*[@id=\"linearPricing\"]")
	WebElement rdolinearPricing;
	
	@FindBy(xpath = "//*[@id=\"non-linearPricing\"]")
	WebElement rdonon_linearpricing;
	
	@FindBy(xpath = "//*[@id=\"showItemReq\"]")
	WebElement chkshowitemReq;
	
	@FindBy(xpath = "//*[text()=\"Save Client\"]")
	WebElement btnsave;

	@FindBy(xpath = "//*[text()=\"Back to Client List\"]")
	WebElement btnbacktoclientlist;


	
	public  void CreateCilent(String Name,String AccountManagerEmail,String Greeting,String Salestax,String linearpricing,String ShowItemRequests)
	{
		txtname.clear();
		txtname.sendKeys(Name);
		log.info("Enter the Name " +Name);
		
		txtAccountManagerEmail.clear();
		txtAccountManagerEmail.sendKeys(AccountManagerEmail);
		log.info("Enter the AccountManagerEmail " +AccountManagerEmail);
		
		txtgreeting.clear();
		txtgreeting.sendKeys(Greeting);
		log.info("Enter the greeting " +Greeting);
		
		txtsalestax.clear();
		txtsalestax.sendKeys(Salestax);
		log.info("Enter the Sales tax "+Salestax);
				
		if(linearpricing.equals("Yes")) {
			
			rdolinearPricing.click();
			log.info("Click the linearPricin radio button");
			
		}else {
			
			rdonon_linearpricing.click();
			log.info("Click the non_linearpricing radio button");
			
		}
		
		if(ShowItemRequests.equals("Yes")&&chkshowitemReq.isSelected()==false) {
			
			chkshowitemReq.click();
			log.info("Check the show item Req");
			
		}else if(!ShowItemRequests.equals("Yes")&&chkshowitemReq.isSelected()==true){
			
			chkshowitemReq.click();
			log.info("UnCheck the show item Req");
		}
		
		btnsave.click();
		log.info("Click the Submit button");
		
	}
	
	public void clkbtnbacktoclientlist() {
		btnbacktoclientlist.click();
		log.info("Clicked back to Client list button");
	}
	
	public void clkbtncreateclient() {
		createcilent.click();
		log.info("Clicked Create cilent button");
	}
}
