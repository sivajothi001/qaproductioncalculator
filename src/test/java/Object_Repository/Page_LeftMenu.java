package Object_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_LeftMenu {
	
	WebDriver driver;
	
	public Page_LeftMenu(WebDriver driver)
	{
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Dashboard']")
	WebElement DashBoard;
	
	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Quotes']")
	WebElement Quotes;
	
	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Items']")
	WebElement Items;
	
	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Printers']")
	WebElement Printers;
	
	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Printer Costs']")
	WebElement PrinterCosts;
	
	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Cost Updates']")
	WebElement CostUpdates;
	
	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Clients']")
	WebElement Clients;
	
	@FindBy(xpath = "//*[contains(text(),'Menu')]//following-sibling::div//*[text()='Cost Comparison']")
	WebElement CostComparison;
	
	
	public void clickDashBoard() {
		
		DashBoard.click();
		
	}
	public void clickQuotes() {
		
		Quotes.click();
		
	}
	
	public void clickItems() {
		
		Items.click();
		
	}
	public void clickPrinters() {
		
		Printers.click();
		
	}
	
	public void clickPrinterCosts() {
		
		PrinterCosts.click();
		
	}
	public void clickCostUpdates() {
		
		CostUpdates.click();
		
	}
	
	public void clickClients() {
		
		Clients.click();
		
	}
	
	public void clickCostComparison() {
		
		CostComparison.click();
		
	}

}
