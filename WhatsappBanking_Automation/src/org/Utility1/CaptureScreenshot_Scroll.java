package org.Utility1;

	import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import io.appium.java_client.android.AndroidDriver;

	public class CaptureScreenshot_Scroll {
	
		//WebDriver drivers;
		
public String getScreenshot1(AndroidDriver driver,String screenshotName) throws IOException
{
	String dateName= new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	String screenshotFileName=screenshotName+dateName+".png";
	
	String destination = System.getProperty("user.dir")+"/extentReports/"+screenshotFileName;
	File finalDestination =new File(destination);
	File screenshotFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	FileUtils.moveFile(screenshotFile, finalDestination);
	
	return screenshotFileName;
	
	}

	 public  static String captureScreen(AndroidDriver driver,String screenName) throws IOException
	 {
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"//Test-Screenshots//"+screenName+".png";
		File target=new File(dest);
		FileUtils.copyFile(src, target);
		//Reporter.log(dest);
		 return dest;
	 }
	 
	 public  static String captureScreen_TS_01_Login(AndroidDriver driver,String screenName) throws IOException
	 {
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"//Test-Screenshots-TS01-Login//"+screenName+".png";
		File target=new File(dest);
		FileUtils.copyFile(src, target);
		return dest; 
	 }
	 
	 public  static String captureScreen_TS_02_FT(AndroidDriver driver,String screenName) throws IOException
	 {
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"//Test-Screenshots-TS02-FT//"+screenName+".png";
		File target=new File(dest);
		FileUtils.copyFile(src, target);
		return dest; 
	 }
	 public  static String captureScreen_TS_03_Deposits(AndroidDriver driver,String screenName) throws IOException
	 {
		TakesScreenshot screen=(TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest= System.getProperty("user.dir")+"//Test-Screenshots-TS03-Deposits//"+screenName+".png";
		File target=new File(dest);
		FileUtils.copyFile(src, target);
		return dest; 
	 }
	 
public  static void Scroll_down(AndroidDriver driver)
{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,100)", "");
	}


	
	public  static void Scroll_down2(AndroidDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,50)", "");
		}
	}