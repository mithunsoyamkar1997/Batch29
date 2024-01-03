package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.Login_Page;
import pages.inventory_Page;
import utility.ReadData;
import utility.Screenshot;

public class inventory_Page_Test extends TestBase
{    
	Login_Page login;
	inventory_Page invent;
	@BeforeMethod (alwaysRun = true)
    public void Setup() throws IOException, InterruptedException
    {
    	initialization();
    	 login=new Login_Page();
    	  invent=new inventory_Page();
    	  login.LoginToApplication();
    }
	@Test(enabled=true,groups= {"Retesting"})
    public void verifyProductLableTest() throws EncryptedDocumentException, IOException
    {
    	String expTitle=ReadData.readexcel(0, 3); //Products (0,3)
    	String actTitle=invent.verifyProductLable();
    	Assert.assertEquals(expTitle, actTitle);
    	Reporter.log("We get the expected Title="+actTitle);
    }
	@Test(enabled=true,groups= {"Sanity"})
    public void verifyFotterTextTest() throws EncryptedDocumentException, IOException
    {
    	String expFotterText=ReadData.readexcel(0, 4); //© 2023 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy (0, 4)
    	String actFotterText=invent.verifyFotterText();
    	Assert.assertEquals(expFotterText, actFotterText);
    	Reporter.log("we get expected text in fotter="+actFotterText);
    }
	@Test(enabled=true,groups= {"Sanity"})
    public void verifyTwitterLogoTest()
    {
    	Boolean result=invent.verifyTwitterLogo();    //we get return boolean value 'true'
    	Assert.assertEquals(result, true);           //both condition will check equal or not & if not equal then throw AssertException
    	                                             //expected='true' & actual='true'
    	Reporter.log("the Twitter Logo is displayed on the webpage="+result);
    }
	@Test(enabled=true,groups= {"Sanity"})
    public void verifyFacebookLogoTest()
    {
    	Boolean result=invent.verifyFacebookLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("the facebook logo is displayed on the webpage="+result);
    }
	@Test(enabled=true,groups= {"Sanity"})
    public void verifyLinkedInLogoTest()
    {
    	Boolean result=invent.verifyLinkedInLogo();
    	Assert.assertEquals(result, true);
    	Reporter.log("the LinkedIn Logo is displayed on the webpage="+result);
    }
	@Test(enabled=true,groups= {"Sanity","Regression"},invocationCount = 3)
    public void add6ProductTest() throws EncryptedDocumentException, IOException
    {   
    	String expCount=ReadData.readexcel(0, 5); //"6" (0, 5)
    	String actCount=invent.add6Product();
    	Assert.assertEquals(expCount, actCount);
    	Reporter.log("total numbers of Products in cart="+actCount);
    }
	@Test(enabled=true,groups= {"Sanity","Regression"})
	public void remove2ProductTest() throws EncryptedDocumentException, IOException
	{
		String expCount=ReadData.readexcel(0, 6); //"4" (0,6)
		String actCount=invent.remove2Product();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Numbers of Product after removing="+actCount);
	}
	@Test(enabled=true)
	public void ClickOnCartIconTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readexcel(3, 0); //https://www.saucedemo.com/cart.html (3,0)
		String actUrl=invent.ClickOnCartIcon();
		Assert.assertEquals(expUrl, actUrl);
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
