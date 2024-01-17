package pageobjects_group_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	
	// variabila globala "driver" de tip "WebDriver"
	WebDriver driver;                                  

	
	// constructorul clasei (pentru a folosii "driver" si din afara clasei)
	public AccountPage(WebDriver driver) {
//		super();                                  // "super()" se refera la clasa parinte.   
		this.driver = driver;                     // "this" inseamna ca initializeaza objects in aceasta clasa (adica "this" se refera la aceasta clasa).
		PageFactory.initElements(driver,this); 
	}
		
		
		// gasirea elementelor de pe pagina.
		@FindBy(linkText="Edit your account information")
		private WebElement editAccountInformationOption;                   // confirmare page "Account".	
		
		
		// metode pentru gasirea elementelor de pe pagina.
		public WebElement editAccountInformationOption() {
			return editAccountInformationOption;
		}
		

		
		
		
		
}
