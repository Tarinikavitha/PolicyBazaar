package TestCase;


import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.HealthInsurancePage;
import PageObject.HomePage;
import testBase.BaseClass;

public class Tc_3HealthInsuranceRunner extends BaseClass {
		
	@Test(priority=3)
	public void healthInsurance() throws InterruptedException {
		
		logger.info("******Starting Homepage*******");
		try {
		HomePage hp = new HomePage(driver);
		hp.insuranceprod();
		
//		logger.info("******Starting Health Insurance Page*******");
		
		HealthInsurancePage ins = new HealthInsurancePage(driver);
		ins.healthInsurance();
		ins.extractMenuDataToExcel("Menu_data");

		
		logger.info("******Health Insurance validation Completed*******");
		logger.info("         ===========================             ");
		logger.info("                                 ");
		}catch(Exception e) {
			logger.info("****** Health Insurance validation failed*******");
			logger.info("         ===========================             ");
			logger.info("                                 ");
			Assert.fail();
		}
		
	}
	



}
