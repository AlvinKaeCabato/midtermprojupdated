package midtermProjMain;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import callPackage.DriverCallClass;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidInitialization {
	AppiumDriverLocalService service;
	DriverCallClass driverCallClass;
	protected AndroidDriver driver;
	ExtentReports extent;
	ExtentTest test;
	private static ThreadLocal<AndroidDriver> WEBDRIVER = new ThreadLocal<AndroidDriver>();

	@BeforeTest
	public void startServerwithApp() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\data.properties");
		prop.load(fis);
		String ipAddress=prop.getProperty("ipAddress");
		String portNo=prop.getProperty("port");
		String deviceName=prop.getProperty("Pixel4KaeTest");
		service=new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\COLLABERA.DIGITAL\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(ipAddress).usingPort(Integer.parseInt(portNo)).build();
		service.start();
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp("C:\\Users\\COLLABERA.DIGITAL\\eclipse-workspace\\midtermProj\\src\\main\\resources\\General-store.apk");
		options.setCapability("appium:autoGrantPermissions",true);
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		 WEBDRIVER.set(driver);
		 /*
	      if (driver== null) {
		        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		        WEBDRIVER.set(driver);
		      }
		      */
		driverCallClass =new DriverCallClass(driver);
	}
	@BeforeClass
	public void configReports() {
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Android Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "AlvinKaeCabato");
		test =extent.createTest("Click on View and scroll to WebView test");
	}
	
	@BeforeClass
	public void reconfigure() throws MalformedURLException,NumberFormatException {
		System.out.println("Reconfigure");
		Properties prop=new Properties();
		String deviceName=prop.getProperty("Pixel4KaeTest");
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName(deviceName);
		options.setApp("C:\\Users\\COLLABERA.DIGITAL\\eclipse-workspace\\midtermProj\\src\\main\\resources\\General-store.apk");
		options.setCapability("appium:autoGrantPermissions",true);
		
	      if (driver== null) {	
		        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
		        WEBDRIVER.set(driver);
		      }
		      
	}

	@AfterClass
	public void returnToMainMenu() {
		do {
			driverCallClass.navigateBack();
		}while(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("General Store")).equals(false));
	}

	
	@AfterClass
	public void closeReport() {
		extent.flush();
	}
	
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		//Wait For Debugging purposes
		
		//Actual End
		driver.quit();
		service.stop();
	}
	
	public boolean checkElement(String xpath) {
		List<WebElement> elementList = driver.findElements(By.xpath(xpath));
		if(elementList.size()>0){
		   return true;
		}
		else{
		   return false; 
		}
	}
	
	public boolean findTextViewWithName(String text) {
		List<WebElement> elementList = driver.findElements(By.xpath("//android.widget.TextView[@text='"+text+"']"));
		if(elementList.size()>0 ){
		   return true;
		}
		else{
		   return false; 
		}
	}
	
	public Integer findBoxCount() {
		List<WebElement> elementList = driver.findElements(AppiumBy.id("com.androidsample.generalstore:id/productImage"));
		Integer x = elementList.size();

		return x;
	}

	
}
