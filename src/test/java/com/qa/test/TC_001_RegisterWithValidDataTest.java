package com.qa.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.Registration;
import com.qa.util.TestUtil;


public class TC_001_RegisterWithValidDataTest extends TestBase{

	
	String sheetName = "ValidRegisteration";
	//public WebDriver driver;
	Registration register;
	TestBase testBase;
	
	@BeforeMethod
	public void setUp() {
		testBase = new TestBase();
		driver = testBase.initBrowser();
		register = new Registration(driver);
	}
	
	@AfterMethod
	public void endTest() {
		driver.quit();
	}
	

	
	@DataProvider
	public Object[][] getTestData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test (dataProvider = "getTestData")
	public void validateRegistration(String edition, String firstname, String lastname, String Email, String confEmail, String username, String password, String confPassword) {
		register.newRegistration(edition, firstname, lastname, Email, confEmail, username, password, confPassword);
	}
	
	@Test
	public void validatePageTitle() {
		Assert.assertEquals(register.validatePageTitle(), "CRMPRO - CRM Pro for customer relationship management, sales, and support");
	}
	
}
