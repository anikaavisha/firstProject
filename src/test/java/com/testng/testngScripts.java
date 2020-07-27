package com.testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testngScripts {
	
	public static WebDriver driver;
	@BeforeClass
	public void openApp(){
		 driver = new ChromeDriver();
		 driver.get("https://www.amazon.com/");
		 driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	public void freeshipping(){
		driver.findElement(By.linkText("Free Shipping")).click();
		String actualTitle = driver.getTitle();
		String expectedTitle = "Amazon.com: : FREE Shipping by Amazon";
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority=2)
	public void shopping(){
		driver.findElement(By.linkText("Start Shopping")).click();
		System.out.println(driver.getCurrentUrl());
		
	}
	
	@AfterClass
	public void closeApp(){
		driver.close();
	}

}
