package com.testng;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DataDriverTesting {
	WebDriver driver;
	
	@Test(dataProvider="data")
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
	
	@DataProvider(name="data")
	public Object[][] readExcel() throws BiffException, IOException{
		File f = new File("C:\\Users\\ektaj\\Desktop\\Data.xls");
		Workbook w = Workbook.getWorkbook(f);
		Sheet s = w.getSheet("Sheet1");
		int rows = s.getRows();
		int column=s.getColumns();
		String inputData[][] = new String[rows][column];
		for (int i=0;i<rows;i++){
			for (int j=0;j<column;j++){
				Cell c = s.getCell(j, i);
				inputData[i][j] = c.getContents();
			}
		}
		return inputData;
		
	}

}
