package PageObject;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import testBase.BaseClass;

public class TravelInsurancepage extends BasePage {
	

	public WebDriver driver;

	public TravelInsurancepage(WebDriver driver) {
		super(driver);
	
	}
	
	//Locators 
	
	@FindBy(css="img[src='https://static.pbcdn.in/travel-cdn/images/country/Germany.jpg']") WebElement germany;
	@FindBy(css=".travel_main_cta") WebElement nextBtn;
	
	@FindBy(xpath="//div[@class='MuiPickersDateRangePickerInput-root']//div[1]//div[1]//div[1]//input[1]") WebElement  clickDatePicker;
	@FindBy(xpath="//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input") WebElement startDate;
	@FindBy(xpath="//button[@class='MuiButtonBase-root MuiIconButton-root MuiPickersArrowSwitcher-iconButton MuiIconButton-sizeSmall']//span[@class='MuiIconButton-label']//*[name()='svg']")WebElement nextSlide;
	@FindBy(xpath="//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[2]/div/div/input") WebElement endDate;
	
	@FindBy(css="label[for='traveller_2']") WebElement count; 
	@FindBy(css="[id=\"0\"]") WebElement ageOfTraveller1;
	@FindBy(css="[id=\"1\"]") WebElement ageOfTraveller2;
	@FindBy(css="label[for='21 years_undefined']") WebElement age1;
	@FindBy(css="label[for='22 years_undefined']") WebElement age2;
	
	@FindBy(xpath="//input[@value='no']/following::label") WebElement medical;
	
	@FindBy(css="#mobileNumber") WebElement mobileNo ;
	
	@FindBy(xpath="//input[@id='studentTrip']") WebElement studentRadio;
	@FindBy(xpath="//input[@id='Traveller_1']") WebElement trvl1ChkBox;
	@FindBy(xpath="//input[@id='Traveller_2']") WebElement trvl2ChkBox;
	@FindBy(xpath="//select[@id='feet']") WebElement durationSelect;
	@FindBy(xpath="//div[@class='pqCtaWrapper']/button") WebElement btnViewPlan;
	@FindBy(css="section[class='newFilterSection sort'] details summary") WebElement btnSort;
	@FindBy(xpath="//input[@id='17_sort']") WebElement lowToHigh;
	@FindBy(xpath="//section/article/div/div/div/div/div/p[1]") List<WebElement> insuranceProvider;
	@FindBy(xpath="//section/article/div/div/div/div/div/p[2]") List<WebElement> insurancePlan;
	@FindBy(xpath="//section/article/div/div/div/div[2]/p[1]") List<WebElement> insuranceAmount;
	@FindBy(xpath="//section/article/div/div/div/div[3]/p/span") List<WebElement> insurancePremium;
	
	//for country
	public void setGermany() {
		germany.click();
	}
	
	//for next button
	public void clickNext() {
		nextBtn.click();
	}
	
	//for getting start and end date my calling methods
	public void setDate() {
		clickDatePicker.click();
		LocalDate stdate=start_date();
		nextSlide.click();
		end_date(stdate);
	}
	
	//for selecting random Start_date
	public LocalDate start_date()
	{
		LocalDate currentDate=LocalDate.now();  //today's date
		LocalDate currentDate_Start =BaseClass.Start_date_modified(currentDate);
	String senddate=BaseClass.Dates(currentDate_Start);
	startDate.sendKeys(senddate);
		return currentDate_Start;
	}
	
	//for selecting random End_date
	public void end_date(LocalDate stdate)
	{
		LocalDate currentDate_End =BaseClass.Start_date_modified(stdate);
		String senddate_End=BaseClass.Dates(currentDate_End);
		endDate.sendKeys(senddate_End);
	}
	

	
	/*public void setDate() {
		clickDatePicker.click();
		start_date();
		nextSlide.click();
		end_date();
	}
	
	public void start_date()
	{
		startDate.sendKeys("25 March, 2024");
	}
	
	public void end_date()
	{
		endDate.sendKeys("03 April, 2024");
	}*/
	
	
	//
	
	//selecting travellers count
	public void setCount() 
	{
		count.click();
	}
	
	//Set age for traveller 1,2
	public void selectAge() 
	{		
		ageOfTraveller1.click();
		age1.click();
		
		ageOfTraveller2.click();
		age2.click();
	}
	
	//Medical condition
	public void medi() throws InterruptedException
	{
		if(!medical.isSelected())
		{
			medical.click();
		}
		
		Thread.sleep(3000);
	}
	
	//mobile no
	public void mobileNumber(String num) {
		mobileNo.sendKeys(num);
	}
	
	//selecting student plan and and sort the plans
	public void filterData()
	{
		try {
		studentRadio.click();
		trvl1_ChkBox();
		trvl2_ChkBox();
		Select select=new Select(durationSelect);
		select.selectByValue("1");
		btnViewPlan.click();
		Thread.sleep(2000);
		btnSort.click();
		lowToHigh.click();
		System.out.println("Filter Passed");
		}
		catch(Exception e) {
			System.out.println("Filter fail");
		}
	}
	
	//printing lowest 3 insurance plan with company name
	public void printData() throws InterruptedException{
			for(int i=0;i<3;i++) {
				System.out.println("*****INSURANCE PLAN "+(i+1)+" *****");
				System.out.println("Plan: "+insurancePlan.get(i).getText());
				Thread.sleep(1000);
				System.out.println("Amount: "+insurancePremium.get(i).getText());
				Thread.sleep(1000);
				System.out.println("Company: "+insuranceProvider.get(i).getText());
				}
	}
	
	//selecting traveller 1 in student plan
	public void trvl1_ChkBox() throws InterruptedException
	{
		if(!trvl1ChkBox.isSelected())
		{
			trvl1ChkBox.click();
		}
	}
	
	//selecting traveller 2 in student plan
	public void trvl2_ChkBox() throws InterruptedException
	{
		if(!trvl2ChkBox.isSelected())
		{
			trvl2ChkBox.click();
		}
	}
}
