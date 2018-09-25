package com.pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.base.TestBase;

public class ShortListPage extends TestBase{
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td")
	WebElement shortlistLabel;
	
	@FindBy(xpath = "//input[@type='submit' and @value=' = SUBMIT = ']")
	WebElement submitBtn;
	
	
	public ShortListPage() {
		 PageFactory.initElements(driver, this);
	}
	public boolean verifyshortlistLabel(){
		return shortlistLabel.isDisplayed();
	}

	public ShortListPage selectDropDown() {
	Select oSelect = new Select(driver.findElement(By.name("doaction")));
	List <WebElement> elementCount = oSelect.getOptions();
	int iSize = elementCount.size();
	
	for(int i =0; i<iSize ; i++){
		String sValue = elementCount.get(i).getText();
		System.out.println(sValue);
		}
		
//		Select select = new Select(driver.findElement(By.className("select")));
//
//		select.selectByValue("LOAD");
		submitBtn.click();
	
return new ShortListPage();
}
	//html/body/table[1]/tbody/tr[2]/td/select

	
}

	

