package pageobjects_group_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	
	// variabila globala "driver" de tip "WebDriver"
	WebDriver driver;                                  

	
	// constructorul clasei (pentru a folosii "driver" si din afara clasei)
	public LandingPage(WebDriver driver) {
//		super();                                  // "super()" se refera la clasa parinte.   
		this.driver = driver;                     // "this" inseamna ca initializeaza objects in aceasta clasa (adica "this" se refera la aceasta clasa).
		PageFactory.initElements(driver,this);                                          
	}
	
	
	
	// gasirea elementelor de pe pagina.
	@FindBy(linkText="My Account")
	private WebElement myAccountDropdown;                  // click pe buton "My Account".
	
	@FindBy(linkText="Login") 
	private WebElement loginOption;                        // click pe buton "Login".
	
	
	// metode pentru gasirea elementelor de pe pagina.
	public WebElement myAccountDropdown() {
		return myAccountDropdown;
	}
	
	public WebElement loginOption() {
		return loginOption;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
