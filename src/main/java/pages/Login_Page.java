package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.ReadData;

public class Login_Page extends TestBase
{
	//Object Repository
	@FindBy(xpath="//input[@id='user-name']") private WebElement UserNameTextBox;
	@FindBy(xpath="//input[@id='password']") private WebElement PasswordTextBox;
	@FindBy(xpath="//input[@id='login-button']") private WebElement LoginBtn;
	
	public Login_Page()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String LoginToApplication() throws IOException
	{
		UserNameTextBox.sendKeys(ReadData.readPropertyFile("Username")); //standard_user
		PasswordTextBox.sendKeys(ReadData.readPropertyFile("Password")); //secret_sauce
		LoginBtn.click();
		return driver.getCurrentUrl();
		
	}
	//i want to used Multiple credentials for Login that's why we need to take parameter in methad 
	public String LoginToApplicationWithMultiCred(String un,String pass)
	{
		UserNameTextBox.sendKeys(un);
		PasswordTextBox.sendKeys(pass);
		LoginBtn.click();
		return driver.getCurrentUrl();
	}
   public String verifyUrlOfApplication()
   {
	 return driver.getCurrentUrl();
   }
   public String verifyTitleOfApplication()
   {
	 return driver.getTitle();
   }


}
