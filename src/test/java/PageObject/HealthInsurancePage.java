package PageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelDataFile;

public class HealthInsurancePage extends BasePage{
//	public static WebDriver driver=BaseClass.gerDriver();
//	TakesScreenshot ts=new TakesScreenshot();
	List<String> options = new ArrayList<>();
	

	public WebDriver driver;
	public HealthInsurancePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="body > div:nth-child(9) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3)")List< WebElement> healthInsurance;
	
	
	//actions	
	public void healthInsurance() throws InterruptedException {
		System.out.println("Health Insurance Menu Items are ");  //printing the message
		System.out.println("-----------------------------");  //printing the message
		for (WebElement w : healthInsurance) {
			String dum_var=w.getText();
			options.add(dum_var);
			System.out.println(dum_var);
			
		}
	}
	
	public void extractMenuDataToExcel(String sheetName) {
		ExcelDataFile excelfile = new ExcelDataFile(System.getProperty("user.dir") + "\\testData\\input.xlsx");

		if (excelfile.isSheetExist(sheetName)) {
			excelfile.removeSheet(sheetName);
		}
		excelfile.addSheet(sheetName);
		System.out.println("allHeaderNameList.size()"+options.size());
		for (int i = 0; i < options.size(); i++) {
			excelfile.setCellData( sheetName,i+1,i+1,options.get(i));
		}
	}
	
	
	
	
	
	
}
