package pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class CartCheckOut_Page1 extends TestBase
{
 //Object Repository
	@FindBy(xpath="//span[text()='Checkout: Your Information']") private WebElement CheckOutLable;
	@FindBy(xpath="//input[@id='first-name']") private WebElement FirstNameTextBox;
	@FindBy(xpath="//input[@id='last-name']") private WebElement LastNameTextBox;
	@FindBy(xpath="//input[@id='postal-code']") private WebElement PostalCodeTextBox;
	@FindBy(xpath="//button[@id='cancel']") private WebElement CancalBtn;
	@FindBy(xpath="//input[@id='continue']") private WebElement Continue;
	
	public CartCheckOut_Page1()
	{
		PageFactory.initElements(driver, this); //this keyword will refer to all webelement
	}
	public String verifyCheckOutPageUrl()
	{
		return driver.getCurrentUrl();
	}
	public String verifyCheckOutLable()
	{
		return CheckOutLable.getText();
	}
	public String verifyUserInfo() throws EncryptedDocumentException, IOException
	{   // FN,LN,Postal Code,Continue button all are interconnected like Login module
		FirstNameTextBox.sendKeys(ReadData.readexcel(1, 0));
		LastNameTextBox.sendKeys(ReadData.readexcel(1, 1));
		PostalCodeTextBox.sendKeys(ReadData.readexcel(1, 2));
		Continue.click();
		return driver.getCurrentUrl();
		
	}
	public String verifyCancalButton()
	{
		CancalBtn.click();
		return driver.getCurrentUrl();
	}
	
}
