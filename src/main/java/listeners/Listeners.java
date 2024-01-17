package listeners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.Base;
import utilities.ExtentReporter;

public class Listeners extends Base implements ITestListener {

	
	  // variabile globale
	WebDriver driver = null;     
	ExtentReports extentReport = ExtentReporter.getExtentReport();
	ExtentTest extentTest;
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal<ExtentTest>();  // linie de cod pentru a rula testele (din fisierul "testng.xml") in "parallel" mode.
	
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		// "result.getName()" = numele metodei pe care o testam.
		String testName = result.getName();
		extentTest = extentReport.createTest(testName);
		extentTestThread.set(extentTest);                                   // linie de cod pentru a rula testele (din fisierul "testng.xml") in "parallel" mode.
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		// "result.getName()" = numele metodei pe care o testam.
		String testName = result.getName();
//		extentTest.log(Status.PASS, testName + "Test Passed");              // linie de cod pentru a rula testele (din fisierul "testng.xml") in NORMAL mode.
		extentTestThread.get().log(Status.PASS, testName + "Test Passed");  // linie de cod pentru a rula testele (din fisierul "testng.xml") in "parallel" mode.
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// "result.getName()" = numele metodei pe care o testam.
		String testMethodName = result.getName();                         
//		extentTest.fail(result.getThrowable());                             // linie de cod pentru a rula testele (din fisierul "testng.xml") in NORMAL mode.
		extentTestThread.get().fail(result.getThrowable());                 // linie de cod pentru a rula testele (din fisierul "testng.xml") in "parallel" mode. 
		
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}

		// cand un test esueaza, se apeleaza metoda "takeScreenshot()" din clasa "Base".
		try {
//			takeScreenshot(testMethodName,driver);                                               //linie de cod FARA adăugarea capturii de ecran la ExtentReports.
			String screenshotFilePath = takeScreenshot(testMethodName,driver);                   //linie de cod pentru adăugarea capturii de ecran la ExtentReports.
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testMethodName); //linie de cod pentru adăugarea capturii de ecran la ExtentReports.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {

	}

	@Override
	public void onFinish(ITestContext context) {
		extentReport.flush();
	}

	
	
	
	
	
	
	
	
}
