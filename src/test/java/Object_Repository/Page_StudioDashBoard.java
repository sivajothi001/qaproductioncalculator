package Object_Repository;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Page_StudioDashBoard {
	
	
	WebDriver driver;
	
	public Page_StudioDashBoard(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath ="//button/*[contains(text(),'Launch Production-Calculator-QA')]")
	WebElement btnProductionCalculatorQA;
	
	
	public void clickProductionCalculatorQA() {
		
		btnProductionCalculatorQA.click();
		
	}
	
	public Boolean isProductionCalculatorQAExists() {

		return btnProductionCalculatorQA.isDisplayed();

	}

}
