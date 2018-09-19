package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement lastname;
	
	@FindBy(name="cs_company_name")
	WebElement companyname;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn2;
	
	
	
	// Initializing the Page Objects:
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
//	public void selectContactsByName(String name){
//		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
//				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
//	}
	
	
}
