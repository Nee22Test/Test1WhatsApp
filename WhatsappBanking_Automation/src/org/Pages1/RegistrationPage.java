package org.Pages1;

import java.io.IOException;
import java.time.Duration;

import org.Utility1.ExcelDataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


import io.appium.java_client.android.AndroidDriver;

public class RegistrationPage {
	AndroidDriver driver;
	WebDriver drivers;
	
	public String status;
	By RegisterNow = By.id("com.SIBMobile:id/btn_login");
	By AccountNo = By.id("com.SIBMobile:id/edt_shortaccountNumber");
	By MobileNumber = By.id("com.SIBMobile:id/edt_mobileNumber");
	By Otp=By.id("com.SIBMobile:id/btn_otp");
	By Submit=By.id("com.SIBMobile:id/btn_submit");
	By Password=By.id("com.SIBMobile:id/passwordlayout");
	By Bt_Login=By.id("com.SIBMobile:id/btn_login");
	
	
	public RegistrationPage(AndroidDriver driver) {
		this.driver = driver;
		

	}

	public void Validate_Register(String AccNo,String MobNum,String Username, int row, int col) throws InterruptedException, IOException {
	

		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterNow));
	driver.findElement(RegisterNow).click();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(AccountNo));
	driver.findElement(AccountNo).sendKeys(AccNo);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(MobileNumber));
	driver.findElement(MobileNumber).sendKeys(MobNum);
	
	driver.navigate().back();
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(Otp));
	driver.findElement(Otp).click();
	
	Thread.sleep(22000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(Submit));
	driver.findElement(Submit).click();
	Thread.sleep(2000);
	
	driver.switchTo().alert().accept();
	
	Thread.sleep(3000);
	if( driver.findElement(Password).isDisplayed()){
		String Uname = driver.findElement(By.id("com.SIBMobile:id/tvusername")).getText();
		System.out.println("Uname text is :"+Uname);
		System.out.println("Usename text is :"+Username);
		if(Username.contains(Uname))
		{
			status="Pass";
		Reporter.log("Registration --> Passed ");
		ExcelDataConfig.writeExcel1(status, row, col);
		
		}else{
		
			Reporter.log("Registration --> Failed ");
			Reporter.log("Invalid User");
			status="Fail";
			ExcelDataConfig.writeExcel1(status, row, col);
		}
	}
		else
		{
			Reporter.log("Registration --> Failed ");
			Reporter.log("Invalid screen navigation");
			status="Fail";
			ExcelDataConfig.writeExcel1(status, row, col);
		}
	
	}
	
	public void Validate_Login(String Pass,int row, int col) throws InterruptedException, IOException
	{
		
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Password));
		driver.findElement(Password).click();
		
		Actions action = new Actions(driver);
		action.sendKeys(Pass).perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(Bt_Login));
		driver.findElement(Bt_Login).click();
		
		Thread.sleep(9000);
		System.out.println("Logged in Text is " +driver.findElement(By.id("com.SIBMobile:id/userName")).getText());
		
		if( driver.findElement(By.id("com.SIBMobile:id/userName")).getText().contains("Uat")){

			System.out.println("Login is successful.");
		
			status="Pass";
			Reporter.log("Login --> Passed ");
			ExcelDataConfig.writeExcel1(status, row, col);
			}else{
				
				Reporter.log("Login --> Failed ");
				status="Fail";
				ExcelDataConfig.writeExcel1(status, row, col);
			}
	}
	public void Btn_Back() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
	}
	public void Btn_Login()
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(600));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.SIBMobile:id/btn_login")));
		driver.findElement(By.id("com.SIBMobile:id/btn_login")).click();
	
	}
	

	public void logout() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.id("com.SIBMobile:id/logout")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		System.out.println("Logged out");
		Thread.sleep(2000);
		
		}

}
