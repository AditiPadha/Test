package com.mindire.TESTNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class base {

	public String baseurl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "//Users//aditi 1//drivers//chromedriver";
	public WebDriver driver;
	public String expected = null;
	public String actual = null;

	@BeforeTest
	public void launchBrowser() {
		System.out.println("Launching Browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseurl);
	}

	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@Test(priority = 0)
	public void register() {
		driver.findElement(By.linkText("REGISTER")).click();
		String ExpectedTitle = driver.getTitle();
		String ActualTitle = "Register:Mercury Tours";
		Assert.assertEquals(ExpectedTitle, ActualTitle);
	}

	@Test(priority = 1)
	public void support() {
		driver.findElement(By.linkText("SUPPORT")).click();
		String ExpectedTitle = driver.getTitle();
		String ActualTitle = "Under Construction: Mercury Tours";
		Assert.assertEquals(ExpectedTitle, ActualTitle);

	}

	@AfterMethod
	public void gobacktoHomePage() {
		driver.findElement(By.linkText("HOME")).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.quit();
	}

}
