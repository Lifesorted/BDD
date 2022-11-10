package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObjects.ComposeMail;
import PageObjects.Loginpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	Loginpage loginpage;
	ComposeMail composeMail;
	WebDriver driver;

	/// Validate valid login///

	@Given("User launch the brower")
	public void user_launch_the_brower() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		loginpage = new Loginpage(driver);
		composeMail = new ComposeMail(driver);
	}

	@Given("Enter app url and hit enter")
	public void enter_app_url_and_hit_enter() {
		driver.get("https://www.rediff.com/");
	}

	@Given("click on sign in link")
	public void click_on_sign_in_link() {
		loginpage.clickOnSignlink();
	}

	@Given("Enter valid username as {string} and password as {string}")
	public void enter_valid_username_and_password(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
	}

	@When("Click on login button")
	public void click_on_login_button() {
		loginpage.clickOnElement();
	}

	@Then("Validate page url should contains {string}")
	public void validate_page_url_should_contains(String expectedUrlVal) {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		if (currentUrl.contains(expectedUrlVal)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	}

	/////////////// Validate invalid login credentials //////////////////

	@Given("Enter invalid username as {string} and password as {string}")
	public void enter_invalid_username_as_and_password_as(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
	}

	@Then("Validate validation message should be {string}")
	public void validate_validation_message_should_be(String expectedValMsg) {
		String actualmsg = loginpage.getValidationMsg();
		if (actualmsg.equals(expectedValMsg)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}
	
    /////////////// Validate compose mail and send test //////////////////
	
	@When("click on Write mail menu link")
	public void click_on_write_mail_menu_link() {
	   composeMail.clickWriteMail();
	}

	@When("Enter mail to send as {string}")
	public void enter_mail_to_send_as(String receivermail) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    composeMail.enterMail(receivermail);
	}

	@When("Enter subject in subject field as {string}")
	public void enter_subject_in_subject_field_as(String subject) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   composeMail.enterSubject(subject);
	}

	/*
	 * @When("Enter body of mail in body field as {string}") public void
	 * enter_body_of_mail_in_body_field_as(String bodytext) { try {
	 * Thread.sleep(3000); } catch (InterruptedException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); } composeMail.enterMailBody(bodytext); }
	 */

	@Then("Click on Send button")
	public void click_on_send_button() {
	    composeMail.sendMail();
	}
	
    /////////////// Validate compose mail and send test //////////////////
	
	@Then("Click on cross icon of new mail tab")
	public void click_on_cross_icon_of_new_mail_tab() {
	    composeMail.closeNewmailTab();
	}
	
}
