package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	// variabile globale
	WebDriver driver = null;
	public Properties prop;
	
	
	
	// metoda pentru initializarea driver-ului.
	@SuppressWarnings("deprecation")
	public WebDriver initializeDriver() throws IOException {

		// logica pentru a citi date din fisierul "data.properties".
		prop = new Properties();
		String propertiesPath = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties";      // calea relativa catre fisierul "data.properties".
		FileInputStream fis = new FileInputStream(propertiesPath);
		prop.load(fis);
		
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}
	
	
	// metoda pentru realizarea de capturi de ecran pentru teste eșuate (Taking screenshots for failing Tests). 
	public String takeScreenshot(String testName,WebDriver driver) throws IOException {
		
		File SourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destinationFilePath = System.getProperty("user.dir")+"\\screenshots\\"+testName+".png";     // calea catre folder-ul "screenshots". 
		FileUtils.copyFile(SourceFile,new File(destinationFilePath));
		
		return destinationFilePath;  //linie de cod pentru adăugarea capturii de ecran la ExtentReports (in corpul metodei "takeScreenshot()", "void" devine "String").
	}

	
	
	
	
	
	
}
