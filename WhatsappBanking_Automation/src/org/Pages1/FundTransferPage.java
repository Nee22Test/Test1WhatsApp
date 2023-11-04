package org.Pages1;

import java.time.Duration;
import java.util.List;

import org.Utility1.GenericFunction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;

public class FundTransferPage {
	AndroidDriver driver;
	WebDriver drivers;
	By FundTran = By.xpath("//android.widget.FrameLayout[@content-desc=\"Fund Transfer\"]/android.widget.ImageView");
	By TransInstly =By.id("com.SIBMobile:id/lblInstantTrf1");
	By DebAcc=By.id("com.SIBMobile:id/edt_debitAc");
	By AccountTyp_SIB= By.xpath("//android.widget.LinearLayout[@content-desc=\\\"SIB Accounts\\\"]/android.widget.TextView");
	By BeneficiaryAcc = By.id("com.SIBMobile:id/edt_creditAc_Oth");
	By ifscDet=By.id("com.SIBMobile:id/edt_benf_ifsc");
	By BenefName=By.id("com.SIBMobile:id/edt_benf_name_Oth");
	By Amt=By.id("com.SIBMobile:id/edt_amount");
	By ProCd = By.id("com.SIBMobile:id/promoSwitch");
	By SavPaye= By.id("com.SIBMobile:id/benefSwitch");
	By Btn_TransferNow = By.id("com.SIBMobile:id/btn_transfer");
	By Btn_Schedule = By.id("com.SIBMobile:id/btn_schedule");

	public FundTransferPage(AndroidDriver driver) {
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
	public void Btn_Back() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
	}
	public void TransferInstantly_Title() throws InterruptedException {
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		SoftAssert softassert= new SoftAssert();
		wait.until(ExpectedConditions.visibilityOfElementLocated(TransInstly));
		driver.findElement(TransInstly).click();
		Thread.sleep(7000);
		String ft = driver.findElement(By.id("com.SIBMobile:id/lblchooseCreditAc")).getText();
		System.out.println("Transfer Instantly navigation: "+ft);
		softassert.assertEquals(ft, "Credit Account Details");
		Thread.sleep(2000);
		softassert.assertAll();
}
	
	public void AccountType(String typ) throws InterruptedException
	{
		//WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(AccountTyp_SIB));
		Thread.sleep(1000);
		if(typ.equalsIgnoreCase("Other Banks"))
				{
			System.out.println("Navigated to Other Banks");
				}
		else if(typ.equalsIgnoreCase("SIB Accounts"))
		{
			driver.findElement(AccountTyp_SIB).click();
			System.out.println("Navigated to SIB Accounts");
		}	
	}
	
	public void DebitAccount(String TranID,String Type) throws InterruptedException
	{
		
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(DebAcc));
		
		driver.findElement(DebAcc).click();
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
		 	String AccTyp=driver.findElement(DebAcc).getText();
		 	System.out.println("Account Type is "+AccTyp);
		 	if(AccTyp.replaceAll("\\s+", "").contains(TranID))
		 	{
		 		System.out.println("Debit Account number is selected");
		 	}
		 	else
		 	{
		 		System.out.println("Debit Account number is not selected");
		 	}
		}
	
	public void BeneficiaryAccNo(String BenficAcc)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(BeneficiaryAcc));
		driver.findElement(BeneficiaryAcc).click();
		driver.findElement(BeneficiaryAcc).sendKeys(BenficAcc);
	}
	
	public void ifscCode(String ifsc)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(ifscDet));
		driver.findElement(ifscDet).click();
		driver.findElement(ifscDet).sendKeys(ifsc);
	}
	public void BeneficiaryName(String name)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(BenefName));
		driver.findElement(BenefName).click();
		driver.findElement(BenefName).sendKeys(name);
	}
	public void Amount(String AmtVal)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Amt));
		driver.findElement(Amt).click();
		driver.findElement(Amt).sendKeys(AmtVal);
	}
	public void Remarks(String remarkTyp) throws InterruptedException
	{
		Thread.sleep(1000);
		if(remarkTyp.equalsIgnoreCase("Enter Manually"))
		{
			driver.findElement(By.id("com.SIBMobile:id/btn_manually")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("com.SIBMobile:id/edt_remarks")).click();
			driver.findElement(By.id("com.SIBMobile:id/edt_remarks")).sendKeys("Test Remarks");
			driver.navigate().back();
		}
		else if(remarkTyp.equalsIgnoreCase("Friends"))
		{
			driver.findElement(By.id("com.SIBMobile:id/friends")).click();
		}
		else if(remarkTyp.equalsIgnoreCase("Family"))
		{
			driver.findElement(By.id("com.SIBMobile:id/family")).click();
		}
		else if(remarkTyp.equalsIgnoreCase("Own Account"))
		{
			driver.findElement(By.id("com.SIBMobile:id/own_account")).click();
		}
		else if(remarkTyp.equalsIgnoreCase("More"))
		{
			driver.findElement(By.id("com.SIBMobile:id/moreIcon")).click();
			driver.navigate().back();
		}	
	}
	public void PromoCode(String status,String code)
	{
		if(status.equalsIgnoreCase("Yes"))
		{
			driver.findElement(ProCd).click();
			driver.findElement(By.id("com.SIBMobile:id/edt_promo")).sendKeys();
			driver.navigate().back();
			GenericFunction.ScrollDown(driver);	
		}
			
	}
	public void PayeeSave(String status,String nickName)
	{
		if(status.equalsIgnoreCase("Yes"))
		{
			driver.findElement(SavPaye).click();
			driver.findElement(By.id("com.SIBMobile:id/edt_benf_nick")).sendKeys(nickName);
			driver.navigate().back();
			GenericFunction.ScrollDown(driver);	
		}
			
	}
	
	public void Btn_TransferNow() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Btn_TransferNow));
		driver.findElement(Btn_TransferNow).click();
		Thread.sleep(3000);
	}
	
	public void Btn_Schedule() throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Btn_Schedule));
		driver.findElement(Btn_Schedule).click();
		Thread.sleep(3000);
	}
	
	public void ReviewPage_Btn_Confirm() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
		Thread.sleep(3000);
	}
	public void mPinFT(String pin) throws InterruptedException
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		Thread.sleep(4000);
		driver.findElement(By.id("com.SIBMobile:id/mpinView")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/mpinView")));	
		Thread.sleep(3000);
		driver.findElement(By.id("com.SIBMobile:id/mpinView")).sendKeys(pin);
		Thread.sleep(3000);
	}
	public void MPINPage_Btn_Submit() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/btn_submit")).click();
		Thread.sleep(3000);
	}
}
