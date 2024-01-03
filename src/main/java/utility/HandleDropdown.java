package utility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HandleDropdown 
{  /*concept : 1) static member belongs to class thats why through class name we can call this methad
	           2) Non static member belongs to object so ( if the methad is non-static then we will call methad through object*/ 
	public static void HandleSelectClass(WebElement ele,String value)
	{
		//so here in this class we do not have any Webelement and Dropdown value
		//so in this methad we declare two parameter for webelement and dropdown
		//so whenever when we call this methad through class name we need tu put webelement and dropdown value as a parameter
		 Select s=new Select(ele);
		 s.selectByVisibleText(value);
	}

}
