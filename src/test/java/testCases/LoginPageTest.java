package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login_Page;
import utility.ReadData;
import utility.Screenshot;

public class LoginPageTest extends TestBase
{
	Login_Page login;
	
	@BeforeMethod (alwaysRun = true)
 public void setup() throws IOException, InterruptedException
 {
		 initialization();
	 login=new Login_Page();
	 
 }
	@Test(enabled=true,priority=2,groups= {"Sanity","Regression"},invocationCount = 4)
	public void LoginToApplicationTest() throws IOException   //if we want execute only one methad then click on Run
	{
		String expUrl=ReadData.readexcel(0, 2); //https://www.saucedemo.com/inventory.html (0, 2)
		String actUrl=login.LoginToApplication();
		Assert.assertEquals(actUrl, expUrl);
		Reporter.log("After Login Inventory Page Should be come ="+actUrl);
	}
   @Test(enabled=true,groups= {"Sanity"})//here we does not provide prority to check default priority os 0 or not //@Test=(dependsOnMethad="LoginToApplicationTest")
 public void verifyUrlOfApplicationTest() throws EncryptedDocumentException, IOException
 {
	   String expectedUrl=ReadData.readexcel(0, 0); //https://www.saucedemo.com/ (0, 0)
	String actualUrl=login.verifyUrlOfApplication();
	Assert.assertEquals(actualUrl, expectedUrl);
	Reporter.log("visibility of application Url="+actualUrl);
 }
   @Test(enabled=true,priority=1,groups= {"Retesting"})//@Test=(dependsOnMethad="LoginToApplicationTest")
   public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
   {
	   String expectedTitle=ReadData.readexcel(0, 1);   //Swag Labs (0, 1)
	 String actualTitle= login.verifyTitleOfApplication();
	 Assert.assertEquals(actualTitle, expectedTitle);
	 Reporter.log("visibility of application Title"+actualTitle);
   }
	
	
   
   @AfterMethod (alwaysRun = true)
   public void closebrowser(ITestResult IT) throws IOException
   {
	   if(IT.FAILURE==IT.getStatus())
	   {
		   Screenshot.screenshot(IT.getName());
	   }
	   driver.close();
   }
   
}
