package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckOut_Page2 extends TestBase
{
 //Object Repository
	@FindBy(xpath="//span[text()='Checkout: Overview']") private WebElement CheckOutOverviewLable;
	@FindBy(xpath="//button[@id='cancel']") private WebElement CancalButton;
	@FindBy(xpath="//button[@id='finish']") private WebElement FinishButton;
	//all payment Info
	@FindBy(xpath="//div[text()='Payment Information']") private WebElement PaymentInformationTxt;
	@FindBy(xpath="//div[text()='SauceCard #31337']") private WebElement SauceCardTxt;
	@FindBy(xpath="//div[text()='Shipping Information']") private WebElement ShippingInformationTxt;
	@FindBy(xpath="//div[text()='Free Pony Express Delivery!']") private WebElement FreePonyExpressDeliveryTxt;
	@FindBy(xpath="//div[text()='Price Total']") private WebElement PriceTotalTxt;
	@FindBy(xpath="//div[@class='summary_subtotal_label']") private WebElement SummarySubtotalTxt;
	@FindBy(xpath="//div[@class='summary_tax_label']") private WebElement SummaryTaxLableTxt;
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']") private WebElement SummaryInfoLableTxt;
	
	public CheckOut_Page2()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyCheckOutOverviewLable()
	{
		return CheckOutOverviewLable.getText();
	}
	public String verifyCancalButton()
	{
		CancalButton.click();
		return driver.getCurrentUrl();
	}
	public String verifyFinishButton()
	{
		FinishButton.click();
		return driver.getCurrentUrl();
	}
	public String verifyPaymentInfo()
	{
		return PaymentInformationTxt.getText();
	}
	public String verifySauceCardTxt()
	{
		return SauceCardTxt.getText();
	}
	public String verifyShippingInformationTxt()
	{
		return ShippingInformationTxt.getText();
	}
	public String verifyFreePonyExpressDeliveryTxt()
	{
		return FreePonyExpressDeliveryTxt.getText();
	}
	public String verifyPriceTotalTxt()
	{
		return PriceTotalTxt.getText();
	}
	public String verifySummarySubtotalTxt()
	{
		return SummarySubtotalTxt.getText();
	}
	public String verifySummaryTaxLableTxt()
	{
		return SummaryTaxLableTxt.getText();
	}
	public String verifySummaryInfoLableTxt()
	{
		return SummaryInfoLableTxt.getText();
	}
}
