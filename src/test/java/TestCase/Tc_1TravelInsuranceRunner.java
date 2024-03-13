package TestCase;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HomePage;
import PageObject.TravelInsurancepage;
import testBase.BaseClass;


public class Tc_1TravelInsuranceRunner extends BaseClass{
	
	@Test(priority=1)
	public void travelInsurance() {
		
		logger.info("******Starting Homepage*******");
		try {
		HomePage hp = new HomePage(driver);
		hp.selectTravelInsurance(); 
		
		logger.info("******Starting Travel Insurance Page*******");
		
		TravelInsurancepage  travelInsurance = new TravelInsurancepage(driver); 
		travelInsurance.setGermany();
		travelInsurance.clickNext();
		
		travelInsurance.setDate();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		travelInsurance.clickNext();
		
		travelInsurance.setCount(); 
		travelInsurance.selectAge(); 
		travelInsurance.clickNext();
		
		travelInsurance.medi();
		
		travelInsurance.mobileNumber("9"+randomeNumber());
		travelInsurance.clickNext();
		
		travelInsurance.filterData(); 
		travelInsurance.printData();
		
		logger.info("****** Travel Insurance validation Completed*******");
		logger.info("         ===========================             ");
		logger.info("                                 ");
		}catch(Exception e) {
			logger.info("****** Travel Insurance validation failed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			Assert.fail();
		}
	}
}
