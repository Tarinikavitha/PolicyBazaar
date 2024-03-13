package TestCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.Car2;
import PageObject.HomePage;
import testBase.BaseClass;

public class tc_2_dummy extends BaseClass{
	
	
	
	@Test(priority=2)
	public void carInsurance() {
		
		logger.info("******Starting Homepage*******");
		try {
		HomePage hp = new HomePage(driver);
		hp.selectCarInsurance(); 
		
		logger.info("******Starting Car Insurance Page*******");
		Car2 car = new Car2(driver);
		
		car.carNumber();
		car.rtoNumber();
		car.carBrand();
		car.carName();
		car.f_type();
		car.carVariant();
		car.custName(randomeString());
		car.emailId(randomeString());
		car.mobileNumber("12"+randomeNumber());
		car.clickViewprice();
		car.errorMessage();
		
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
