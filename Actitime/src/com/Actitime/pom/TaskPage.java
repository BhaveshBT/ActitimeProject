package com.Actitime.pom;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Actitime.Generic.readDataFromProjectExcelFile;
import com.Actitime.Generic.readDataFromPropertyFile;

public class TaskPage<custname1> {
	
	@FindBy(xpath = "//div[.='Add New']")
	private WebElement AddnewBtn;
	
	@FindBy(xpath = "//div[.='+ New Customer']")
	private WebElement newcustomer;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Customer Name'])[2]")
	private WebElement custname;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Customer Description']")
	private WebElement description;
	
	@FindBy(xpath = "(//div[@class='dropdownButton'])[15]")
	private WebElement dropdown;

	@FindBy(xpath = "(//div[.='Our company'])[2]")
	private WebElement ourCompany;
	
	@FindBy(xpath = "//div[.='Create Customer']")
	private WebElement createcustomer;
	
	
	public TaskPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	public WebElement getCustname() {
		return custname;
	}

	public WebElement getNewcustomer() {
		return newcustomer;
	}
	
	public WebElement getAddnewBtn () {
		return AddnewBtn;
	}
	
	
	
	public WebElement getDescription() {
		return description;
	}



	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getOurCompany() {
		return ourCompany;
	}



	public WebElement getCreatecustomer() {
		return createcustomer;
	}



	public void addnew() throws EncryptedDocumentException, IOException, InterruptedException {
		readDataFromProjectExcelFile r = new readDataFromProjectExcelFile();
		String custname1 = r.readDataFromExcelFlie("Sheet1", 1, 1);
		AddnewBtn.click();
		newcustomer.click();
		custname.sendKeys(custname1);
		description.sendKeys("banking");
		dropdown.click();
		Thread.sleep(3000);
		ourCompany.click();
		createcustomer.click();
	}

	
}