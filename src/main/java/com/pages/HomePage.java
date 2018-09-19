package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//td[contains(text(),'User: bharat kumar panuganti')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Deal')]")
	WebElement newDealLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	// Initializing the Page Objects:
	public HomePage() {
		 PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink(){
	   contactsLink.click();
	return new ContactsPage();
		}
	
	public DealsPage clickOnDealsLink(){
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
   public ContactInformationPage clickOnNewContact() throws InterruptedException{
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		  try {
					Thread.sleep(2000);
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		  newContactLink.click();
		
		return new ContactInformationPage();
	}
	
   
   public DealsInformationPage clickOnNewDeal() {
	   Actions action=new Actions(driver);
	   action.moveToElement(dealsLink).build().perform();
	   try {
		Thread.sleep(2000);
		   
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	   newDealLink.click();
	   return new DealsInformationPage();
   }
	
		
}
