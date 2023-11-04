package org.Pages1;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.Utility1.CaptureScreenshot_Scroll;
import org.Utility1.ExcelDataConfig;
import org.Utility1.GenericFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class DepositsPage {
	AndroidDriver driver;
	WebDriver drivers;
	By Accounts = By.id("com.SIBMobile:id/lblmenu1");
	By Depo =By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.ImageView");
	By InterestRates =By.id("com.SIBMobile:id/interestratelbl");
	By Btn_Back =By.id("com.SIBMobile:id/title");
	By Cal = By.id("com.SIBMobile:id/calculatorlbl");
	By Dep_Closure= By.id("com.SIBMobile:id/depositclosure");
	
	public DepositsPage(AndroidDriver driver) {
		this.driver = driver;
		

	}

	public void DepositDetails() throws InterruptedException 
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		SoftAssert softAssert = new SoftAssert();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
		driver.findElement(Depo).click();
		Thread.sleep(2000);
		
		//Title
		String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
		System.out.println("Deposits Title --> " +depoTitle);
		softAssert.assertEquals(depoTitle, "Deposits");
		
		//Interest Rates
		wait.until(ExpectedConditions.visibilityOfElementLocated(InterestRates));
		driver.findElement(InterestRates).click();		
		Thread.sleep(2000);
		String IntRate=driver.findElement(By.id("com.SIBMobile:id/title")).getText();	
		System.out.println("Interest Rates Title - "+IntRate);
		softAssert.assertEquals(IntRate, "Deposit Rates");
		Thread.sleep(2000);
		driver.findElement(Btn_Back).click();
		
		// Deposit Calculator
		wait.until(ExpectedConditions.visibilityOfElementLocated(Cal));
		driver.findElement(Cal).click();
		
		Thread.sleep(2000);
		String cal = driver.findElement(By.id("com.SIBMobile:id/title")).getText();
		System.out.println("Calculator Title "+cal);
		softAssert.assertEquals(cal, "Calculator");
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_amt_deposit")));
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
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_continue")));
		driver.findElement(By.id("com.SIBMobile:id/btn_continue")).click();
		Thread.sleep(4000);
		String RDAmt = driver.findElement(By.id("com.SIBMobile:id/deposit")).getText();
		System.out.println("\n Recurring Deposit amount -->" + RDAmt);
		Reporter.log("\n Validated - Deposit Calculator -> Recurring Deposit   ");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.LinearLayout[@content-desc=\"EMI Calculator\"]/android.widget.TextView")));
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"EMI Calculator\"]/android.widget.TextView")).click();
	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_amt_loan")));
		driver.findElement(By.id("com.SIBMobile:id/edt_amt_loan")).sendKeys("1000");
		driver.findElement(By.id("com.SIBMobile:id/edt_intrate")).sendKeys("10");
		driver.findElement(By.id("com.SIBMobile:id/edt_tenure")).sendKeys("11");
		driver.findElement(By.id("com.SIBMobile:id/btn_continue")).click();
		Thread.sleep(4000);
		String EMIamt = driver.findElement(By.id("com.SIBMobile:id/emi")).getText();
		System.out.print("\n EMI amount --> " + EMIamt);
		Reporter.log("\n Validated -> EMI Calculator  ");
		softAssert.assertAll();
	}	

	
	public void Btn_home()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_home")));
			driver.findElement(By.id("com.SIBMobile:id/btn_home")).click();
	
	}
	
	public void Btn_Back() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().back();
	}
	
	
	
	
	
	//Debit account
		public void DebitAccount(String TranID) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_debitAc")));
		
		driver.findElement(By.id("com.SIBMobile:id/edt_debitAc")).click();
		Thread.sleep(2000);
		
		 List <WebElement> ID = driver.findElements(By.id("com.SIBMobile:id/tvSelect"));
		//List <WebElement> ID = driver.findElements(By.id("com.SIBMobile:id/tvHint"));
		
		 	for (WebElement webElement : ID) {
	         //System.out.println(webElement.getText());
	         
	           String val=webElement.getText();
	         //  System.out.println("Debit account is "+webElement.getText());
	        
	            if(val.replaceAll("\\s+", "").equalsIgnoreCase(TranID.replaceAll("\\s+", "")))
	            {
	      
	            	webElement.click();
	            
	            	 break;
	            }
	        }
		}
	
		
		//Deposit Account
		public void DebitAccountType(String TranID,String Type) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_debitAc")));
		
		driver.findElement(By.id("com.SIBMobile:id/edt_debitAc")).click();
		Thread.sleep(2000);
		
		List <WebElement> ID = driver.findElements(By.id("com.SIBMobile:id/tvHint"));
		
		
		 	for (WebElement webElement : ID) {

	         
	           String val=webElement.getText();
        
	            if(val.contains(Type))
	            {
	            	webElement.click();            
	            	 break;
	            }
	        }
		 	String AccTyp=driver.findElement(By.id("com.SIBMobile:id/edt_debitAc")).getText();
		 	System.out.println("Account Type is "+AccTyp);
		 	if(AccTyp.replaceAll("\\s+", "").contains(TranID))
		 	{
		 		System.out.println("Account number selected  correctly");
		 	}
		 	else
		 	{
		 		System.out.println("Account number not selected  correctly");
		 	}
		 	
		}
		//Deposit Amount
public void DepositAmt(String amt)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_depositamount")));
			driver.findElement(By.id("com.SIBMobile:id/edt_depositamount")).sendKeys(amt);
			
}
//Deposit Period	 
public void DepositPeriod(String Typ,String num)	
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	System.out.println("Deposit Period Type "+Typ);
	System.out.println("Deposit Period num "+num);
	if(Typ.contentEquals("Months")) {
		
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_month")));
			driver.findElement(By.id("com.SIBMobile:id/edt_month")).click();
			driver.findElement(By.id("com.SIBMobile:id/edt_month")).sendKeys(num);
			driver.navigate().back();
}
else if(Typ.contains("Days"))
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_days")));
	driver.findElement(By.id("com.SIBMobile:id/edt_days")).click();
	driver.findElement(By.id("com.SIBMobile:id/edt_days")).sendKeys(num);
	driver.navigate().back();
	}
else if(Typ.contains("Years"))
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_year")));
	driver.findElement(By.id("com.SIBMobile:id/edt_year")).click();
	driver.findElement(By.id("com.SIBMobile:id/edt_year")).sendKeys(num);
	driver.navigate().back();
	}
}
		 
			//Interest Credit Frequency
public void InterestCreditFre(String IntCre) throws InterruptedException	
{
		
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_credit_frequency")));	
			driver.findElement(By.id("com.SIBMobile:id/edt_credit_frequency")).click();
			Thread.sleep(2000);
			 List <WebElement>fre  = driver.findElements(By.id("com.SIBMobile:id/tvSelect"));
			 	for (WebElement webElement : fre) {
		         //  System.out.println(webElement.getText());
		           String val=webElement.getText();
		            if(val.equalsIgnoreCase(IntCre))
		            {
		            	webElement.click();
		            break;
		            }
		        }
			
}
//Closure Type
public void ClosureType(String closure)	
{
		
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			
		System.out.println("Closure Type is "+closure);
			 if(closure.contains("Auto Renew"))	
			 {
				 driver.findElement(By.id("com.SIBMobile:id/autorenew")).click();
			 }
			 else if(closure.contains("Auto Closure"))
			 {
				 driver.findElement(By.id("com.SIBMobile:id/autoclosure")).click();
			 }
}

		//Add Nominee
public void Nominee(String nomi)	
{
		
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			 if(nomi.contains("Yes"))
				{
				
					driver.findElement(By.id("com.SIBMobile:id/switch_addnominee")).click();
					wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_nomineename")));
					driver.findElement(By.id("com.SIBMobile:id/edt_nomineename")).click();
					driver.findElement(By.id("com.SIBMobile:id/edt_nomineename")).sendKeys("Test Name");
					driver.navigate().back();
			
					GenericFunction.ScrollDown(driver);			
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_nomineeaddress")));
				driver.findElement(By.id("com.SIBMobile:id/edt_nomineeaddress")).click();
					driver.findElement(By.id("com.SIBMobile:id/edt_nomineeaddress")).sendKeys("Test Address");
					driver.navigate().back();
					driver.findElement(By.id("com.SIBMobile:id/edt_nomineepincode")).sendKeys("123456");			
				}
			 else
			 {
				 System.out.println("Nominee NO");
			 }
	}

public void NomineeMinor(String minor)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	 if(minor.contains("Yes"))
		{
		 	System.out.println("Minor Nominee yes"); 
			driver.findElement(By.id("com.SIBMobile:id/switch_minor")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_nomineedob")));
			driver.findElement(By.id("com.SIBMobile:id/edt_nomineedob")).click();	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/button1")));
			driver.findElement(By.id("android:id/button1")).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_guardianname")));
			driver.findElement(By.id("com.SIBMobile:id/edt_guardianname")).sendKeys("Test Guardian");
			GenericFunction.ScrollDown(driver);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_guardianaddress")));
			driver.findElement(By.id("com.SIBMobile:id/edt_guardianaddress")).sendKeys("Guardian Address");	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_guardianpincode")));
			driver.findElement(By.id("com.SIBMobile:id/edt_guardianpincode")).sendKeys("456789");	    
		}
	 else
	 {
		 System.out.println("Minor Nominee is NO");
	 }

	}
//Apply Promo Code
public void PromoCode(String Pro)	
{	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			 if(Pro.contains("Yes"))
				{
				System.out.println("Promocode Yes");
				driver.findElement(By.id("com.SIBMobile:id/switch_promocode")).click();				
					driver.findElement(By.id("com.SIBMobile:id/edt_promo")).sendKeys("123456");
					GenericFunction.ScrollDown(driver);
				}
			 else
			 {
				 System.out.println("Promo Code NO");
			 }
}
//Terms&Condition
public void TermsCon() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/termsCondition")));
	driver.findElement(By.id("com.SIBMobile:id/termsCondition")).click();
	GenericFunction.ScrollDown(driver);
	
	}

//Proceed
public void Btn_Proceed()
{
GenericFunction.ScrollDown(driver);
driver.findElement(By.id("com.SIBMobile:id/btn_proceed")).click();
}

//Review your request
public void Review() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
		Thread.sleep(8000);
		String Review=driver.findElement(By.id("com.SIBMobile:id/confirm_title")).getText();
	
		softAssert.assertEquals(Review, "Review your Request");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_submit")));
		driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
		softAssert.assertAll();
}
//Mpin 
public void Mpin(String mpin) throws InterruptedException
{
		
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/mpinView")));
		driver.findElement(By.id("com.SIBMobile:id/mpinView")).sendKeys(mpin);	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_submit")));
		driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
}

//Validation
public void Validation(int row,int col) throws InterruptedException, IOException
{

	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
			Thread.sleep(40000);
			String suc=driver.findElement(By.id("com.SIBMobile:id/status_title")).getText();
				softAssert.assertEquals(suc, "Successful!!");
			String textMesg = driver.findElement(By.id("com.SIBMobile:id/status_message")).getText();	
			 String Ref=textMesg.substring(textMesg.length()-16, textMesg.length());
			 System.out.print("Refrence  ID  "+Ref);
			 Reporter.log("Reference ID :"+Ref);	 
			 String tranID=textMesg.substring(textMesg.length()-47, textMesg.length()-30);
			 
			 System.out.print("Transaction ID  "+tranID);
			 
			 String FinalTranID=tranID.substring(0, 4)+" "+tranID.substring(tranID.length()-13, tranID.length()-9)+" "+tranID.substring(tranID.length()-9, tranID.length()-5)+" "+tranID.substring(tranID.length()-5, tranID.length());
			 System.out.println("Final Transaction ID : " +FinalTranID);
		
			 ExcelDataConfig.writeExcel1(FinalTranID, row, col);
			 Reporter.log("Transaction ID :"+tranID);
			 softAssert.assertAll();
	}

public void FlexiAccount() throws InterruptedException {
	
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
	driver.findElement(Depo).click();
	Thread.sleep(2000);
	
	//Title
	String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Deposits Title --> " +depoTitle);
	softAssert.assertEquals(depoTitle, "Deposits");
//Flexi Account
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/flexideposit")));
	driver.findElement(By.id("com.SIBMobile:id/flexideposit")).click();
	Thread.sleep(2000);

	//pop up close
	Thread.sleep(9000);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.ImageView[2]")).click();
	Thread.sleep(4000);
	
//Flexi opening
	String fl=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
	System.out.println("Flexi Title --> " +fl);
	softAssert.assertEquals(fl, "Flexi Deposit");
	softAssert.assertAll();
	
}

public void TaxSaver() throws InterruptedException
{
	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		SoftAssert softAssert = new SoftAssert();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
		driver.findElement(Depo).click();
		Thread.sleep(5000);
		
		//Title
		String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
		System.out.println("Deposits Title --> " +depoTitle);
		softAssert.assertEquals(depoTitle, "Deposits");
		Thread.sleep(2000);
		System.out.print("Deposit title is "+depoTitle);
//Tax Saver Account
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/taxsaver")));
		driver.findElement(By.id("com.SIBMobile:id/taxsaver")).click();
		Thread.sleep(12000);

		//pop up close
		Thread.sleep(9000);
		driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.ImageView[2]")).click();
		Thread.sleep(4000);
		
//Tax Saver account opening
		String ts=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
		System.out.println("Tax saver Title --> " +ts);
		softAssert.assertEquals(ts, "Tax Saver");
		softAssert.assertAll();
	}

//Fixed Deposit
public void FixedDeposit() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
	driver.findElement(Depo).click();
	Thread.sleep(2000);
	
	//Title
	String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Deposits Title --> " +depoTitle);
	softAssert.assertEquals(depoTitle, "Deposits");
//Fixed Deposit
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/fixeddeposit")));
	driver.findElement(By.id("com.SIBMobile:id/fixeddeposit")).click();
	Thread.sleep(2000);

	//pop up close
	Thread.sleep(9000);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.ImageView[2]")).click();
	Thread.sleep(4000);
	
//FD opening
	String fd=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
	System.out.println("FD Title --> " +fd);
	softAssert.assertEquals(fd, "Fixed Deposits");
	softAssert.assertAll();
	}

public void SIBDreams(String amt, String Typ,String num) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
	driver.findElement(Depo).click();
	Thread.sleep(3000);
	
	//Title
	String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Deposits Title --> " +depoTitle);
	softAssert.assertEquals(depoTitle, "Deposits");
//SIB Dreams
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/sibdream")));
	driver.findElement(By.id("com.SIBMobile:id/sibdream")).click();
	Thread.sleep(2000);
	//Title
	String dreams=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("SIB Dreams Title --> " +dreams);
	softAssert.assertEquals(dreams, "SIB Dream");
	//Amount
	driver.findElement(By.id("com.SIBMobile:id/lblenterAmt")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_depositamount")));
	driver.findElement(By.id("com.SIBMobile:id/edt_depositamount")).click();
	driver.findElement(By.id("com.SIBMobile:id/edt_depositamount")).clear();
	driver.findElement(By.id("com.SIBMobile:id/edt_depositamount")).sendKeys(amt);
	driver.navigate().back();
	//Month
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_month")));
	//driver.findElement(By.id("com.SIBMobile:id/edt_month")).click();
	//driver.findElement(By.id("com.SIBMobile:id/edt_month")).sendKeys(mnt);
	//driver.navigate().back();
	System.out.println("Deposit Period Type "+Typ);
	System.out.println("Deposit Period num "+num);
	if(Typ.contentEquals("Months")) {
		
	
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_month")));
			driver.findElement(By.id("com.SIBMobile:id/edt_month")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.SIBMobile:id/edt_month")).sendKeys(num);
			driver.navigate().back();
}
else if(Typ.contains("Days"))
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_days")));
	driver.findElement(By.id("com.SIBMobile:id/edt_days")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("com.SIBMobile:id/edt_days")).sendKeys(num);
	driver.navigate().back();
	}
	//Continue
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_continue")));
	driver.findElement(By.id("com.SIBMobile:id/btn_continue")).click();
	//Data
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/intRate")));
	System.out.print("Interest Rate "+driver.findElement(By.id("com.SIBMobile:id/intRate")).getText());
	Reporter.log("Interest Rate "+driver.findElement(By.id("com.SIBMobile:id/intRate")).getText());
	System.out.print("Interest Benefits "+driver.findElement(By.id("com.SIBMobile:id/intBenefit")).getText());
	Reporter.log("Interest Benefits "+driver.findElement(By.id("com.SIBMobile:id/intBenefit")).getText());
	System.out.print("Monthly Contribution "+driver.findElement(By.id("com.SIBMobile:id/monthlyReq")).getText());
	Reporter.log("Monthly Contribution "+driver.findElement(By.id("com.SIBMobile:id/monthlyReq")).getText());
	driver.findElement(By.id("com.SIBMobile:id/btn_invest")).click();
	//pop up close
	Thread.sleep(5000);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.ImageView[2]")).click();
	Thread.sleep(4000);
	
//Recurring Deposit opening
	String Recur=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();

	softAssert.assertEquals(Recur, "Recurring Deposit");
	softAssert.assertAll();
	}
public void RecurringDeposit() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
	driver.findElement(Depo).click();
	Thread.sleep(2000);
	
	//Title
	String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Deposits Title --> " +depoTitle);
	softAssert.assertEquals(depoTitle, "Deposits");
//Recurring Deposit
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/recurringdepsit")));
	driver.findElement(By.id("com.SIBMobile:id/recurringdepsit")).click();

	//pop up close
	Thread.sleep(9000);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.ImageView[2]")).click();
	Thread.sleep(4000);
//RD Title
	String rd=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
	System.out.println("RD Title --> " +rd);
	softAssert.assertEquals(rd, "Recurring Deposits");
}


//Fixed Deposit
public void SIBMaximoDeposit() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
	driver.findElement(Depo).click();
	Thread.sleep(2000);

	String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Deposits Title --> " +depoTitle);
	softAssert.assertEquals(depoTitle, "Deposits");

	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/maximo")));
	driver.findElement(By.id("com.SIBMobile:id/maximo")).click();
	Thread.sleep(2000);

	//pop up close
	Thread.sleep(9000);
	driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.ImageView[2]")).click();
	Thread.sleep(4000);
	
	
	
	//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
	String Error_Msg= driver.findElement(By.id("android:id/message")).getText();
	System.out.println("Error Message "+Error_Msg);
	softAssert.assertEquals(Error_Msg, "SIB MAXIMO is not offered to staff and retired staff");
	driver.switchTo().alert().accept();

	softAssert.assertAll();
	}




public void LoanAgainstDeposit() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
	driver.findElement(Depo).click();
	Thread.sleep(2000);
	
	//Title
	String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Deposits Title --> " +depoTitle);
	softAssert.assertEquals(depoTitle, "Deposits");
//Loan Against Deposit
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/loanagainstdepo")));
	driver.findElement(By.id("com.SIBMobile:id/loanagainstdepo")).click();
	Thread.sleep(3000);
	//Title
	String lad=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Loan Against Deposit Title --> " +lad);
	softAssert.assertEquals(lad, "Loan Against Deposit");
	

		/*	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_debitAc")));	
			driver.findElement(By.id("com.SIBMobile:id/edt_debitAc")).click();
			Thread.sleep(2000);
			 List <WebElement>fre  = driver.findElements(By.id("com.SIBMobile:id/tvSelect"));
			 	for (WebElement webElement : fre) {
		         System.out.println(webElement.getText());
		           String val=webElement.getText();
		            if(val.equalsIgnoreCase(DepAcc))
		            {
		            	webElement.click();
		            break;
		            }
		        }
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_creditAc")));	
				driver.findElement(By.id("com.SIBMobile:id/edt_creditAc")).click();
				Thread.sleep(2000);
				 List <WebElement>fre1  = driver.findElements(By.id("com.SIBMobile:id/tvSelect"));
				 	for (WebElement webElement1 : fre1) {
			          System.out.println(webElement1.getText());
			           String val=webElement1.getText();
			            if(val.equalsIgnoreCase(CreAcc))
			            {
			            	webElement1.click();
			            break;
			            }
			        }*/		 
	softAssert.assertAll();
}
public void BTN_FetchDetails()
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_continue")));	
	driver.findElement(By.id("com.SIBMobile:id/btn_continue")).click();
	
	}

public void KNDRenewal(String Renewal)
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/option1")));
	if(Renewal.contains("PI"))
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/option1")));
		driver.findElement(By.id("com.SIBMobile:id/option1")).click();
	}
	else if(Renewal.contains("P"))
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/option2")));
		driver.findElement(By.id("com.SIBMobile:id/option2")).click();
	}
	GenericFunction.ScrollDown(driver);
		
	}

public void TermsCon2() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/termsCondition")));
	driver.findElement(By.id("com.SIBMobile:id/termsCondition")).click();
	//GenericFunction.ScrollDown(driver);
	}
public void BTN_Proceed() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_proceed")));
	driver.findElement(By.id("com.SIBMobile:id/btn_proceed")).click();
	//GenericFunction.ScrollDown(driver);
	}
public void ladvalidation(String DepoTyp) throws InterruptedException
{
	Thread.sleep(20000);
	SoftAssert softAssert = new SoftAssert();
	String status = driver.findElement(By.id("com.SIBMobile:id/status_title")).getText();
	System.out.println("Status is "+status);
	if(DepoTyp.equalsIgnoreCase("Flexi"))
	{
		softAssert.assertEquals(status, "Sorry Try Again!");
	}
	else if(DepoTyp.equalsIgnoreCase("Recurring"))
	{
		softAssert.assertEquals(status, "Successful!!");
	}
	else if(DepoTyp.equalsIgnoreCase("Fixed"))
	{
		
		softAssert.assertEquals(status, "Successful!!");
	}
	softAssert.assertAll();
}
public void DepositClosure() throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	wait.until(ExpectedConditions.visibilityOfElementLocated(Depo));
	driver.findElement(Depo).click();
	Thread.sleep(4000);
	
	//Title
	String depoTitle=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	System.out.println("Deposits Title --> " +depoTitle);
	softAssert.assertEquals(depoTitle, "Deposits");
	Thread.sleep(2000);
//Loan Against Deposit
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/depositclosure")));
	driver.findElement(By.id("com.SIBMobile:id/depositclosure")).click();
	Thread.sleep(4000);
	//Title
	String dc=driver.findElement(By.id("com.SIBMobile:id/title")).getText();
	Thread.sleep(2000);
	System.out.println(" Deposit Closure Title --> " +dc);
	softAssert.assertEquals(dc,"Deposit Closure");
	softAssert.assertAll();
	
}
public void DebCreAccount(String DepAcc, String CreAcc) throws InterruptedException
{
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	 boolean debit=false;
	 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_debitAc")));	
			driver.findElement(By.id("com.SIBMobile:id/edt_debitAc")).click();
			Thread.sleep(2000);

			while(debit!=true)
			 {
			Thread.sleep(1000);
			 List <WebElement>fre  = driver.findElements(By.id("com.SIBMobile:id/tvSelect"));
			
			 	for (WebElement webElement : fre) {
		     
		           String val=webElement.getText();
		          // System.out.println("Debit Account  is "+DepAcc);
		          // System.out.println("Value is          "+val);	         
		           if(val.replaceAll("\\s+", "").equalsIgnoreCase(DepAcc.replaceAll("\\s+", "")))
		            {
		            	webElement.click();
		            	System.out.println("Successfully clicked element");
		            	debit=true;
		            break;
		            } 	
		        //  System.out.println("Outside the loopss 1");
			}
			 	if(debit!=true)
			 	{
			 	 //System.out.println("Outside the loopss 2");
			 	GenericFunction.ScrollDown2(driver);
			 	}
			 	
			 	
			}
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_creditAc")));	
				driver.findElement(By.id("com.SIBMobile:id/edt_creditAc")).click();
				Thread.sleep(2000);
				 List <WebElement>fre1  = driver.findElements(By.id("com.SIBMobile:id/tvSelect"));
				 	for (WebElement webElement1 : fre1) {
			           String val1=webElement1.getText();
			           if(val1.replaceAll("\\s+", "").equalsIgnoreCase(CreAcc.replaceAll("\\s+", "")))
			            {
			            	webElement1.click();
			            break;
			            }
			        }	
				 	softAssert.assertAll();				 	
			}

public void DebCreAccount1(String DepAccT, String CreAccT) throws InterruptedException
{
	
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	 boolean debit=false;
	 
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_debitAc")));	
			driver.findElement(By.id("com.SIBMobile:id/edt_debitAc")).click();
			Thread.sleep(2000);

			while(debit!=true)
			 {
			Thread.sleep(1000);
			List <WebElement> fre = driver.findElements(By.id("com.SIBMobile:id/tvHint"));
			
			 	for (WebElement webElement : fre) {
		     
		           String val=webElement.getText();
		         //  System.out.println("Debit Account  is "+DepAccT);
		         //  System.out.println("Value is          "+val);	         
		           if(val.contains(DepAccT))
		            {
		            	webElement.click();
		            	System.out.println("Successfully clicked element");
		            	debit=true;
		            break;
		            } 	
		        //  System.out.println("Outside the loopss 1");
			}
			 	if(debit!=true)
			 	{
			 	// System.out.println("Outside the loopss 2");
			 	GenericFunction.ScrollDown2(driver);
			 	}
			 	
			 	
			}
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/edt_creditAc")));	
			driver.findElement(By.id("com.SIBMobile:id/edt_creditAc")).click();
			Thread.sleep(2000);
			List <WebElement> fre1 = driver.findElements(By.id("com.SIBMobile:id/tvHint"));
			 	for (WebElement webElement1 : fre1) {
		           String val1=webElement1.getText();
		           if(val1.contains(CreAccT))
		            {
		            	webElement1.click();
		            break;
		            }
		        }	
			 	softAssert.assertAll();			 	
			}

public void DepClosureError(String DepoTyp) throws InterruptedException
{
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	SoftAssert softAssert = new SoftAssert();
	if(DepoTyp.equalsIgnoreCase("Flexi"))
	{
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
		String FlexiErrorMesg=driver.findElement(By.id("android:id/message")).getText();
		System.out.println("Error message while closing flexi deposit : "+FlexiErrorMesg);
		softAssert.assertEquals(FlexiErrorMesg, "The online operations are not permitted for FFD accounts.");
		//driver.findElement(By.id("android:id/button1")).click();
		
	}
	else if(DepoTyp.equalsIgnoreCase("Lein"))
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
		String FlexiErrorMesg=driver.findElement(By.id("android:id/message")).getText();
		System.out.println("Error message while closing flexi deposit : "+FlexiErrorMesg);
		softAssert.assertEquals(FlexiErrorMesg, "Online Term Deposit Premature closure is not allowed since lien exist");
		//driver.findElement(By.id("android:id/button1")).click();
		
	}
	
	}

public void DepAcc_Lein()
{
	
	String DebAcc=driver.findElement(By.id("com.SIBMobile:id/edt_debitAc")).getText();
	System.out.println("Debit Account in loan against deposit : "+DebAcc);
	
	}

public void DepClosureErrorOk()
{
	
	driver.findElement(By.id("android:id/button1")).click();
	}

public void DepClosureValidation(String DepoTyp) throws InterruptedException
{
	Thread.sleep(20000);
	SoftAssert softAssert = new SoftAssert();
	String status = driver.findElement(By.id("com.SIBMobile:id/status_title")).getText();
	System.out.println("Status is "+status);
	if(DepoTyp.equalsIgnoreCase("Flexi"))
	{
		softAssert.assertEquals(DepoTyp, "Sorry Try Again!");
	}
	else if(DepoTyp.equalsIgnoreCase("Recurring"))
	{
		
		softAssert.assertEquals(status, "Successful!!");
		
	}
	else if(DepoTyp.equalsIgnoreCase("Fixed"))
	{
		
		softAssert.assertEquals(status, "Successful!!");
	}
	softAssert.assertAll();
}
public void DepClosureNRE_Error()
{
	SoftAssert softAssert = new SoftAssert();
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("android:id/message")));
	String Error_Msg= driver.findElement(By.id("android:id/message")).getText();
	System.out.println("Error Message "+Error_Msg);
	driver.switchTo().alert().accept();
	
	//softAssert.assertEquals(Error_Msg, "NRE recurring deposits can be allowed only after 1 year from account opening date");
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("BTN_FetchDetails")));
	//driver.findElement(By.id("BTN_FetchDetails")).click();
	}
public void DOB_Ash(String y, String monDir, String num) throws InterruptedException
{
	
	driver.findElement(By.id("com.SIBMobile:id/edt_dobvalidation")).click();
	driver.findElement(By.id("android:id/date_picker_header_year")).click();
	 boolean year=false;
	while(year!=true)
	 {
	Thread.sleep(1000);
	 List <WebElement>yr  = driver.findElements(By.id("android:id/text1"));
	
	 	for (WebElement webElement : yr) {
    
          String val=webElement.getText();
        System.out.println("Year  is "+y);
          System.out.println("Value is          "+val);	         
          if(val.equalsIgnoreCase(y))
           {
           	webElement.click();
           	System.out.println("Successfully clicked element");
           	year=true;
           break;
           } 	
        // System.out.println("Outside the loopss 1");
         
	}
	 	if(year!=true)
	 	{
	 	// System.out.println("Outside the loopss 2");
	 	// driver.switchTo().alert();
	 	// System.out.println("Outside the loopss 3");
	 	GenericFunction.ScrollUp(driver);
		// System.out.println("Outside the loopss 4");
	 	}
	 	 	
	}
	if(monDir.contains("Next"))
	{
		 int intnum= Integer.parseInt(num);
		for(int i=0;i<intnum;i++)
		{
		driver.findElement(By.id("android:id/next")).click();
		}
	}
	else if(monDir.contains("Back"))
	{ int intnum= Integer.parseInt(num);
	for(int i=0;i<intnum;i++)
	{
	driver.findElement(By.id("android:id/prev")).click();
	}
	}
	Thread.sleep(2000);
	driver.findElement(By.xpath("//android.view.View[@content-desc=\"28 July 1961\"]")).click();
	Thread.sleep(2000);
	driver.findElement(By.id("android:id/button1")).click();
	Thread.sleep(3000);
	}

}

