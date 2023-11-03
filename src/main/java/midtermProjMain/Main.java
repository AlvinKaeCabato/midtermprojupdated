package midtermProjMain;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import callPackage.DriverCallClass;
import io.appium.java_client.AppiumBy;
import platformPackage.AndroidClass;

public class Main extends AndroidInitialization {

	/*
	 * Temporary only 1 class, I am having errors with multiple classes in a suite
	 * where passing the driver to the next class becomes null even though I restarted the
	 * driver if detected as null.
	 */

	@Test(priority=1)
	public void waitforSplash() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		driverCallClass.isLoaded("com.androidsample.generalstore:id/toolbar_title");
		
	}
	
	
	@Test(priority=2)
	public void generalStoreInitial() {
		if(findTextViewWithName("General Store") == true) {
			System.out.println("General Store Splash opened");
		}else {
			System.out.println("App Not Opened");
		}
	}
	
	@Test(priority=3)
	public void selectCountry() {
		driverCallClass.clickOnElement(driverCallClass.country);
		//driverCallClass.androidScrollGestureUntil(driver.findElement(By.xpath("//android.widget.TextView[@text='Philippines']")));
		driverCallClass.scrollToText("Brazil");
		driverCallClass.clickOnElement(driver.findElement(By.xpath("//android.widget.TextView[@text='Brazil']")));
	}
	@Test(priority=3)
	public void enterName() {
		driverCallClass.typeText(driverCallClass.nameField,"Andrea Andes");
	}
	
	@Test(priority=3)
	public void selectGender() {
		driverCallClass.clickOnElement(driverCallClass.genderFemale);
	}
	
	@Test(priority=4)
	public void shopBegin() throws InterruptedException {
		driverCallClass.clickOnElement(driverCallClass.letsShopbtn);
		TimeUnit.SECONDS.sleep(5);
		String val=driverCallClass.getText(driverCallClass.loggedInHeader);
		driverCallClass.validateIfCorrectText(val,"Products");
		System.out.println("validating correct products page");
		
	}
	
	@Test(priority=5)
	public void returnToMainMenuM() {
		System.out.println("Returning");
		returnToMainMenu();
	}

	//Case 2 Temporary -------------------------------------------------------------------------
	

	@Test(priority=6)
	public void waitforSplash2() throws InterruptedException {
		TimeUnit.SECONDS.sleep(5);
		driverCallClass.isLoaded("com.androidsample.generalstore:id/toolbar_title");
		
	}
	
	
	@Test(priority=7)
	public void generalStoreInitial2() {
		if(findTextViewWithName("General Store") == true) {
			System.out.println("General Store Splash opened");
		}else {
			System.out.println("App Not Opened");
		}
	}
	
	@Test(priority=8)
	public void selectCountry2() {
		driverCallClass.clickOnElement(driverCallClass.country);
		//driverCallClass.androidScrollGestureUntil(driver.findElement(By.xpath("//android.widget.TextView[@text='Philippines']")));
		driverCallClass.scrollToText("Bolivia");
		driverCallClass.clickOnElement(driver.findElement(By.xpath("//android.widget.TextView[@text='Bolivia']")));
	}
	
	@Test(priority=8)
	public void enterName2() {
		driverCallClass.typeText(driverCallClass.nameField," ");
	}
	
	@Test(priority=8)
	public void selectGender2() {
		driverCallClass.clickOnElement(driverCallClass.genderFemale);
	}
	
	@Test(priority=8)
	public void shopBegin2() throws InterruptedException {
		driverCallClass.clickOnElement(driverCallClass.letsShopbtn);
		TimeUnit.SECONDS.sleep(1);
		String val=driverCallClass.getText(driverCallClass.nameToast);
		driverCallClass.validateIfCorrectText(val,"Please enter your name");
		
	}
	
	//Case 3 Temporary ------------------------------------
	
	@Test(priority=9)
	public void enterName3() {
		driverCallClass.typeText(driverCallClass.nameField,"Andrea Astes");
	}
	
	
	@Test(priority=9)
	public void shopBegin3() throws InterruptedException {
		driverCallClass.clickOnElement(driverCallClass.letsShopbtn);
		TimeUnit.SECONDS.sleep(3);
	}

	@Test(priority=10)
	public void scrollAllDown() throws InterruptedException {
		int x = 0;
		boolean limit = false;
		List<WebElement> elementList = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName"));
	    for (WebElement st: elementList) {
	        System.out.println(st.getText());
	    }
		
		do {
			((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			        "left", 100, "top", 100, "width", 200, "height", 2200,
			        "direction", "down",
			        "percent", 1.5
			    ));
		     
		   
			elementList.addAll(driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productName")));
			System.out.println("---------------");
			 for (WebElement ef: elementList) {
			        System.out.println(ef.getText());
			    }
			x++;
			if(x==10) {
				limit = true;
			}
		}while(limit == false);
		
		System.out.println("FinalList");
		 for (WebElement gh: elementList) {
		        System.out.println(gh.getText());
		    }
		System.out.println("image count " +findBoxCount());
		
	}
	
	@Test(priority=11)
	public void listAllBoxes() {
		
	}
	
	//Case 4 Temporary----------------------------------------
	
	@Test(priority=12)
	public void enterItem() throws InterruptedException {

        driverCallClass.scrollToText("Converse All Star");
        driverCallClass.clickOnElement(driver.findElement(By.xpath("//android.widget.TextView[@text='Converse All Star']")));
        driverCallClass.clickOnElement(driverCallClass.addToCartConverse);
       
	}
	
	@Test(priority=13)
	public void enterCart() throws InterruptedException {
        driverCallClass.clickOnElement(driverCallClass.cart);
        TimeUnit.SECONDS.sleep(5);
		String val=driverCallClass.getText(driverCallClass.cost);
		driverCallClass.validateIfGreaterThan(val,"$ 0.0");
	}
	
}
