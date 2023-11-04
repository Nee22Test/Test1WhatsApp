
	package org.TestScenarioStaff;

	import java.io.IOException;

import org.Base1.DriverInstance1;
import org.Pages1.AccountsPage;
import org.Pages1.POCPayeeAndFundTransferPage;
import org.Pages1.PreLoginPage;
import org.Pages1.RegistrationPage;
import org.Utility1.ExcelDataConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

	public class TS01_TC01_Login_PreLoginRegistrationValidation  extends DriverInstance1 {
		//@Test(groups = {"PreValidation","Smoke Testing" })
		@Test(priority=0)
		
		public void TC01_PreLoginValidation() throws InterruptedException {
		
			System.out.println("Testing in progress");
			Thread.sleep(20000);
			driver.findElement(By.className("selectable-text copyable-text iq0m558w g0rxnol2")).click();
			System.out.println("Testing in progress 2");
			driver.findElement(By.className("selectable-text copyable-text iq0m558w g0rxnol2")).sendKeys("SIB WhatsApp");
			driver.findElement(By.xpath("//span[contains(text(), 'Welcome to Whatsapp Banking by South Indian Bank.')]")).click();
			Thread.sleep(2000);
			
		}
//@Test(groups = {"PreValidation","Smoke Testing" })
						
	}

	
	
	
	


