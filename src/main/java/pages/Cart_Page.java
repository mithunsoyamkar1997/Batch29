package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class Cart_Page extends TestBase
{
  //Object Repository
	@FindBy(xpath="//span[text()='Your Cart']") private WebElement CartLable;
	@FindBy(xpath="//button[@id='continue-shopping']") private WebElement ContinueShoppingBtn;
	@FindBy(xpath="//button[@id='checkout']") private WebElement CheckOutBtn;
	
	public Cart_Page()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCartPageUrl()
	{
		return driver.getCurrentUrl();
	}
	public String verifyCartPageLable()
	{
		return CartLable.getText();
	}
	public String verifyContinueShoppingBtn()
	{
		ContinueShoppingBtn.click();
		return driver.getCurrentUrl();	
	}
	public String ClickOnCheckOutBtn()
	{
		CheckOutBtn.click();
		return driver.getCurrentUrl();
	}
}
