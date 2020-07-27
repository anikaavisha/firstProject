package com.testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class multiBrowserTesting {
	
	public static WebDriver driver;
	
	@Test
	public void chrome(){
		driver= new ChromeDriver();
		driver.get("https://phptravels.com/demo/");
		
	}

	@Test
	public void firefox(){
		driver = new FirefoxDriver();
		driver.get("https://phptravels.com/demo/");
	}
}
