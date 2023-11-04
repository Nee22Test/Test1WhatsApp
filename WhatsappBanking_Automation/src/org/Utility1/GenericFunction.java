package org.Utility1;

	import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.io.FileInputStream;
	import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

	public class GenericFunction {
	    public WebDriver driver;
	    public WebDriverWait wait;

	    public static String fetchPropertyValue(String key) throws IOException {

	        FileInputStream objFile = new FileInputStream(System.getProperty("user.dir") + "\\ObjectRepository.properties");
	        Properties property = new Properties();
	        property.load(objFile);
	        return property.get(key).toString();
	    }

	    public static void scrollTodown(WebDriver driver) {
	        JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("window.scrollBy(0,1000)", "");
	    }
	    public static void scrollToup(WebDriver driver) {
	        JavascriptExecutor jse = (JavascriptExecutor) driver;
	        jse.executeScript("window.scrollBy(0,-250)", "");
	    }

public static void ScrollDown(PerformsTouchActions driver)
{

	TouchAction  action =new TouchAction(driver);	
	Dimension size	=((WebDriver) driver).manage().window().getSize();
	int width=size.width;
	int height=size.height;				
	int middleOfX=width/2;
	int startYCoordinate= (int)(height*.8);
	int endYCoordinate= (int)(height*.1);
				action.press(PointOption.point(middleOfX, startYCoordinate))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
	.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
	}
	
public static void ScrollDown2(PerformsTouchActions driver)
{

	TouchAction  action =new TouchAction(driver);	
	Dimension size	=((WebDriver) driver).manage().window().getSize();
	int width=size.width;
	int height=size.height;				
	int middleOfX=width/2;
	int startYCoordinate= (int)(height*.4);
	int endYCoordinate= (int)(height*.1);
				action.press(PointOption.point(middleOfX, startYCoordinate))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
	.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
	}
public static void ScrollUp(PerformsTouchActions driver)
{
	 System.out.println("Outside the loopss 5");
	TouchAction  action =new TouchAction(driver);	
	Dimension size	=((WebDriver) driver).manage().window().getSize();
	int width=size.width;
	int height=size.height;				
	int middleOfX=width/2;
	int startYCoordinate= (int)(height*.1);
	int endYCoordinate= (int)(height*.4);
				action.press(PointOption.point(middleOfX, startYCoordinate))
	.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
	.moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
				System.out.println("Outside the loopss 7");
	}
	/*TouchAction  action =new TouchAction(driver);	
	   Dimension size = ((WebDriver) driver).manage().window().getSize();

	    int startX = 0;
	    int endX = 0;
	    int startY = 0;
	    int endY = 0;
		 System.out.println("Outside the loopss 6");
endY = (int) (size.height * 0.70);
startY = (int) (size.height * 0.30);
startX = (size.width / 2);


System.out.println("Outside the loopss 7");
action.press(PointOption.point(startX, startY)).moveTo(PointOption.point(startX, endY)).release().perform();
System.out.println("Outside the loopss 8");*/
	 
	

}
