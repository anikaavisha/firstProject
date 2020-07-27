package com.testng;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParllelExecution {
	public static WebDriver driver;
	@Parameters ({"user","pass"})
	@Test
	public void open(String user, String pass){
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get("https://phptravels.com/demo/");
		 driver.findElement(By.xpath("//a[@class='btn yx-nfn yx-njg']")).click();
		 driver.findElement(By.name("username")).sendKeys(user);
		 driver.findElement(By.name("password")).sendKeys(pass);
		 driver.findElement(By.id("login")).click();
	}
	

}
