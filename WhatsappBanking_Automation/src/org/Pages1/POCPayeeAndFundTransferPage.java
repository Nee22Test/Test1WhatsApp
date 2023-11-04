package org.Pages1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;

public class POCPayeeAndFundTransferPage {
	AndroidDriver driver;
	WebDriver drivers;
	By FundTran = By.xpath("//android.widget.FrameLayout[@content-desc=\"Fund Transfer\"]/android.widget.ImageView");
	

	public POCPayeeAndFundTransferPage(AndroidDriver driver) {
		this.driver = driver;
		

	}

	public void FundTransfer_Title() throws InterruptedException {
		
	
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		SoftAssert softassert= new SoftAssert();
		wait.until(ExpectedConditions.visibilityOfElementLocated(FundTran));
		driver.findElement(FundTran).click();
		Thread.sleep(7000);
		String ft = driver.findElement(By.id(
				"com.SIBMobile:id/title")).getText();
		System.out.println("Fund Transfer title is "+ft);
		softassert.assertEquals(ft, "Fund Transfer");
		Thread.sleep(2000);
		softassert.assertAll();
		
}
	public void PayeeAndSchedule_AddPayee(String AccNo,String PayNam) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		SoftAssert softassert= new SoftAssert();
		//Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/lblPayeeList1")));
		driver.findElement(By.id("com.SIBMobile:id/lblPayeeList1")).click();
		Thread.sleep(4000);
		//Add Payee
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/addPayee")));	
		driver.findElement(By.id("com.SIBMobile:id/addPayee")).click();
		Thread.sleep(4000);
		//Add Payee - SIB Account
		driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc=\"SIB Accounts\"]/android.widget.TextView")).click();
		Thread.sleep(4000);
		
		driver.findElement(By.id("com.SIBMobile:id/edt_benf_account")).sendKeys(AccNo);
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/textinput_placeholder")).click();
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.sendKeys(PayNam).perform();
		Thread.sleep(2000);
		//Select Friends
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/friends")));	
		
		driver.findElement(By.id("com.SIBMobile:id/friends")).click();
		Thread.sleep(2000);
		driver.navigate().back();	
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_submit")));	
		
		driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
		Thread.sleep(3000);
	}
	
	public void Btn_Submit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
		Thread.sleep(3000);
		
	}
	
	public void mPin(String pin) throws InterruptedException
	{
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/mpinView")));	
		
		driver.findElement(By.id("com.SIBMobile:id/mpinView")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("com.SIBMobile:id/mpinView")).sendKeys(pin);
		Thread.sleep(3000);
	}
	public void mPinFT(String pin) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		Thread.sleep(4000);
		driver.navigate().back();
		driver.findElement(By.id("com.SIBMobile:id/mpinView")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/mpinView")));	
		
		Thread.sleep(3000);
		driver.findElement(By.id("com.SIBMobile:id/mpinView")).sendKeys(pin);
		Thread.sleep(3000);
	}
	
	public void ReviewConfirm() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
		Thread.sleep(3000);
	}	
	
	public void StatusValidationPayee() throws InterruptedException
	{
		Thread.sleep(3000);
		String status = driver.findElement(By.id("com.SIBMobile:id/status_title")).getText();
		System.out.println("Payee Status :"+status);
		
		Thread.sleep(2000);
	}
	
		public void StatusValidationTran() throws InterruptedException
		{
			Thread.sleep(7000);
			String status = driver.findElement(By.id("com.SIBMobile:id/status_title")).getText();
			System.out.println("Transation Status :"+status);
			String tranID=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[3]/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView")).getText();
			System.out.println("Transation  ID - "+tranID);
			Reporter.log("Transation  ID - "+tranID);
			Thread.sleep(2000);
			String refID=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.widget.RelativeLayout[3]/android.widget.ScrollView/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout[5]/android.widget.RelativeLayout/android.widget.TextView")).getText();
			System.out.println("Reference ID - "+refID);
			Reporter.log("Reference ID - "+refID);
			Thread.sleep(2000);
		}
		public void BTN_Home() throws InterruptedException
		{
			Thread.sleep(2000);
			driver.findElement(By.id("com.SIBMobile:id/btn_home")).click();
			Thread.sleep(4000);
			
		}
		
		//FundTransfer
		public void FundTransfer(String amt) throws InterruptedException
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			Thread.sleep(5000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/transfer")));	
			
			driver.findElement(By.id("com.SIBMobile:id/transfer")).click();
			Thread.sleep(4000);
			//Enter Amount
			driver.findElement(By.id("com.SIBMobile:id/edt_amount")).sendKeys(amt);
			Thread.sleep(4000);
		
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_transfer")));	
			
			driver.findElement(By.id("com.SIBMobile:id/btn_transfer")).click();
			//Confirm
			Thread.sleep(2000);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_submit")));	
			
			driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
			Thread.sleep(2000);
		}
	
		public void delete_Payee() throws InterruptedException
		{
			// Navigate to fundTransfer
			Thread.sleep(2000);
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
			driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Fund Transfer\"]/android.widget.ImageView")).click();
			Thread.sleep(4000);
		//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/lblPayeeList1")));	
			
			//Navigate to funds and schedules from fund transfer
			driver.findElement(By.id("com.SIBMobile:id/lblPayeeList1")).click();
			Thread.sleep(4000);
			//Payee List
			String PayeeName=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).getText();
			System.out.println("Payee Name is "+PayeeName);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.LinearLayout/android.widget.RelativeLayout[2]/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.TextView[1]")).click();
			Thread.sleep(4000);
		}
		public void BTN_delete() throws InterruptedException
		{
			//View Payee -- click delete
			
			driver.findElement(By.id("com.SIBMobile:id/lbldelete")).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			Thread.sleep(3000);
		}
		public void Delete_Confirm() throws InterruptedException
		{
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().accept();
		
		}
}