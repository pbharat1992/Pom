package com.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.SignUpPage;
import com.util.TestUtil;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	SignUpPage signUpPage;
	
	TestUtil testUtil;
	public LoginPageTest(){
		super();
	}
	Logger log = Logger.getLogger(LoginPageTest.class);	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		//log = Logger.getLogger(LoginTest.class);
				log.info("******** Starting LoginPage Class Test Cases ***************");
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		signUpPage=new SignUpPage();
		driver.get(prop.getProperty("url"));
		log.info("url is launched -- "+ prop.getProperty("url"));
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		log.info("Test - loginPageTitleTest - starting");
		String title = loginPage.validateLoginPageTitle();
		System.out.println("login page title is: "+ title);
		Assert.assertEquals(title, "#1 Free CRM software in the cloud for sales and service");
		log.info("Test - loginPageTitleTest -- ended");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateCRMImage();
		Assert.assertTrue(flag);
		
	}
@Test(priority=3)
public void verifyclickOnSignUpLinkTest()
{
	log.info("Test-FreeCrmSignUpLinkTest-starting");
	loginPage.clickonSignUpLink();
	log.info("Test - freeCrmSignUpLinkTest - ended");
}
	
	
	@Test(priority=4)
	public void loginTest(){
		log.info("Test - freeCrmLoginTest - starting");
		log.info("Username is: "+ prop.getProperty("username"));
		log.info("Password is: "+ prop.getProperty("password"));
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Test - freeCrmLoginTest - ended");
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
		log.info("Browser is closed");
	}
	
	
	
	

}
