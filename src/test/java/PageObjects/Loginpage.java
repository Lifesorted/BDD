package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import StepDefinition.BaseClass;

public class Loginpage extends BaseClass{
	WebDriver ldriver;
	public Loginpage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@class=\"signin\"]")
	WebElement signin;
	
	@FindBy(xpath = "//input[@id=\"login1\"]")
	WebElement username;
	
	@FindBy(xpath = "//input[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath = "//input[@class=\"signinbtn\"]")
	WebElement Signbtn;
	
	@FindBy(xpath = "//div[@class=\"div_login_error\"]/child::b")
	WebElement validationmsg;

	public void enterUsername(String email) {
		username.sendKeys(email);
	}
	
	public void enterPassword(String pass) {
		password.sendKeys(pass);
	}
	
	public void clickOnSignlink() {
		signin.click();
	}
	
	public void clickOnElement() {
		Signbtn.click();
	}
	
	public String getValidationMsg() {
		String actualmsg=validationmsg.getText();
		return actualmsg;	
	}
	
	public String getAlertmsg() {
		String message= ldriver.switchTo().alert().getText();
		return message;
	}
	
	public void closeAlert() {
		ldriver.switchTo().alert().accept();
	}
}
