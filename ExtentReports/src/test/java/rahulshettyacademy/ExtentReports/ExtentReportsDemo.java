package rahulshettyacademy.ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsDemo {
	
	ExtentReports extent; //Defining the object globally so that every method can use this object 
	
	
	@BeforeTest
	public void config()
	{
		//We have two classes which combined will give us the complete Extent Reports:
		//ExtentReports and ExtentSparkReporter
		//ExtentSparkReporter - This class is used for configuration of the reports and expects a PATH, where our reports should be created. It is responsible for creating a report. And this method will take the "PATH" as the argument. So in the first line, we are defining the path where we want to create our file:
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		//Setting the name of the of the results as per our convenience:
		reporter.config().setReportName("Web Automation Results");
		//Setting the title of the page (reports page):
		reporter.config().setDocumentTitle("Test Results");
		
		
		//ExtentReports - This is the main class responsible to drive all our reporting execution
		extent = new ExtentReports();
		extent.attachReporter(reporter); //Now, the main class will have all the knowledge given by object of configuration class "ExtentSparkReporter"
		//We can give the name of the tester generating the reports and coding:
		extent.setSystemInfo("Automation Tester", "Nikhil Kukrety");
		
	}
	
	
	
	@Test
	public void initialDemo()
	{
		
	//ExtentTest class's object will store the result and we can use it to play with it and modify accordingly (eg. to take screenshot - test.(method) )
	ExtentTest test = extent.createTest("Initial Demo"); //By this, it will know that extentReports has to be created for this method based on execution
	System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\ChromeDriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://rahulshettyacademy.com/");
	driver.manage().window().maximize();
	System.out.println(driver.getTitle());
	extent.flush(); //Means testcase is finished

	}
}
