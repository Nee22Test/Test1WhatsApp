package org.Pages1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import io.appium.java_client.android.AndroidDriver;

public class AccountsPage {
	AndroidDriver driver;
	WebDriver drivers;
	By Accounts = By.id("com.SIBMobile:id/lblmenu1");
	

	public AccountsPage(AndroidDriver driver) {
		this.driver = driver;
		

	}

	public void Validate_AccountDetails() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Accounts));
		SoftAssert softassert = new SoftAssert();
		
		driver.findElement(Accounts).click();
		Thread.sleep(6000);
		String acc = driver.findElement(By.id("com.SIBMobile:id/title")).getText();
		System.out.println("Accounts title is "+acc);
		softassert.assertEquals(acc, "Accounts");
		softassert.assertAll();
		
		Thread.sleep(2000);
		String AccBal = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")).getText();
		System.out.println("Account balance  "+AccBal);
		Reporter.log("Account Balance --> "+AccBal);
		Thread.sleep(2000);
		String Elock= driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/androidx.viewpager.widget.ViewPager/android.widget.ScrollView/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/androidx.cardview.widget.CardView/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
		System.out.println("ELock Status  "+Elock);
		Reporter.log("Elock Status -->  "+Elock);
	}
	public void BTN_back() throws InterruptedException {
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(5000);
		
		
	}

	
}
