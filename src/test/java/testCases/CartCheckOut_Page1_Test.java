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
import pages.CartCheckOut_Page1;
import pages.Cart_Page;
import pages.Login_Page;
import pages.inventory_Page;
import utility.ReadData;
import utility.Screenshot;

public class CartCheckOut_Page1_Test extends TestBase
{
  Login_Page login;
  inventory_Page invent;
  Cart_Page cart;
  CartCheckOut_Page1 checkout1;
  @BeforeMethod
  public void Setup() throws IOException, InterruptedException
  {
	  initialization();
	  login=new Login_Page();
	  invent=new inventory_Page();
	  cart=new Cart_Page();
	  checkout1=new CartCheckOut_Page1();
	  login.LoginToApplication();
	  invent.add6Product();
	  invent.ClickOnCartIcon();
	  cart.ClickOnCheckOutBtn();
	  
  }
  @Test(enabled=true)
  public void verifyCheckOutPageUrlTest() throws EncryptedDocumentException, IOException
  {
	  String expUrl=ReadData.readexcel(3, 2); //https://www.saucedemo.com/checkout-step-one.html (3, 2)
	  String actUrl=checkout1.verifyCheckOutPageUrl();
	  Assert.assertEquals(expUrl, actUrl);
	  Reporter.log("Visibility of CheckOut Page Url"+actUrl);
  }
  @Test(enabled=true)
  public void verifyCheckOutLableTest() throws EncryptedDocumentException, IOException
  {
	  String expLable=ReadData.readexcel(3, 3);  //Checkout: Your Information (3, 3)
	  String actLable=checkout1.verifyCheckOutLable();
	  Assert.assertEquals(expLable, actLable);
	  Reporter.log("Visibility of CheckOut Lable"+actLable);
  }
  @Test(enabled=true)
  public void verifyUserInfoTest() throws EncryptedDocumentException, IOException
  {
	  String expUrl=ReadData.readexcel(3, 1); //https://www.saucedemo.com/checkout-step-two.html (3, 1);
	  String actUrl=checkout1.verifyUserInfo();
	  Assert.assertEquals(expUrl, actUrl);
	  Reporter.log("Visibility of CheckOut Page 2 Url"+actUrl);
  }
  @Test(enabled=true)
  public void verifyCancalButtonTest() throws EncryptedDocumentException, IOException
  {
	  String expUrl=ReadData.readexcel(3, 0); //https://www.saucedemo.com/cart.html (3, 0)
	  String actUrl=checkout1.verifyCancalButton();
	  Assert.assertEquals(expUrl, actUrl);
	  Reporter.log("Visibility of Cart Page Url"+actUrl);
			  
  }
  @AfterMethod
  public void closeBrowser(ITestResult IT) throws IOException
  {
	if(IT.FAILURE==IT.getStatus())
	{
		Screenshot.screenshot(IT.getName());
		driver.close();
	}
  }
}
