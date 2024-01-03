package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadData 
{
  public static String readPropertyFile(String value) throws IOException
  {
	  Properties prop=new Properties();
	  FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Project_Selenium_29Batch\\TestData\\config.properties");
	  prop.load(file);
	  //Suppose we want URL of app
	  //but that URL we want in TestBase class
	  //So here we declare one parameter in methad
	  //so that parameter is refer to the perticular URL which we store in config.properties File
	  return prop.getProperty(value);
  }
  public static String readexcel(int rowNum,int colNum) throws EncryptedDocumentException, IOException
  {
	  FileInputStream file=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Project_Selenium_29Batch\\TestData\\Book1.xlsx");
	  Sheet es = WorkbookFactory.create(file).getSheet("Sheet1");
	  //in freamwork we need to write code different way
	  //for that we take two parameter in methad
	String value=es.getRow(rowNum).getCell(colNum).getStringCellValue();
	return value;
	  
  }
}
