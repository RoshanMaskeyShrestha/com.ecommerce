package com.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationclass implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		//execution starts from here
		String MethodName = result.getMethod().getMethodName();
		test=report.createTest(MethodName);
		Reporter.log(MethodName+"-----> Testscript execution started");
	}

	public void onTestSuccess(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS, MethodName+"---> Passed");
		Reporter.log(MethodName+"-----> Testscript execution sucessfull");
		
	}

	public void onTestFailure(ITestResult result) {
		
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src = edriver.getScreenshotAs(OutputType.FILE);
//		File des = new File("./Screenshot/Failedscript.png");
//		
//		
//			try {
//				FileUtils.copyFile(src, des);
//			} catch (IOException e) {
//				
//				e.printStackTrace();
//			}
		try {
			String screenshotname=WebdriverUtility.getScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenshotname);
		
			
		
			
		}
		catch(Throwable e){
			e.printStackTrace();
			 
			
		}
	
		test.log(Status.FAIL, result.getThrowable());
		Reporter.log("THE TEST SCRIPT FAILED");
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"--->Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log("Testscript execution Skipped");
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	}

	public void onStart(ITestContext context) {
		//create html report
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report3.html");
		htmlreport.config().setDocumentTitle("com.e-commerce");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("E-comm");
		
		report= new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base_url", "http://rmgtestingserver/domain/Online_Shopping_Application/");
		report.setSystemInfo("Reporter Name", "Roshan");
	}

	public void onFinish(ITestContext context) {
		//consolidate the report
		report.flush();
	}

}
