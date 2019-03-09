package com.qa.Guru99Assignment;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day1TestNG {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp()throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	
  @Test
  public void day1TestCase1() throws IOException{
	  
	  driver.get("http://live.guru99.com/index.php/");
	  String title = driver.getTitle();
	  System.out.println("The title of Home Page is :" +title);
	  
	  String text = driver.findElement(By.cssSelector("h2")).getText();
	  System.out.println("The text on Home Page is:" + text);
	  
	  driver.findElement(By.linkText("MOBILE")).click();
	  String title1 = driver.getTitle();
	  System.out.println("The title of Mobile Page is:" +title1);
	  
	  Select select = new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
	  select.selectByVisibleText("Name");
	  
	 // File scrsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  //FileHandler.copy(scrsht,new File(("C:\\Users\\FreerateSales-10\\eclipse-workspace\\Guru99Assignment\\src\\main\\java\\com\\qa\\Guru99Assignment\\Day1Assignment\\" +a+ ".jpg"));
  }
  
  @AfterMethod
  public void tearDown() throws IOException
  {
	  driver.quit();
  }
}
