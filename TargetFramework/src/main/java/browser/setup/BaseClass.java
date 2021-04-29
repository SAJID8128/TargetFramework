package browser.setup;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
public WebDriver driver;
	
	@BeforeTest
	public void setup() throws IOException {
		
		String path = "/Users/nyla/eclipse-workspace/TargetFramework/config.properties";
		Properties configPath = ReadConfigFile.readConfigFile(path);
		
		// Reading data from the file
		String configBrowser = configPath.getProperty("browser");
		String configEnvironment = configPath.getProperty("environment");
		String configUrl = configPath.getProperty("url");
		
		if(configBrowser.equals("chrome") && configEnvironment.equals("qa")) {
			WebDriverManager.chromedriver().setup(); 
			driver = new ChromeDriver(); 
			driver.get(configUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		}else if(configBrowser.equals("firefox") && configEnvironment.equals("qa")) {
			WebDriverManager.firefoxdriver().setup(); 
			driver = new FirefoxDriver(); 
			driver.get(configUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		}else if(configBrowser.equals("ie") && configEnvironment.equals("qa")) {
			WebDriverManager.iedriver().setup(); 
			driver = new InternetExplorerDriver(); 
			driver.get(configUrl);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		}else {
			System.out.println("Invalid data!");
		}			
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
