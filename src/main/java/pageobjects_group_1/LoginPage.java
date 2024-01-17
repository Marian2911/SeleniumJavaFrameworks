package pageobjects_group_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	// variabila globala "driver" de tip "WebDriver"
	WebDriver driver;                                  

	
	// constructorul clasei (pentru a folosii "driver" si din afara clasei)
	public LoginPage(WebDriver driver) {
//		super();                                  // "super()" se refera la clasa parinte.   
		this.driver = driver;                     // "this" inseamna ca initializeaza objects in aceasta clasa (adica "this" se refera la aceasta clasa).
		PageFactory.initElements(driver,this); 
	}
		
		
		// gasirea elementelor de pe pagina.
		@FindBy(id="input-email")
		private WebElement emailAdressField;                   // insert email Address.
//		
		@FindBy(id="input-password") 
		private WebElement passwordField;                      // insert Password.
		
		@FindBy(css="input[type='submit']")
		private WebElement loginButton;                        // click pe buton "Login".
		
		
		// metode pentru gasirea elementelor de pe pagina.
		public WebElement emailAdressField() {
			return emailAdressField;
		}
		
		public WebElement passwordField() {
			return passwordField;
		}
		
		public WebElement loginButton() {
		return loginButton;
	}
		
		
		

		
		
		
		
		
		
		
		
		
		
	
}
