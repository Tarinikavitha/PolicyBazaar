package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Car2 extends BasePage {
	
	public WebDriver driver;

	public Car2(WebDriver driver) {
		super(driver);
	}
	//Locators 
	
	
	@FindBy(xpath="/html/body/section/div/div/div/div[2]/div/div[3]/div/span") WebElement buyingANewCar;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[2]/div[2]/div/div/ul[1]/li[3]") WebElement place;
	
	@FindBy(xpath="/html/body/section/div/div/div/div[2]/div[2]/div/div/ul[1]/li[5]/ul/li[2]")WebElement rto;
	
	@FindBy(xpath="//*[@class=\"gridList slideToLeft\"]/li/span[2]") WebElement brand;
	
	@FindBy(xpath="//*[@class=\"animationWrap\"]/ul/li[6]") WebElement model;
	
	@FindBy(xpath="//*[@class=\"animationWrap\"]/ul/li[2]") WebElement fuel;
	
	@FindBy(xpath="//*[@class=\"animationWrap\"]/ul/li[5]") WebElement variant;
	
	@FindBy(css="#name") WebElement fullName;
	
	@FindBy(css="#email") WebElement email;
	
	@FindBy(css="#mobileNo") WebElement mobileNo;
	
	@FindBy(css="button[id='btnLeadDetails'] span") WebElement viewPrices;
	
	@FindBy(css=".msg-error.show") WebElement errorMsg;
	
	//Actions 
	
	public void carNumber() 
	{
		buyingANewCar.click();	
	}
	
	public void rtoNumber() {
		place.click();
		rto.click();
	}
	
	public void carBrand() {
		brand.click();
	}
	public void carName() {
		model.click();
	}
	public void f_type()
	{
		fuel.click();
	}
	public void carVariant() {
		variant.click();
	}
	
	public void custName(String name) {
		fullName.sendKeys(name);
	}
	public void emailId(String id) {
		email.sendKeys(id);
	}
	public void mobileNumber(String num) {
		mobileNo.sendKeys(num);
	}
	public void clickViewprice() {
		viewPrices.click();
	}
	public void errorMessage() {
		System.out.println();
		System.out.println("                    =======================                     ");
		System.out.println();
		System.out.println(errorMsg.getText());
		System.out.println();
		System.out.println("                    =======================                     ");
		System.out.println();
		
	}
	public void quit()
	{
		driver.quit();
	}

}
