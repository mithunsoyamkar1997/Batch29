package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TestBase;
import pages.Login_Page;
import utility.ReadData;
import utility.Screenshot;

public class VerifyLoginPageWithMultipleCredentils extends TestBase
{
   Login_Page login;
	@BeforeMethod
 public void setup() throws IOException, InterruptedException
 {
		 initialization();
	 login=new Login_Page();
	 
 }
	@DataProvider (name="Credentials")
	public Object getData()
	{
		return new Object[][]
				{
			{"standard_user","secret_sauce"},             //valid & valid {" "." "}
			{"locked_out_user","secret_sauce"},           //valid & Invalid {" "," "}
			{"problem_user","secret_sauce"},              //Invalid & Valid {" "," "}
			{"performance_glitch_user","secret_sauce"},   //Invalid & Invalid {" "," "}
			{"error_user","secret_sauce"},
			{"visual_user","secret_sauce"},
				};
		
	}
	//we declare one test methad in this methad we call Multicreadential methad from LoginPageclass which return Un,pass
	//here we mention dataprovider with this test methad through @Test annotation
	@Test (dataProvider="Credentials",invocationCount = 1)
	public void LoginToApplicationWithMultiCred(String un,String pass) throws EncryptedDocumentException, IOException
	{  
		
		SoftAssert soft=new SoftAssert();
		String expUrl=ReadData.readexcel(0, 2);
		String actUrl=login.LoginToApplicationWithMultiCred(un, pass);
		soft.assertEquals(expUrl, actUrl);
		soft.assertAll();
	}
	/*SOFT ASSERTION : 1)we need to create object of SoftAssert
	                   2) soft assert collects errors and hold it during execution. 
	                   it does not throw exception when assert statement get failed & it continue with next statement(step) (after the Assert statement )
	                   3)if u thing you will get exception and you want to throw it then u can used assertAll() methad as a LAst statement in @Test methad
	                   4) after that test suite will continue next @Test methad */ 
	
	 @AfterMethod
	   public void closebrowser(ITestResult IT) throws IOException
	   {
		   if(IT.FAILURE==IT.getStatus())
		   {
			   Screenshot.screenshot(IT.getName());
		   }
		   driver.close();
	   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
