package callPackage;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import javax.annotation.Nonnull;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import platformPackage.AndroidClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

@Test
public class DriverCallClass extends AndroidClass{
	AndroidDriver driver;

	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	public DriverCallClass(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		isLoaded();
	}
	
	public void clickOnElement(WebElement ele) {
		ele.click();
	}
	
	public void clickOnElementDD(WebElement ele) {
		
	}
	public void navigateBack() {
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
	public String getText(WebElement ele) {
		return ele.getText();
	}
	
	public void typeText(WebElement ele, String s) {
		ele.sendKeys(s);
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	public WebElement country;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	public WebElement genderMale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	public WebElement genderFemale;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	public WebElement nameField;
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	public WebElement letsShopbtn;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	public WebElement loggedInHeader;
	
	@AndroidFindBy(xpath="//hierarchy//android.widget.Toast[1]")
	public WebElement nameToast;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Converse All Star']/following-sibling::android.widget.LinearLayout[2]/android.widget.TextView[2]")
	public WebElement addToCartConverse;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
	public WebElement cart;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/totalAmountLbl")
	public WebElement cost;
	/*
	 *
	public void waitForElementLocatedByAccess(String by) {
		    wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId(by)));
	}

	@AndroidFindBy(id= "com.androidsample.generalstore:id/productImage") 
	public List<WebElement> productImages;
	*/
	public void validateIfCorrectText(String str1, String str2) {
		
		Assert.assertEquals(str1,str2);
		
	}
	
	public void validateIfGreaterThan(String str1, String str2) {
		
		Assert.assertNotSame(str1, str2);
	}
	public List<WebElement> androidScrollUntil() {
		boolean canScrollMore;
		List<WebElement> productImages = null;
		productImages.addAll(driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productImage")));
		
		do {
			canScrollMore=(Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left",100,
					"top",100,
					"width",200,
					"height",200,
					"direction","down",
					"percent",20.0
					));
			productImages.addAll(driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productImage")));
		}while(canScrollMore);
		
		return productImages;
	}
    @Override
    public void isLoaded(String s) throws Error {
        new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(new Function<WebDriver, Boolean>() {
                    @Nonnull
                    @Override
                    public Boolean apply(WebDriver webDriver) {
                        WebElement element = driver.findElement(AppiumBy.id(s));
                        return element != null && element.isDisplayed();
                    }
                });
    }
    
    
}
