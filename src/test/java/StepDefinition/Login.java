package StepDefinition;

import java.io.File;
import java.io.IOException;
import org.codehaus.plexus.util.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import PageObjects.ComposeMail;
import PageObjects.Loginpage;
import Utilities.Datalayer;
import Utilities.commonUtils;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends BaseClass {

	@Before
	public void browserActivity() {
		if(System.getProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(System.getProperty("browser").equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(System.getProperty("browser").equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			System.out.println("No driver found");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	/// Validate valid login///

	@Given("User launch the brower")
	public void user_launch_the_brower() {
		loginpage = new Loginpage(driver);
		composeMail = new ComposeMail(driver);
	}

	@Given("Enter app url and hit enter")
	public void enter_app_url_and_hit_enter() {
		driver.get(System.getProperty("appurl"));
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
		System.out.println("quit browser");
	}
	
	@After
	public void tearDown(Scenario sc) {
		if(sc.isFailed()== true) {
			TakesScreenshot screenshot= ((TakesScreenshot)driver);
			File srcfile=screenshot.getScreenshotAs(OutputType.FILE);
			File destfile=new File(System.getProperty("user.dir")+"/Screenshot/rediff_"+commonUtils.getCurrentDate() +".png");
			try {
				FileUtils.copyFile(srcfile, destfile);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		driver.quit();
	}

	/////////////// Validate invalid login credentials //////////////////

	@Given("Enter invalid username as {string} and password as {string}")
	public void enter_invalid_username_as_and_password_as(String username, String password) {
		loginpage.enterUsername(username);
		loginpage.enterPassword(password);
	}

	@Then("Validate validation message")
	public void validate_validation_message() {
		String actualmsg = loginpage.getValidationMsg();
		String expectedValMsg= Datalayer.getData(0, 0, 1);
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
	
    /////////////// Validate compose mail and send test //////////////////
	
	@Then("Validate popup validation message")
	public void validate_popup_validation_message() {
	   String alertmessage= loginpage.getAlertmsg();
	   Assert.assertEquals("Please enter a valid user name", alertmessage);
	}

	@Then("Close the popup")
	public void close_the_popup() {
	   loginpage.closeAlert();
	}
	
}
