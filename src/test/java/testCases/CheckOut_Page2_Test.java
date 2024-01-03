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
import pages.CheckOut_Page2;
import pages.Login_Page;
import pages.inventory_Page;
import utility.ReadData;
import utility.Screenshot;

public class CheckOut_Page2_Test extends TestBase
{
	Login_Page login;
	  inventory_Page invent;
	  Cart_Page cart;
	  CartCheckOut_Page1 checkout1;
	  CheckOut_Page2 checkout2;
	  @BeforeMethod
	  public void Setup() throws IOException, InterruptedException
	  {
		  initialization();
		  login=new Login_Page();
		  invent=new inventory_Page();
		  cart=new Cart_Page();
		  checkout1=new CartCheckOut_Page1();
		  checkout2=new CheckOut_Page2();
		  login.LoginToApplication();
		  invent.add6Product();
		  invent.ClickOnCartIcon();
		  cart.ClickOnCheckOutBtn();
		  checkout1.verifyUserInfo();
		  
	  }
	  @Test(enabled=true)
	  public void verifyCheckOutOverviewLableTest() throws EncryptedDocumentException, IOException
	  {
		  String expLable=ReadData.readexcel(2, 0); // Checkout: Overview (2, 0)
		  String actLable=checkout2.verifyCheckOutOverviewLable();
		  Assert.assertEquals(expLable, actLable);
		  Reporter.log("Visibility of CheckOut Overview Lable="+actLable);
	  }
	  @Test(enabled=true)
	  public void verifyCancalButtonTest() throws EncryptedDocumentException, IOException
	  {
		  String expUrl=ReadData.readexcel(0, 2); //  https://www.saucedemo.com/inventory.html(0, 2)
		  String actUrl=checkout2.verifyCancalButton();
		  Assert.assertEquals(expUrl, actUrl);
		  Reporter.log("visibility of CheckOut page1 URL="+actUrl);
	  }
	  @Test(enabled=true)
	  public void verifyFinishButtonTest() throws EncryptedDocumentException, IOException
	  {
		  String expUrl=ReadData.readexcel(2, 9); //https://www.saucedemo.com/checkout-complete.html (2, 9)
	      String actUrl=checkout2.verifyFinishButton();
		  Assert.assertEquals(expUrl, actUrl);
		  Reporter.log("visibility of checkout complete page="+actUrl);
	  }
	  @Test(enabled=true)
	  public void verifyPaymentInfoTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 1); //Payment Information(2 ,1)
		  String actTxt=checkout2.verifyPaymentInfo();
		  Assert.assertEquals(expTxt,actTxt);
		  Reporter.log("visibility of payment information Text="+actTxt);
	  }
	  @Test(enabled=true)
	  public void verifySauceCardTxtTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 2); //SauceCard #31337(2 ,2)
		  String actTxt=checkout2.verifySauceCardTxt();
		  Assert.assertEquals(expTxt,actTxt);
		  Reporter.log("visibility of Sauce Cart Text="+actTxt);
	  }
	  @Test(enabled=true)
	  public void verifyShippingInformationTxtTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 3);// Shipping Information (2, 3)
		  String actTxt=checkout2.verifyShippingInformationTxt();
		  Assert.assertEquals(expTxt,actTxt);	  
		  Reporter.log("visibility of Shipping information="+actTxt);
	  }
	  @Test(enabled=true)
	  public void verifyFreePonyExpressDeliveryTxtTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 4); //Free Pony Express Delivery! (2, 4)
		  String actTxt=checkout2.verifyFreePonyExpressDeliveryTxt();
		  Assert.assertEquals(expTxt,actTxt);	  
		  Reporter.log("visibility of Delivery Text="+actTxt);
	  }
	  @Test(enabled=true)
	  public void verifyPriceTotalTxtTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 5); //Price Total (2, 5)
		  String actTxt=checkout2.verifyPriceTotalTxt();
		  Assert.assertEquals(expTxt,actTxt);	  
		  Reporter.log("visibility of Price total txt="+actTxt);
	  }
	  @Test(enabled=true)
	  public void verifySummarySubtotalTxtTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 6); //Item total: $129.94(2, 6)
		  String actTxt=checkout2.verifySummarySubtotalTxt();
		  Assert.assertEquals(expTxt,actTxt);
		  Reporter.log("visibility of summary subtotal txt="+actTxt);
	  }
	  @Test(enabled=true)
	  public void verifySummaryTaxLableTxtTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 7); //Tax: $10.40 (2, 7)
		  String actTxt=checkout2.verifySummaryTaxLableTxt();
		  Assert.assertEquals(expTxt,actTxt);	  
		  Reporter.log("visibility of summaryTax lable text="+actTxt);}
	  @Test(enabled=true)
	  public void verifySummaryInfoLableTxtTest() throws EncryptedDocumentException, IOException
	  {
		  String expTxt=ReadData.readexcel(2, 8); //Total: $140.34 (2, 8)
		  String actTxt=checkout2.verifySummaryInfoLableTxt();
		  Assert.assertEquals(expTxt,actTxt);
		  Reporter.log("visibility of summary Info text="+actTxt);
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
