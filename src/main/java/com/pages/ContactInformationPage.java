package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.base.TestBase;

public class ContactInformationPage extends TestBase {
	

	
	@FindBy(xpath = "//fieldset//legend[text()='Contact Information']")
	WebElement contactInfoHeader;
	
	
	@FindBy(id = "first_name")
	WebElement firstName;
	
	@FindBy(id = "surname")
	WebElement lastName;
	
	@FindBy(id = "image_file")
	WebElement fileUpload;
	
	
	@FindBy(name= "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public ContactInformationPage() {
	
		PageFactory.initElements(driver, this);
	}

	
public  boolean verifycontactInfoPageLabel() {
	
			return contactInfoHeader.isDisplayed();
		
	 
	
}

	
	public void createnewContact(String title, String ftName,String ltName, String comp){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		fileUpload.sendKeys("C:\\Users\\DELL\\Downloads\\DSC_0357.JPG");
		company.sendKeys(comp);
		saveBtn.click();
	}
	
	
	

}


