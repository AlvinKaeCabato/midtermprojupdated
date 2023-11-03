package platformPackage;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class AndroidClass {
	static AndroidDriver driver;
	public AndroidClass(AndroidDriver driver) {
		AndroidClass.driver=driver;
	}
	public static void longPressAction(WebElement e) {
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)e).getId(),"duration",2000));
		
	}
	public void scrollToText(String text) {
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
		
	}
	
	public void androidScrollGesture() {
		boolean canScrollMore;
		int x = 1;
		do {
			canScrollMore=(Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left",100,
					"top",100,
					"width",200,
					"height",200,
					"direction","down",
					"percent",50
					));
			System.out.println("Times: "+x);
			x++;
		}while(canScrollMore);
	}
	
	public void androidScrollGestureUp() {
		boolean canScrollMore;
		do {
			canScrollMore=(Boolean)((JavascriptExecutor)driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
					"left",100,
					"top",100,
					"width",200,
					"height",200,
					"direction","up",
					"percent",15
					));
		}while(canScrollMore);
	}
	
	public void androidScrollGestureUntil(WebElement webe) {
		boolean canScrollMore;
		do {
			canScrollMore=(Boolean)((JavascriptExecutor)driver).executeScript("mobile:scrollGesture", ImmutableMap.of(
					"left",100,
					"top",100,
					"width",200,
					"height",200,
					"direction","down",
					"percent",20.0
					));
			if(webe.isDisplayed()) {
				break;
			}
		}while(canScrollMore);
		
	}

	public static void swipeGesture(WebElement webEle) {
		((JavascriptExecutor)driver).executeScript("mobile:swipeGesture", ImmutableMap.of(
				"elementId",((RemoteWebElement)webEle).getId(),
				"direction","left",
				"percent",0.75));
	}
	public void isLoaded() throws Error {
		// TODO Auto-generated method stub
		
	}
	public void isLoaded(String s) throws Error {
		// TODO Auto-generated method stub
		
	}
	

}
