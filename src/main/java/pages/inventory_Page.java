package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.TestBase;
import utility.HandleDropdown;

public class inventory_Page extends TestBase
{
	//Object Repository
 @FindBy(xpath="//span[text()='Products']") private WebElement ProductLable;
 //add xpath
 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement BackpackProduct;
 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement BikeLightProduct;
 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement BoltTShirtProduct;
 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement JacketProduct;
 @FindBy(xpath="//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement OnesieProduct;
 @FindBy(xpath="//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement RedTShirtProduct;
 //remove xpath
 @FindBy(xpath="//button[@id='remove-sauce-labs-backpack']") private WebElement RemoveBackpackProduct;
 @FindBy(xpath="//button[@id='remove-sauce-labs-bike-light']") private WebElement RemoveBikeLightProduct;
 @FindBy(xpath="//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement RemoveBoltTShirtProduct;
 @FindBy(xpath="//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement RemoveJacketProduct;
 @FindBy(xpath="//button[@id='remove-sauce-labs-onesie']") private WebElement RemoveOnesieProduct;
 @FindBy(xpath="//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement RemoveRedTShirtProduct;
 //Shopping Cart
 @FindBy(xpath="//a[@class='shopping_cart_link']") private WebElement CartIcon;
 @FindBy(xpath="//span[@class='shopping_cart_badge']") private WebElement CartCount;
 //Fotter Logo
 @FindBy(xpath="//a[text()='Twitter']") private WebElement TwiiterLogo;
 @FindBy(xpath="//a[text()='Facebook']") private WebElement FacebookLogo;
 @FindBy(xpath="//a[text()='LinkedIn']") private WebElement LinkedInLogo;
 //Product Dropdown
 @FindBy(xpath="//select[@class='product_sort_container']") private WebElement ProductDropdown;
 //Fotter Text
 @FindBy(xpath="//div[@class='footer_copy']") private WebElement FotterText;

 public inventory_Page()
 {
	 PageFactory.initElements(driver, this);
 }
 public String verifyProductLable()
 {
	 return ProductLable.getText();
 }
 public String verifyFotterText()
 {
	 return FotterText.getText();
 }
 public boolean verifyTwitterLogo()
 {
	 return TwiiterLogo.isDisplayed();
 }
 public boolean verifyFacebookLogo()
 {
	 return FacebookLogo.isDisplayed();
 }
 public boolean verifyLinkedInLogo()
 {
	 return LinkedInLogo.isDisplayed();
 }
 
 public String add6Product()  //always take String datatype for int variable aslo
 {
	HandleDropdown.HandleSelectClass(ProductDropdown, "Price (low to high)");
	 BackpackProduct.click();
	 BikeLightProduct.click();
	 BoltTShirtProduct.click();
	 JacketProduct.click();
	 OnesieProduct.click();
	 RedTShirtProduct.click();
	return CartCount.getText();
 }
 public String remove2Product()
 {   //Before remove product from cart we need to add product in cart
	 //for that we call add6Product() methad
	 add6Product();
	 RemoveBackpackProduct.click();
	 RemoveBikeLightProduct.click();
	return CartCount.getText() ;
 }
 public String ClickOnCartIcon()
 {
	 CartIcon.click();
	return driver.getCurrentUrl();
	 
 }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 

}
