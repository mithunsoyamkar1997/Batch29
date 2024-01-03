package utility;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import base.TestBase;

public class Screenshot extends TestBase
{
	public static String getDate()
	{
		return new SimpleDateFormat("dd-MM-YY ss-mm-HH").format(new Date());
	}
	public static void screenshot(String nameOfMethad) throws IOException
	{
		  File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  File destination=new File("C:\\Users\\Admin\\eclipse-workspace\\Project_Selenium_29Batch\\screenshot\\"+nameOfMethad+"----"+getDate()+".jpeg");
	      FileHandler.copy(source, destination);
	}
	//+nameOfMethad+"----"+getDate()+".jpeg"   ( this code we used for filename construction )
  
}
