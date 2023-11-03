package midtermProjMain;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import callPackage.DriverCallClass;
import io.appium.java_client.AppiumBy;
import platformPackage.AndroidClass;

public class Main2 extends AndroidInitialization {


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
		driverCallClass.scrollToText("Bolivia");
		driverCallClass.clickOnElement(driver.findElement(By.xpath("//android.widget.TextView[@text='Bolivia']")));
	}
	
	@Test(priority=3)
	public void enterName() {
		driverCallClass.typeText(driverCallClass.nameField," ");
	}
	
	@Test(priority=3)
	public void selectGender() {
		driverCallClass.clickOnElement(driverCallClass.genderFemale);
	}
	
	@Test(priority=4)
	public void shopBegin() throws InterruptedException {
		driverCallClass.clickOnElement(driverCallClass.letsShopbtn);
		TimeUnit.SECONDS.sleep(1);
		String val=driverCallClass.getText(driverCallClass.nameToast);
		driverCallClass.validateIfCorrectText(val,"Please enter your name");
		
	}
	

}
