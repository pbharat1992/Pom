package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.ContactInformationPage;
import com.pages.ContactsPage;
import com.pages.DealsInformationPage;
import com.pages.DealsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	ContactInformationPage contactInformationPage;
	DealsPage dealsPage;
	DealsInformationPage dealsInformationPage;
	
	
	
	String sheetName = "contacts";
	String sheetName2 ="deals";
	

	public HomePageTest() { 
		super();
	}

	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		homePage=new HomePage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil = new TestUtil();
		testUtil.switchToFrame();
       
        
    	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	
	@Test(priority=3)
	public void verifyContactsLinkTest() throws InterruptedException{
		
		contactsPage=homePage.clickOnContactsLink();
	}
	
	@Test(priority=4)
	public void verifyContactInformationPageTest() throws InterruptedException{
	
		contactInformationPage=homePage.clickOnNewContact();
	}
	
	@Test(priority=5)
	public void verifyContactInfoPageHeader() throws InterruptedException {
		contactInformationPage=homePage.clickOnNewContact();
		
	Assert.assertTrue(contactInformationPage.verifycontactInfoPageLabel(),"contactsInfoHeader label is missing on the page");
}   
	

//	@Test(priority=7)
//	public void createnewContactTest() throws InterruptedException{
//		
//		contactInformationPage=homePage.clickOnNewContact();
//	   
//		contactInformationPage.createnewContact("DR.","Tom", "Steve", "Automation QA Engineer");
//	}
	

	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=6, dataProvider="getCRMTestData")
	public void validatecreatenewContact(String title, String firstName, String lastName, String company) throws InterruptedException{
		//testUtil.switchToFrame();
		//Thread.sleep(2000);
		
		contactInformationPage=homePage.clickOnNewContact();
	//	contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	contactInformationPage.createnewContact(title, firstName, lastName, company);
		
	}
	

	@Test(priority=7)
	public void verifyClickonDealsLink() {
		
		dealsPage=homePage.clickOnDealsLink();
	}
	
	@Test(priority=8)
	public void verifydealInfoPageHeader() {
		dealsInformationPage=homePage.clickOnNewDeal();
		Assert.assertTrue(dealsInformationPage.verifydealInfoPageLabel(),"dealInfoHeader label is missing on the page");
	}
	
//	@Test(priority=8)
//	public void createnewDealTest() throws InterruptedException{
//	
//		dealsInformationPage = homePage.clickOnNewDeal();
//		
//	   
//		dealsInformationPage.createnewDeal("DR.","Automation QA Engineer","1000");
//	}
	
	
	@DataProvider
	public Object[][] getCRMTestData1(){
		Object data[][] = TestUtil.getTestData(sheetName2);
		return data;
	}
	
	
	@Test(priority=9, dataProvider="getCRMTestData1")
	public void validatecreatenewDeal(String dealTitle, String company, String amount) throws InterruptedException{
		
		
		dealsInformationPage=homePage.clickOnNewDeal();
	//	contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
	dealsInformationPage.createnewDeal(dealTitle,company,amount);
	}	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	

}
