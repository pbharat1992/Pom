package com.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class HomePage extends TestBase 
{
	@FindBy(xpath = "//td[contains(text(),'User: bharat kumar panuganti')]")
	WebElement userNameLabel;

    @FindBy(xpath="//a[contains(text(),'no company loaded')]")
    WebElement noCompanyLoaded;   
	
	@FindBy(xpath = "//a[contains(text(),'«Shortlist')]")
	WebElement shortList;

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

	@FindBy(xpath="//a[contains(text(),'Setup')]")
	WebElement setUpLink;
	
	@FindBy(xpath="//a[contains(text(),'Help')]")
	WebElement helpLink;
	
	@FindBy(xpath="//a[contains(text(),'Logout')]")
	WebElement logOutLink;
	
	@FindBy(xpath="//a[contains(text(),'Add Boxes»')]")
	WebElement addboxesLink;
	
	@FindBy(xpath="//a[contains(text(),'Knowledge Base')]")
	WebElement knowledgebaseLink;
	
	@FindBy(xpath="//a[contains(text(),'Timeline')]")
	WebElement timelineLink;
	
	
	
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
	
	public ShortListPage  clickOnShortListLink() {
     shortList.click();
	return new ShortListPage();	
       
		}
	public void nocompanyloaded() throws InterruptedException  {
		noCompanyLoaded.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		String WindowId=it.next();
		System.out.println("Window Id is::--"+WindowId);
		driver.switchTo().window(WindowId);
		Thread.sleep(2000);
		System.out.println("Window popup title is :---" + driver.getTitle());
		driver.close();
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
   
   public void crmdropdown() {
	   Select select=new Select(driver.findElement(By.name("search_target")));
	   List <WebElement> elementCount = select.getOptions();
	int iSize = elementCount.size();
		
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println(sValue);
   }
	  }
   
   public void setUpandHelpandLogoutLinks() throws InterruptedException {
	   setUpLink.click();
	   Thread.sleep(2000);
       helpLink.click();
//       try {
//		Thread.sleep(2000);
//	} catch (Exception e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//       Set<String> handler = driver.getWindowHandles();
//		Iterator<String> it = handler.iterator();
//		String WindowId=it.next();
//		System.out.println("Window Id is::--"+WindowId);
//		driver.switchTo().window(WindowId);
//		Thread.sleep(2000);
//		System.out.println("Window popup title is :---" + driver.getTitle());
//		driver.close();
       Thread.sleep(2000);
       logOutLink.click();
   }
   
   
   
   
   public void addboxes() throws InterruptedException {
	   addboxesLink.click();
	   Thread.sleep(2000);
	   Select select=new Select(driver.findElement(By.name("box_id")));
	   List <WebElement> elementCount = select.getOptions();
	int iSize = elementCount.size();
		
		for(int i =0; i<iSize ; i++){
			String sValue = elementCount.get(i).getText();
			System.out.println(sValue);
   }
		
		
			
		}
   public void knowledgebaseLink() throws InterruptedException {
	   knowledgebaseLink.click();
	  driver.findElement(By.xpath("//a[contains(text(),'Root')]")).click();
       
   }
   
   public void ClickOnTimeLineLink() throws InterruptedException {
	   timelineLink.click();
	   driver.findElement(By.xpath("//img[contains(@id,'f_trigger_c_date_from')]")).click();
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//img[contains(@id,'btnClear')]")).click();
	  
   }
   
   public void ClickOnSearchButton() {
	   driver.findElement(By.xpath("//parent::div[@class='noprint']//input[@type='image']")).click();
	   
   }

   public void ClickOnSymbolLink() {
	   driver.findElement(By.xpath("//a[contains(text(),'»»')]")).click();
   }
   
   public void ClickOnQuestionMarkSymbol() throws InterruptedException {
	   
	   driver.findElement(By.xpath("//a[contains(text(),'Alerts')]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@type='button' and @value='?']")).click();
   }
}
