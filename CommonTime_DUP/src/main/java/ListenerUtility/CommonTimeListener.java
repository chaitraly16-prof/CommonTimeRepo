package ListenerUtility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class CommonTimeListener implements ITestListener{
	
	public ExtentTest test;
	public static ExtentReports report;
	
	   @Override
	    public void onStart(ITestContext context) {
	        System.out.println("TEST SUITE STARTED");
	        System.out.println("Extent Report initialized");
	        ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
	        
	        String path = System.getProperty("user.dir")
	                + "\\AdvanceReport\\report.html";

	        File folder = new File(
	                System.getProperty("user.dir")
	                + "\\AdvanceReport");

	        if (!folder.exists()) {
	            folder.mkdirs();
	        }
	        
			spark.config().setDocumentTitle("CRM Test Suite Results");
			spark.config().setReportName("CRM Report");
			spark.config().setTheme(Theme.DARK);
			
			//add env information & create test
			report = new ExtentReports(); 
			System.out.println(report);
			report.attachReporter(spark);
			report.setSystemInfo("OS", "Windows-10");
			report.setSystemInfo("BROWSER", "CHROME-100");
	    }
	
	 @Override
	    public void onTestStart(ITestResult result) {
			test=report.createTest(result.getMethod().getMethodName());
			test.log(Status.INFO,result.getMethod().getMethodName()+"===> START <===");
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("PASSED: " + result.getName());
	        System.out.println("====== ======> " +result.getMethod().getMethodName()+">=====END======");
			test.log(Status.PASS, result.getMethod().getMethodName()+"=======>END=======");
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	    	
	    	String testName = result.getMethod().getMethodName();
	    	
	    	 TakesScreenshot ts = (TakesScreenshot) BaseUtility.BaseClass.sdriver;

	         File source = ts.getScreenshotAs(OutputType.FILE);

	         File destination = new File("./screenshots/"+testName+ ".png");

	        try {
				FileHandler.copy(source, destination);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        System.out.println("FAILED: " + result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("SKIPPED: " + result.getName());
	    }

	    @Override
	    public void onFinish(ITestContext context) {
	    	report.flush();
	        System.out.println("TEST SUITE FINISHED");
	    }
	}
