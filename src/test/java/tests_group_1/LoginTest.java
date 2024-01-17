package tests_group_1;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects_group_1.AccountPage;
import pageobjects_group_1.LandingPage;
import pageobjects_group_1.LoginPage;
import resources.Base;

public class LoginTest extends Base {

	
	public WebDriver driver; // variabila globala "driver" de tip "WebDriver".
	Logger log;       // import from "import org.apache.logging.log4j.Logger;".
	
	
	// utile pentru testare.
	@BeforeMethod
	public void browserOpen() throws InterruptedException, IOException {
		log = LogManager.getLogger(LoginTest.class.getName());       // creare object "log" de tip "Logger" (import from "import org.apache.logging.log4j.LogManager;") pentru mesaje de informare.
		
		driver = initializeDriver();                                 // accesam fisierul "data.properties" pentru a initializa driverul.
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));                         // accesam fisierul "data.properties" pentru a accesa url-ul dorit.
		log.debug("Navigated to application URL");
	}
	
	@AfterMethod
	public void closure() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = { 
//				{ "arun.selenium5@gmail.com", "Second@123", "Successfull" },
//				{ "dummy@test@.com", "dummy", "Failure" } };
				{ "arun.selenium5@gmail.com", "Second@123", "Successfull" }};      // un singur set de Credentiale pentru "email" si "password". 
		return data;
	}

	
	
	
	
	// METODE PENTRU TESTARE
	@Test(dataProvider = "getLoginData")                             // folosim "DataProvider" pentru a introduce datele de logare.
	public void login(String email, String password, String expectedResult) {
		System.out.println("login");
		
		LandingPage landingPage = new LandingPage(driver);           // cream obj pentru a accesa elementele de pe aceasta pagina.
		landingPage.myAccountDropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginOption().click();
		log.debug("Clicked on login option");
		
		LoginPage loginPage = new LoginPage(driver);                 // cream obj pentru a accesa elementele de pe aceasta pagina.
		loginPage.emailAdressField().sendKeys(email);
		log.debug("Email addressed got entered");
		loginPage.passwordField().sendKeys(password);
		log.debug("Password got entered");
		loginPage.loginButton().click();
		log.debug("Clicked on Login Button");
		
		AccountPage accountPage = new AccountPage(driver);          // cream obj pentru a accesa elementele de pe aceasta pagina.     
		String acutualResult = null;
		try {
			if (accountPage.editAccountInformationOption().isDisplayed()) {
				 log.debug("User got logged in");
				acutualResult = "Successfull";                      // "Successfull" trebuie sa fie la fel ca in metoda "getLoginData()" din "DataProvider".
			}
		} catch (Exception e) {
			log.debug("User didn't log in");
			acutualResult = "Failure";                              // "Failure" trebuie sa fie la fel ca in metoda "getLoginData()" din "DataProvider".
			Assert.fail(acutualResult);
		}
//		Assert.assertEquals(acutualResult, expectedResult);
//		log.info("Login Test got passed");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
