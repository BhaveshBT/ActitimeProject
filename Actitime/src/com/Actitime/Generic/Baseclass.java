package com.Actitime.Generic;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Actitime.pom.HomePage;
import com.Actitime.pom.LoginPage;

public class Baseclass {
	static {
		System.setProperty("webdriver.chromedriver","./driver/chromedriver.exe");
	}
	public static WebDriver driver;
	
	@BeforeSuite
	public void databaseconnection() {
		Reporter.log("database connected",true);
	}
	
	@AfterSuite
	public void databasedisconnected() {
		Reporter.log("database disconnected",true);
	}
	
	@BeforeTest
	public void launchBrowser() {
		driver = new ChromeDriver();
		readDataFromPropertyFile R = new readDataFromPropertyFile();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	
	@AfterTest
	public void closebrowser() {
		driver.close();
	}
	
	@BeforeMethod
	public void login() throws IOException {
		readDataFromPropertyFile data = new readDataFromPropertyFile();
		String Url = data.readDataFromProperty("url");
		String un = data.readDataFromProperty("username");
		String pw = data.readDataFromProperty("password");
		driver.get(Url);
		LoginPage lp = new LoginPage(driver);
		lp.logintoActitime(un, pw);
		
	}
	
	@AfterMethod
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
		HomePage hp = new HomePage(driver);
		Thread.sleep(5000);
		hp.logout();
		Reporter.log("logout to application");
	}

}
