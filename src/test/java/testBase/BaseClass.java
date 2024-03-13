package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	static public WebDriver driver;
	public Logger logger;
	
	

	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException 
	{
		
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		switch(br.toLowerCase()) {
		case "chrome": driver=new ChromeDriver();break;
		case "edge": driver=new EdgeDriver();break;
		default: System.out.println("No matching browser..");
		 return;
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.policybazaar.com/");
		
		driver.manage().window().maximize();
	}
	
	@AfterClass()
	public void tearDown() throws InterruptedException 
	{
		Thread.sleep(10000);
		driver.quit();
	}

 
	public String randomeString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	public String randomeNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(9);
		return generatedString;
	}
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException {

//		String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
	

	
	static public LocalDate Start_date_modified(LocalDate currentDate)
	{		
		Random random=new Random();
		int daysToAdd= random.nextInt(15);
		LocalDate randomdate=currentDate.plusDays(daysToAdd);
		return randomdate;
	}
	
	static public String Dates(LocalDate randomdate) {
		String arr=randomdate.toString();
		String date[]=arr.split("-");
		String monthdummy=date[1];
		int num=Integer.parseInt(monthdummy);
		String month_alp[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		String month=month_alp[num-1];
		int len=date.length;
		String start_date=date[len-1]+" "+month+", "+date[0];
		return start_date;
	}

}
