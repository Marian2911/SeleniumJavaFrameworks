package tests_group_2;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import resources.Base;

@SuppressWarnings("unused")
public class TwoTest extends Base {
	
	
	public WebDriver driver; // variabila globala "driver" de tip "WebDriver".
	
	
	// utile pentru testare.
	@AfterMethod
	public void closingBrowser() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	
	// METODE PENTRU TESTARE
	@Test
	public void testTwo() throws IOException, InterruptedException {
		System.out.println("TestTwo");
		
		driver = initializeDriver();                                  // accesam fisierul "data.properties" pentru a initializa driverul.
		driver.get("https://tutorialsninja.com/demo/");               // accesam fisierul "data.properties" pentru a accesa url-ul dorit.
		
//		Assert.assertTrue(false);
	}
	
	

	

	
	

}
