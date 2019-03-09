package com.qa.Guru99Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.testng.Assert;

public class Day7Assignment {
	public WebDriver driver;
	public String email ="usha123@gmail.com";
	public String password = "password123";
	
	  
	  @BeforeMethod
	  public void setUp() throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  }
  @Test
  public void day7TestCase() throws InterruptedException {
	  driver.get("http://live.guru99.com/index.php/"); 
	  driver.findElement(By.linkText("ACCOUNT")).click();
	  driver.findElement(By.linkText("Log In")).click();
	  
	  //Login using Email and Password
	  driver.findElement(By.xpath("//input[@type ='email' and @title = 'Email Address']")).clear();
	  driver.findElement(By.xpath("//input[@type ='email' and @title = 'Email Address']")).sendKeys(email);
	  
	  driver.findElement(By.xpath("//input[@type ='password' and @title = 'Password']")).clear();
	  driver.findElement(By.xpath("//input[@type ='password' and @title = 'Password']")).sendKeys(password);
	  
	  driver.findElement(By.xpath("//button[@type ='submit' and @title = 'Login']")).click();
	  
	  Thread.sleep(3000);
	  
	  //RECENT ORDERS page is displayed immediately after customer/user has logged in
	  
	  try
	  {
		  Assert.assertEquals("RECENT ORDERS", driver.findElement(By.cssSelector("h2")).getText());
		  System.out.println(" RECENT ORDERS is confirmed as the correct page to be in");
		  
	  }
	  
	  catch(Exception e)
	  {
		  System.out.println("RECENT ORDERS failed to display on the home page");
		  e.printStackTrace();
	  }
	  
	  try
	  {
		  Assert.assertEquals("Pending", driver.findElement(By.cssSelector("em")).getText());
		  System.out.println(" Pending status is correctly displayed for this recent order");
		  
	  }
	  catch (Exception e) {
    	  System.out.println("*** Status of Pending failed to be confirmed for this recent order. ***");
    	  e.printStackTrace();	
      }
      //clicking on View Order
	  driver.findElement(By.linkText("VIEW ORDER")).click();
	  Thread.sleep(2000);
	  
	//clicking on Print Order
	  driver.findElement(By.linkText("Print Order")).click();
	  Thread.sleep(2000);
	  
	 
	  
	/* //clicking on Change button
	  driver.findElement(By.xpath("//*[@id=\"destinationSettings\"]//print-preview-settings-section[2]/div[2]/paper-button")).click();
	  
	  for(String handle : driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  
	  driver.findElement(By.linkText("Save as PDF")).click();
	  
	  for(String handle : driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle);
	  }
	  driver.findElement(By.xpath("//*[@id=\"button-strip\"]/paper-button[1]")).click();
	  
	  for(String handle : driver.getWindowHandles())
	  {
		  driver.switchTo().window(handle); 
	  } */
	  
	 } 
  
  @AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	  }

}
