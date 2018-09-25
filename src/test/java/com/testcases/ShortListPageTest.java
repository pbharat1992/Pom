package com.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.ContactsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ShortListPage;
import com.util.TestUtil;

public class ShortListPageTest extends TestBase {
	
	
	
	

	LoginPage loginPage;
	HomePage homePage;
	ShortListPage shortListPage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	
	
	
	   
	public ShortListPageTest(){
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
		
	}
	
	@Test(priority=1)
	public void verifyShortListPageLabel(){
		shortListPage=homePage.clickOnShortListLink();
		Assert.assertTrue(shortListPage.verifyshortlistLabel(), "shortlist label is missing on the page");
	}
	
	@Test(priority=2)
	public void verifySelectDropDown() {
	
		shortListPage=homePage.clickOnShortListLink();
	
		shortListPage.selectDropDown();
		
	}
}
