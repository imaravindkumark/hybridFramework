package testCase;
import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseClass.libraryClass;
import pages.loginPage;
import reusableFunction.seleniumUtility;
import utilities.ExtentReportManager;

public class loginTestCase extends libraryClass {
	loginPage hrm;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	seleniumUtility util;

	@BeforeMethod
	public void stratUp() {
		browserSetUp();
		

	}

	@AfterTest
	public void endReport() {
		report.flush();

	}

	@Test
	public void loginpage() {
		logger = report.createTest("HR Management System");
		logger.log(Status.INFO,"*******Starting with Browser Set Up*********");
		hrm = new loginPage(driver);
		logger.log(Status.INFO,"Identifying locators for input field");
		hrm.login("Admin", "admin123");
		logger.log(Status.PASS, "Logged in succesfull");
		

	}

	@AfterMethod
	public void close() throws IOException {
		util = new seleniumUtility(driver);
		util.getTitle();
		util.to_take_screenshot("./src/test/resources/screenshots/orangehrm1.png");
		util.quit();

	}
}
