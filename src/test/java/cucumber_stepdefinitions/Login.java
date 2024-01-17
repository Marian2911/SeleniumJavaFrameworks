package cucumber_stepdefinitions;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects_group_1.AccountPage;
import pageobjects_group_1.LandingPage;
import pageobjects_group_1.LoginPage;
import resources.Base;

public class Login extends Base{

	
	// variabile globale.
	public WebDriver driver; 
	LandingPage landingPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
	
    @After
    public void closure() {
    	driver.quit();
    }
	
	
	
	
	@Given("Open any Browser")
	public void open_any_browser() throws IOException {
		driver = initializeDriver();  
	}

	@Given("Navigate to Login page")
	public void navigate_to_login_page() {
		
		// accesam fisierul "data.properties" pentru a accesa url-ul dorit.
		driver.get(prop.getProperty("url"));                         
		
		// cream obj pentru a accesa elementele de pe aceasta pagina.
		landingPage = new LandingPage(driver);           
		landingPage.myAccountDropdown().click();                     // Clicked on My Account dropdown
		landingPage.loginOption().click();                           // Clicked on login option	
	}

	@When("User enters username as {string} and password as {string} into the fields")
	public void user_enters_username_as_and_password_as_into_the_fields(String email, String password) {
		
		// cream obj pentru a accesa elementele de pe aceasta pagina.
	    loginPage = new LoginPage(driver);                 
		loginPage.emailAdressField().sendKeys(email);                // Email addressed got entered 
		loginPage.passwordField().sendKeys(password);                // Password got entered
	}

	@When("User clicks on Login button")
	public void user_clicks_on_login_button() {
		loginPage.loginButton().click();                             // Clicked on Login Button
	}

	@Then("Verify user is able to successfully login")
	public void verify_user_is_able_to_successfully_login() {

		// cream obj pentru a accesa elementele de pe aceasta pagina. 
    	accountPage = new AccountPage(driver);
    	Assert.assertTrue(accountPage.editAccountInformationOption().isDisplayed());
	}
	
	
	
	
	
	
}
