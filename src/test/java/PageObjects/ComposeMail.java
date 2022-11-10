package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ComposeMail {

	WebDriver lDriver;
	public ComposeMail(WebDriver rdriver) {
		lDriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//ul[@class=\"rd_flr_list\"]/child::li[@class=\"rd_write\"]")
	WebElement writemail;
	
	@FindBy(xpath = "//input[@id=\"TO_IDcmp2\"]")
	WebElement tomail;
	
	@FindBy(xpath = "//label[@class=\"lbl\"]/following-sibling::input")
	WebElement subject;
	
	@FindBy(xpath = "//body[@class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]")
	WebElement mailbody;
	
	@FindBy(xpath = "//a[@class=\"send_ng_compo rd_btn_cmp_send\"]")
	WebElement sendmail;
	
	@FindBy(xpath = "//div[@id=\"rdNotify\"]")
	WebElement mailsuccessmsg;
	
	@FindBy(xpath = "//span[@class=\"rd_tab_close_ic\"]")
	WebElement crossicon;
	
	public void clickWriteMail() {
		writemail.click();
	}
	
	public void enterMail(String mail) {
		tomail.sendKeys(mail);
		tomail.sendKeys(Keys.RETURN);
		tomail.sendKeys(Keys.TAB);
	}
	
	public void enterSubject(String mailsubject) {
		subject.sendKeys(mailsubject);
		subject.sendKeys(Keys.TAB);
	}
	
	public void enterMailBody(String body) {
		lDriver.switchTo().frame(1);
		mailbody.sendKeys(body);
	}
	
	public void sendMail() {
		sendmail.click();
	}
	
	public void closeNewmailTab() {
		crossicon.click();
	}
}
