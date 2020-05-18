package StepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import Page.AddcustomerPage;
import Page.Login;
import Page.SearchCustomerPage;
import Utilities.ExtenReportListener;
import Utilities.iTestListener_Class;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class Steps extends ExtenReportListener{


	public WebDriver driver;
	public Login lp;
	public AddcustomerPage addCust;
	public SearchCustomerPage searchCust;
	public ExtenReportListener El;
	
	public static String randomestring() {
		String str = RandomStringUtils.randomAlphabetic(5);
		return str;
	}
	@Given("^User Launch Chrome browser$")
	public void user_Launch_Chrome_browser() throws Throwable {
		
		ExtentTest loginfo = null; 
		try {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			lp = new Login(driver);
			El.test = El.extent.createTest(Feature.class,"Free CRM Login Feature");
			El.test = El.test.createNode(Scenario.class, "Free CRM Login Test Scenario");
			loginfo = El.test.createNode(new GherkinKeyword("Given"), "user_opens_the_browser");
			loginfo.pass("Browser opened");
			loginfo.info("<a href = 'E:\\Selenium\\Cucumber_Listener1\\wordDoc.doc'>please find</a>");

		}
			catch(AssertionError | Exception e) {
				El.TestHandle("FAIL",driver,loginfo,e);
			}

		
	}

	@When("^User opens URL \"([^\"]*)\"$")
	public void user_opens_URL(String url) throws Throwable {
		
		ExtentTest loginfo = null; 
		try {
			loginfo = El.test.createNode(new GherkinKeyword("Given"), "user_opens_the_browser");
			driver.get(url);
			loginfo.pass("Browser opened");
		}
			catch(AssertionError | Exception e) {
				El.TestHandle("FAIL",driver,loginfo,e);
			}
		

	}

	@When("^User enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	public void user_enters_Email_as_and_Password_as(String uname, String pwd) throws Throwable {

		ExtentTest loginfo = null; 
		try {
			loginfo = El.test.createNode(new GherkinKeyword("Given"), "user_opens_the_browser");
			lp.setUserName(uname);
			lp.setPassword(pwd);
			loginfo.pass("Browser opened");
		}
			catch(AssertionError | Exception e) {
				El.TestHandle("FAIL",driver,loginfo,e);
			}

	}

	@When("^Click on Login$")
	public void click_on_Login() throws Throwable {
		
		ExtentTest loginfo = null; 
		try {
			loginfo = El.test.createNode(new GherkinKeyword("Given"), "user_opens_the_browser");
			lp.clickLogin();
			loginfo.pass("Browser opened");
		}
			catch(AssertionError | Exception e) {
				El.TestHandle("FAIL",driver,loginfo,e);
			}
		

	}

	@Then("^Page Title should be \"([^\"]*)\"$")
	public void page_Title_should_be(String arg1) throws Throwable {
		
		ExtentTest loginfo = null; 
		try {
			loginfo = El.test.createNode(new GherkinKeyword("Given"), "user_opens_the_browser");
			System.out.println(driver.getTitle());
			loginfo.pass("Browser opened");
		}
			catch(AssertionError | Exception e) {
				El.TestHandle("FAIL",driver,loginfo,e);
			}

	}

	@When("^User click on Log out link$")
	public void user_click_on_Log_out_link() throws Throwable {
	
		ExtentTest loginfo = null; 
		try {
			loginfo = El.test.createNode(new GherkinKeyword("Given"), "user_opens_the_browser");
			Thread.sleep(3000);
			lp.clickLogout();
			loginfo.pass("Browser opened");
		}
			catch(AssertionError | Exception e) {
				El.TestHandle("FAIL",driver,loginfo,e);
			}



	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
	
		ExtentTest loginfo = null; 
		try {
			loginfo = El.test.createNode(new GherkinKeyword("Given"), "user_opens_the_browser");
			driver.close();
			loginfo.pass("Browser opened");
		}
			catch(AssertionError | Exception e) {
				El.TestHandle("FAIL",driver,loginfo,e);
			}
}
	//---------------Customer
	@Then("^User can view Dashboad$")
	public void user_can_view_Dashboad() throws Throwable {
		addCust = new AddcustomerPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("^User click on customers Menu$")
	public void user_click_on_customers_Menu() throws Throwable {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenu();
	 
	}

	@When("^click on customers Menu Item$")
	public void click_on_customers_Menu_Item() throws Throwable {
		Thread.sleep(3000);
		addCust.clickOnCustomersMenuItem();
	
	}

	@When("^click on Add new button$")
	public void click_on_Add_new_button() throws Throwable {
		Thread.sleep(3000);
		addCust.clickOnAddnew();

	}

	@Then("^User can view Add new customer page$")
	public void user_can_view_Add_new_customer_page() throws Throwable {
		Thread.sleep(3000);
		Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	
	}

	@When("^User enter customer info$")
	public void user_enter_customer_info() throws Throwable {
		Thread.sleep(3000);
		String email = randomestring()+"@gmail.com";
		addCust.setEmail(email);
		addCust.setPassword("test123");
		addCust.setCustomerRoles("Gusest");
		Thread.sleep(3000);
		addCust.setManagerOfVendor("Vendor 2");
		addCust.setFirstName("Male");
		addCust.setLastName("Kumar");
		addCust.setDob("07/08/1993");
		addCust.setCompanyName("busyQA");
		addCust.setAdminContent("This is for testing..............");
	    
	}

	@When("^click on Save button$")
	public void click_on_Save_button() throws Throwable {
		addCust.clickOnSave();
		Thread.sleep(3000);
	    
	}

	@Then("^User can view confirmation message \"([^\"]*)\"$")
	public void user_can_view_confirmation_message(String msg) throws Throwable {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(msg));
	  
	}

	@When("^Enter customer EMail$")
	public void enter_customer_EMail() throws Throwable {
		searchCust = new SearchCustomerPage(driver);
		Thread.sleep(3000);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
	    
	}

	@When("^Click on search button$")
	public void click_on_search_button() throws Throwable {
		searchCust.clickSearch();
		Thread.sleep(3000);
	    
	}

	@Then("^User should found Email in the Search table$")
	public void user_should_found_Email_in_the_Search_table() throws Throwable {
		boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	   
	}

	@When("^Enter customer FirstName$")
	public void enter_customer_FirstName() throws Throwable {
		searchCust=new SearchCustomerPage(driver);
		searchCust.setFirstName("Victoria");
	   
	}

	@When("^Enter customer LastName$")
	public void enter_customer_LastName() throws Throwable {
		searchCust.setLastName("Terces");
	  
	}

	@Then("^User should found Name in the Search table$")
	public void user_should_found_Name_in_the_Search_table() throws Throwable {
		boolean status=searchCust.searchCustomerByName("Victoria Terces");
		Assert.assertEquals(true, status);
	    
	}




}
