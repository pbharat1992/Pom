package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class DealsInformationPage extends TestBase {
	

	@FindBy(xpath = "//fieldset//legend[text()='Deal']")
	WebElement dealInfoHeader;
	
	@FindBy(xpath="//*[@id=\"prospectForm\"]/table/tbody/tr[2]/td[1]/table/tbody/tr[1]/td[2]/input")
	WebElement dealNo;
	
	@FindBy(name = "title")
	WebElement dealTitle;
	
	@FindBy(name= "client_lookup")
	WebElement company;
	
	@FindBy(name= "amount")
	WebElement amount;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	public DealsInformationPage() {
		PageFactory.initElements(driver,this);
	}


	public boolean verifydealInfoPageLabel() {
		return dealInfoHeader.isDisplayed();
		
	}
	 
	public boolean verifydealNo() {
		return dealNo.isDisplayed();
	}
	
	public void createnewDeal(String dealtitle, String dealcomp,String dealamount){
		dealTitle.sendKeys(dealtitle);
		company.sendKeys(dealcomp);
		amount.sendKeys(dealamount);
		saveBtn.click();
	}
	

}
