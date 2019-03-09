package com.qa.Guru99Assignment;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day3Assignment {

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		//System.setProperty("webdriver.gecko.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		System.setProperty("webdriver.chrome.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
  @Test
  public void day3TestCase3() throws IOException, InterruptedException {
	  
	  driver.get("http://live.guru99.com/index.php/");
	  driver.findElement(By.linkText("MOBILE")).click();
	  
	  Thread.sleep(5000);
	  
	  //Clicking on Add to Cart button for Sony Xperia
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button")).click();
	 
	  // driver.findElement(By.xpath("//button[@type ='button']/span/span")).click();
	  
	  Thread.sleep(10000);
	  driver.findElement(By.xpath("//input[@title = 'Qty']")).sendKeys("1000");
	  
	  driver.findElement(By.xpath("//button[@type ='submit' and @title = 'Update']")).click();
	  
	  String expectedErrMsg = "* The maximum quantity allowed for purchase is 500.";
	  String actualErrMsg = driver.findElement(By.xpath("//p[@class = 'item-msg error']")).getText();
	  
	  System.out.println("The error message displyed is: " +actualErrMsg);
	  
	  Assert.assertEquals(actualErrMsg, expectedErrMsg);
	  
	  driver.findElement(By.xpath("//button[@type ='submit' and @title = 'Empty Cart']")).click();
	  
	 // String expectedEmptyMsg = "You have no items in your shopping cart. Click here to continue shopping.";
	  
	  String actualEmptyMsg = driver.findElement(By.xpath("//div[@class = 'cart-empty']")).getText();
	  
	  System.out.println("Empty Cart Message is: " +actualEmptyMsg);
	  
	  //Assert.assertEquals(actualEmptyMsg, expectedEmptyMsg); 
	  
}
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
	  
  }
  
}