package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClass.libraryClass;

public class loginPage extends libraryClass {

	WebDriver driver;
	@FindBy(id = "txtUsername")
	WebElement username;
	@FindBy(id = "txtPassword")
	WebElement pwd;
	@FindBy(className = "button")
	WebElement Loginbutton;

	public loginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login(String uname, String pass) {
		username.sendKeys(uname);
		pwd.sendKeys(pass);

		Loginbutton.click();

	}

}
