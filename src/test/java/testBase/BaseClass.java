package testBase;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.aeonbits.owner.ConfigFactory;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import testUtilities.Environment;


public class BaseClass {
	
	public static WebDriver driver;
	
	public static Logger log;
	
	Environment testEnvironment;
		
	@BeforeSuite
	@Parameters({"browser","environment"})
	public void setup(String Browser,String environemnt) throws MalformedURLException {
		
       ConfigFactory.setProperty("env", environemnt);
        
        testEnvironment = ConfigFactory.create(Environment.class);

		log = Logger.getLogger("Production Calculator");
		
		PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/resources/log4j.properties");;
		
		if(Browser.equals("chrome")) {
			
			Map<String, Object> prefs = new HashMap<String, Object>();
	         
			prefs.put("download.default_directory",System.getProperty("user.dir") +"/Data_Files/");
			 
			ChromeOptions options = new ChromeOptions();
			
		    options.setExperimentalOption("prefs", prefs);
			 
			log.info("Launching Chrome Browser");
						
			//WebDriverManager.chromedriver().setup();
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"/drivers/chromedriver");  
			
		     driver = new RemoteWebDriver(         

		            new URL("http://127.0.0.1:9515"),         

		            new ChromeOptions()); 
			
			//driver =new ChromeDriver(options);
			
			log.info("Launched Chrome Browser");
			
		}
		else if(Browser.equals("Firefox")) {
			
			WebDriverManager.firefoxdriver().setup();
			
			driver = new FirefoxDriver(); 
			log.info("Launched Firefox Browser");
			
		}
		
		else if(Browser.equals("IE")) {
			
			WebDriverManager.iedriver().setup();
			
			driver =new InternetExplorerDriver();
			log.info("Launched IE Browser");
			
			
		}
		
		else if (Browser.equals("Safari")) {
			
			WebDriverManager.safaridriver().setup();
			
			driver =new SafariDriver();
			log.info("Launched Safari Browser");
		}
		
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		driver.manage().window().maximize();
		log.info("Browser maximized");
		
		driver.get(testEnvironment.URL());
		log.info("Get the URL");

	}

	
	@AfterSuite
	
	public void tearDown() {
		
		//driver.quit();
		
	}
	
	@BeforeTest
	
	public void delay() throws InterruptedException {
		
		Thread.sleep(5000);
		
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

}



