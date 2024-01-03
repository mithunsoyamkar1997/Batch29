package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ReadData;

public class TestBase 
{
	public static WebDriver driver; //becoz when we create object of chromedriver class then webdriver can able to access only chromedriver class
	                                //But when we create Webdriver Object so WebDriver can access all the browser drivers
 public void initialization() throws IOException, InterruptedException
 {
	 String browser=ReadData.readPropertyFile("Browser"); //chrome
	 
	 if(browser.equals("chrome"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new ChromeDriver();
	 }
	 else if(browser.equals("firefox"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new FirefoxDriver();
	 }
	 else if(browser.equals("edge"))
	 {
		 WebDriverManager.chromedriver().setup();
		 driver=new EdgeDriver();
	 }
	 driver.manage().window().maximize();
	 driver.get(ReadData.readPropertyFile("URL")); //https://www.saucedemo.com/
	 driver.manage().deleteAllCookies();
	 Thread.sleep(4000);
	 
 }



}
