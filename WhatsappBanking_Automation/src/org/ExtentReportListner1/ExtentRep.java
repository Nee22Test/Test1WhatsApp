package org.ExtentReportListner1;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRep {
	 // ExtentHtmlReporter htmlReporter;
	//public ExtentReports extent;
	  //public  ExtentTest extentTest;
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest logger;
	//
	@BeforeSuite
	public void reportSetup()
	{
		//extent = new ExtentReports();
		//ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		//extent.attachReporter(spark);
		extent = new ExtentReports();
	
		
		
		spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/MirrorPlus_ExtentReport.html");
		extent.attachReporter(spark);
		extent.setSystemInfo("Application ", "Mobile Banking - Mirror Plus");
		         extent.setSystemInfo("Environment", "UAT");
		extent.setSystemInfo("Features", "Installation, Register, Login");
		spark.config().setDocumentTitle("Test Results -- Regression");
		                // Name of the report
		spark.config().setReportName("Regression Test Case -- Test Results");
		                // Dark Theme
		spark.config().setTheme(Theme.DARK);

	}
	
	@AfterSuite
	public void reportTeardown()
	{
		  // calling flush writes everything to the log file
        extent.flush();
	}
}
