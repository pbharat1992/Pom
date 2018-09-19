package com.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;
import com.pages.SignUpPage;
import com.util.TestUtil;

public class SignUpPageTest extends TestBase{
	LoginPage  loginPage;
	SignUpPage signUpPage;
	TestUtil testUtil;
	String sheetName = "SignUp";

	public SignUpPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		testUtil = new TestUtil();
		loginPage=new LoginPage();
		signUpPage=new SignUpPage();
		
		signUpPage=loginPage.clickonSignUpLink();
}
	@Test(priority=1)
	public void verifySignUpPageTitle() {
	String signUpPageTitle=signUpPage.verifySignUpPageTitle();	
	Assert.assertEquals(signUpPageTitle,"CRMPRO - CRM Pro for customer relationship management, sales, and support"
			,"Sign Up page title not matched");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest(){
		boolean flag = signUpPage.validateCRMImage();
		Assert.assertTrue(flag); 
	}
	@DataProvider
	public Object[][] getCRMTestData(){
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	

	@Test(priority=3, dataProvider="getCRMTestData")
	public void validatecreateNewAccount(String payment_plan_id, String firstname, String lastname
			, String emailid,String confirmemailid,String username
			,String password,String confirmpwd,String companyName,String phoneNum) throws IOException{
		loginPage.clickonSignUpLink();
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		signUpPage.createNewAccount(payment_plan_id,firstname,lastname,emailid
				,confirmemailid,username,password,confirmpwd,companyName,phoneNum);
		
	}
	
	
	
//@Test(priority=3)
//	public void validatecreateNewAccount() throws IOException {
//		signUpPage=loginPage.clickonSignUpLink();
//		signUpPage.createNewAccount("Free Edition","Harish","chandra", "kumarjj9@gmail.com","kumarjj9@gmail.com"
//				,"pkumar92","P@kumar92","P@kumar92","Google");
//	}	
	
	
	@AfterMethod
	public void tearDown() {
	driver.quit();
}

	
	
}
