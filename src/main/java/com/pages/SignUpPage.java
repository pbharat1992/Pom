package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class SignUpPage extends TestBase{
	
	
	
	@FindBy(name="first_name")
	WebElement firstname;
	
	@FindBy(name="surname")
	WebElement lastname;
	
	@FindBy(name="email")
	WebElement emailid;
	
	@FindBy(name="email_confirm")
	WebElement confirmemailid;
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="passwordconfirm")
	WebElement confirmpwd;
	
	@FindBy(name="agreeTerms")
	WebElement agreeTerms;
	
	@FindBy(name="company_name")
	WebElement companyName;
	
	@FindBy(name="phone")
	WebElement phoneNum;
	
	
//	@FindBy(xpath = "//a[contains(text(),'terms and conditions')]")
//	WebElement termsandConditions;
	
	@FindBy(name="submitButton")
	WebElement submitButton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public SignUpPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifySignUpPageTitle(){
		return driver.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	
	public void createNewAccount(String paymentplanid,String ftName, String ltName, String emailad
			,String confirmEmailad,String un,String pd
			,String confirmpd,String compName,String phoneNumb)throws IOException{
		Select select = new Select(driver.findElement(By.name("payment_plan_id")));
		select.selectByVisibleText(paymentplanid);
		
		firstname.sendKeys(ftName);
		lastname.sendKeys(ltName);
		emailid.sendKeys(emailad);
		confirmemailid.sendKeys(confirmEmailad);
		username.sendKeys(un);
		password.sendKeys(pd);
		confirmpwd.sendKeys(confirmpd);
		if(agreeTerms.isSelected()) {
			System.out.println("agree Terms Check box is already selected");
			}
		else {
		agreeTerms.click();
		}
		if(submitButton.isEnabled()) {
			submitButton.click();
		}
		else {
			System.out.println("Submit button is not enabled");
		
		}
	companyName.sendKeys(compName);
	phoneNum.sendKeys(phoneNumb);
	}


	
}