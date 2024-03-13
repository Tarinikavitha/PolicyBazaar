package TestCase;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import PageObject.CarInsurancePage;
import PageObject.HomePage;
import testBase.BaseClass;

public class Tc_2CarInsuranceRunner extends BaseClass{
	
	
	
	@Test(priority=2)
	public void carInsurance() {
		
		logger.info("******Starting Homepage*******");
		try {
		HomePage hp = new HomePage(driver);
		hp.selectCarInsurance(); 
		
		logger.info("******Starting Car Insurance Page*******");
		CarInsurancePage carIns = new CarInsurancePage(driver);
		
		carIns.carNumber();
		carIns.rtoNumber();
		carIns.carBrand();
		carIns.carName();
		carIns.carVariant();
		carIns.custName(randomeString());
		carIns.emailId(randomeString());
		carIns.mobileNumber("9"+randomeNumber());
		carIns.clickViewprice();
		carIns.errorMessage();
		
		logger.info("****** Car Insurance validation Completed*******");
		logger.info("         ===========================             ");
		logger.info("                                 ");
		}catch(Exception e) {
			logger.info("****** Car Insurance validation failed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			Assert.fail();
		}
	}

}
