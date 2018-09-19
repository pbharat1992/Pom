package com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.base.TestBase;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	//String sheetName = "contacts";
	
	   
	public ContactsPageTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame();
		//contactsPage=homePage.clickOnContactsLink();
		
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
//	@Test(priority=2)
//	public void selectSingleContactsTest(){
//		contactsPage.selectContactsByName("test2 test2");
//	}
//	
//	@Test(priority=3)
//	public void selectMultipleContactsTest(){
//		contactsPage.selectContactsByName("test2 test2");
//		contactsPage.selectContactsByName("ui uiii");
//
//	}
	
//	@DataProvider
//	public Object[][] getCRMTestData(){
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//	}
//	
//	
//	@Test(priority=4, dataProvider="getCRMTestData")
//	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
//		homePage.clickOnNewContact();
//		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
//		contactsPage.createNewContact(title, firstName, lastName, company);
//		
//	}

	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
