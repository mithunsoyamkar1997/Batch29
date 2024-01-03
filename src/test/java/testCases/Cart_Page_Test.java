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
import pages.Cart_Page;
import pages.Login_Page;
import pages.inventory_Page;
import utility.ReadData;
import utility.Screenshot;

public class Cart_Page_Test extends TestBase
{
	Login_Page login;
	inventory_Page invent;
	Cart_Page cart;
	@BeforeMethod (alwaysRun = true)
  public void Setup() throws IOException, InterruptedException
  {
	  initialization();
	  login=new Login_Page();
	  invent=new inventory_Page();
	  cart=new Cart_Page();
	  login.LoginToApplication();
	  invent.add6Product(); 
	  invent.ClickOnCartIcon();
	 
	  //without selecting product we can go to cart page
	  //but here we want to do some validation
	  //that means those products which we add in cart page. that products need to be shown in cart page also
	  //that why we take selecting product as prequisites to see products are added or not
	   
	}
	
	@Test(enabled=true,groups= {"Retesting"})
	public void verifyCartPageUrlTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readexcel(0, 7); //https://www.saucedemo.com/cart.html (0, 7)
		String actUrl=cart.verifyCartPageUrl();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Visibility of Cart Page URL="+actUrl);
		
	}
	@Test(enabled=true,groups= {"Sanity"})
	public void verifyCartPageLableTest() throws EncryptedDocumentException, IOException
	{
		String expTitle=ReadData.readexcel(0, 8); //Your Cart (0,8)
		String actTitle=cart.verifyCartPageLable();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Visibility of Cart Page Title="+actTitle);
	}
	@Test(enabled=true,groups= {"Sanity"})
	public void verifyContinueShoppingBtnTest() throws EncryptedDocumentException, IOException
	{
		String expUrl=ReadData.readexcel(0, 2);//https://www.saucedemo.com/inventory.html (0, 2)
		String actUrl=cart.verifyContinueShoppingBtn();
		Assert.assertEquals(expUrl, actUrl);
		Reporter.log("Visibility of inventory page="+actUrl);
	}
	@Test(enabled=true,groups= {"Regression"})
   public void verifyClickOnCheckOutBtnTest() throws EncryptedDocumentException, IOException
   {
	   String expUrl=ReadData.readexcel(3, 2); //https://www.saucedemo.com/checkout-step-one.html (3, 2)
	   String actUrl=cart.ClickOnCheckOutBtn();
	   Assert.assertEquals(expUrl, actUrl);
	   Reporter.log("Visibility of checkout step one page"+actUrl);
   }

	@AfterMethod (alwaysRun = true)
	public void closeBrowser(ITestResult IT) throws IOException
	{
		if(IT.FAILURE==IT.getStatus())
		{
			Screenshot.screenshot(IT.getName());
		}
		driver.close();
	}
}
