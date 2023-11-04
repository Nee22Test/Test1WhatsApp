package org.Pages1;

import java.time.Duration;

import org.Base1.DriverInstance1;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;

public class PreLoginPage{

	AndroidDriver driver;
	WebDriver drivers;
	By Insurance = By.id("com.SIBMobile:id/lblmenu3");
	By Calender = By.id("com.SIBMobile:id/lblmenu5");
	By Calculator = By.id("com.SIBMobile:id/menu6Layout");

	public PreLoginPage(AndroidDriver driver) {
		this.driver = driver;
		

	}

	public void Validate_PreloginMenus() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(Insurance));
	
		//1. Insurance Menu Validation
	driver.findElement(Insurance).click();
		Thread.sleep(2000);
		String insu = driver.findElement(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView"))
				.getText();

		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(insu, "Insurance");
		Reporter.log("\n Validated -> Insurance   ");
		driver.navigate().back();

		// 2. Calculator menu Validation
		driver.findElement(Calculator).click();
		Thread.sleep(2000);
		String cal = driver.findElement(By.id("com.SIBMobile:id/title")).getText();
		softAssert.assertEquals(cal, "Calculator");

		// 2.1 EMI Calculator
		driver.findElement(By.id("com.SIBMobile:id/edt_amt_loan")).sendKeys("1000");
		driver.findElement(By.id("com.SIBMobile:id/edt_intrate")).sendKeys("10");
		driver.findElement(By.id("com.SIBMobile:id/edt_tenure")).sendKeys("11");
		driver.findElement(By.id("com.SIBMobile:id/btn_continue")).click();
		Thread.sleep(4000);
		String EMIamt = driver.findElement(By.id("com.SIBMobile:id/emi")).getText();
		System.out.print("\n EMI amount --> " + EMIamt);
		Reporter.log("\n Validated -> EMI Calculator  ");
		Thread.sleep(2000);
		
		
		// 2.2 Deposit Calculator
		driver.findElement(
				By.xpath("//android.widget.LinearLayout[@content-desc=\"Deposit Calculator\"]/android.widget.TextView"))
				.click();		
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/edt_amt_deposit")).sendKeys("1000");		
		driver.findElement(By.id("com.SIBMobile:id/edt_intrate")).sendKeys("10");
		driver.findElement(By.id("com.SIBMobile:id/edt_tenure")).sendKeys("11");
		driver.findElement(By.id("com.SIBMobile:id/btn_continue")).click();
		Thread.sleep(4000);
		String FDAmt = driver.findElement(By.id("com.SIBMobile:id/deposit")).getText();
		System.out.println("\n Fixed Deposit amount --> " + FDAmt);
		Reporter.log("\n Validated - Deposit Calculator -> Fixed Deposit  ");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/recurring")));
		driver.findElement(By.id("com.SIBMobile:id/recurring")).click();
		driver.findElement(By.id("com.SIBMobile:id/btn_continue")).click();
		Thread.sleep(4000);
		String RDAmt = driver.findElement(By.id("com.SIBMobile:id/deposit")).getText();
		System.out.println("\n Recurring Deposit amount -->" + RDAmt);
		Reporter.log("\n Validated - Deposit Calculator -> Recurring Deposit   ");
		driver.navigate().back();

		// 3. Deposit Rates Validation

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/lblmenu7")));
		driver.findElement(By.id("com.SIBMobile:id/lblmenu7")).click();
		Thread.sleep(2000);
		String tenure = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")).getText();
		System.out.println("\n Tenure --> "+tenure);
		Thread.sleep(1000);
		String interestRate = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).getText();
		System.out.println("\n Interest rates --> "+interestRate);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/seniorCitizen")));
		driver.findElement(By.id("com.SIBMobile:id/seniorCitizen")).click();
		Thread.sleep(4000);
		String seniorTenure = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[2]")).getText();
		System.out.println("\n Senior Citizen tenure --> "+seniorTenure);
		String seniorInterestRate = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")).getText();
		System.out.println("\n Senior Citizen tenure --> "+seniorInterestRate);
		Reporter.log("\n Validated -> Deposit Rates  ");
		driver.navigate().back();
		softAssert.assertAll();
		Thread.sleep(3000);
		
		
		
		//4.IFSC navigation
		//Search using IFSC
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/view_ifsc")));
		driver.findElement(By.id("com.SIBMobile:id/view_ifsc")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_ifsc")));
		driver.findElement(By.id("com.SIBMobile:id/edt_ifsc")).sendKeys("HDFC0006930");
		
		driver.findElement(By.id("com.SIBMobile:id/btn_search")).click();
		Thread.sleep(1000);
		String BranchName = driver.findElement(By.id("com.SIBMobile:id/branchname")).getText();
		System.out.println("Branch Name -> "+BranchName);
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_ifsc")));
		driver.findElement(By.id("com.SIBMobile:id/edt_ifsc")).clear();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//5.Offers
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Offers\"]/android.widget.ImageView")).click();
		
		Thread.sleep(1000);
		System.out.println("Navigated to offers");
		driver.navigate().back();
		Thread.sleep(1000);
		
		//6.Branch/ATM
		/*driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Branch/ATM\"]/android.widget.ImageView")).click();
		Thread.sleep(2000);
		String ATMLocator = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"ATM Locator\"]/android.widget.TextView")).getText();
		
		System.out.println("ATM Locator is "+ATMLocator);
		Thread.sleep(1000);
		String BranchLocator = driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Branch Locator\"]")).getText();
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"Branch Locator\"]")).click();
		Thread.sleep(2000);
		System.out.println("Branch locator is ");
		
		driver.navigate().back();
		Thread.sleep(1000);
		
		Reporter.log("Pre Login Scenarios  --> Passed");
		//Search using state and bank
		//driver.findElement(By.id("com.SIBMobile:id/edt_state")).click();
		//Thread.sleep(1000);
		//WebElement state = driver.findElement(By.id("com.SIBMobile:id/edt_state"));
		//state.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.RETURN);
		/*Select state= new Select(driver.findElement(By.id("com.SIBMobile:id/edt_state")));
		state.selectByVisibleText("ANDAMAN AND NICOBAR ISLAND");
		Thread.sleep(2000);
		Select bank = new Select(driver.findElement(By.id("com.SIBMobile:id/edt_bank")));
		bank.selectByVisibleText("HDFC BANK");
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/edt_city")).sendKeys("Ernakulam");
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/btn_search")).click();
		Thread.sleep(2000);
		String BranchAddress = driver.findElement(By.id("com.SIBMobile:id/address")).getText();
		System.out.println("Branch Address is "+BranchAddress);*/
		
		//driver.navigate().back();
		
		
	}

	

}
