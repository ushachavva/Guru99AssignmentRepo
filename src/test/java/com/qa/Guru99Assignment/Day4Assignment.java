package com.qa.Guru99Assignment;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Day4Assignment {
	
	public WebDriver driver;
	
  
  @BeforeMethod
  public void setUp() throws Exception
  {
	  System.setProperty("webdriver.chrome.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
  }
  
  @Test
  public void day4TestCase() throws InterruptedException 
  {
	  driver.get("http://live.guru99.com/index.php/");
	  driver.findElement(By.linkText("MOBILE")).click();
	  
	  String product1 = driver.findElement(By.xpath("//h2/a[@title = 'Sony Xperia']")).getText();
	  System.out.println("Product 1 to compare is :" +product1);
	  Thread.sleep(5000);
	  
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/ul/li[2]/a")).click();
	  
	  Thread.sleep(5000);
	  
	  String product2 = driver.findElement(By.xpath("//h2/a[@title = 'IPhone']")).getText();
	  System.out.println("Product 2 to compare is :" +product2);
	  driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[2]/div/div[3]/ul/li[2]/a")).click();
	  
	  driver.findElement(By.xpath("//button[@type ='button' and @title = 'Compare']")).click();
	  
	  /* Set<String> handler = driver.getWindowHandles();
		Iterator<String> it = handler.iterator();
		
		String parentWindowID = it.next();
		System.out.println("Parent Window Id is: " +parentWindowID);
		
		String childWindowID =it.next();
		System.out.println("Child Window Id is: " +childWindowID);
		
		driver.switchTo().window(childWindowID);
		Thread.sleep(2000);
		System.out.println("child window popup title is: " +driver.getTitle());   OR */
	  
	  for (String handle : driver.getWindowHandles()) 
	  {
	    driver.switchTo().window(handle);
	   
	  }

		  
	  System.out.println("Pop up window title is : " +driver.getTitle());
	  
	  String expHeader = ("COMPARE PRODUCTS");
	  String actHeader = driver.findElement(By.xpath("//div[@class = 'page-title title-buttons']/h1")).getText();
	  
	 System.out.println("Actual Popup Window Header is:" +actHeader );
	 
	 Assert.assertEquals(expHeader,actHeader);
	 System.out.println("Both Headers are same");
	 
	 
	 String popupProduct1 = driver.findElement(By.xpath("//h2/a[@title = 'Sony Xperia']")).getText();
	 String popupProduct2 = driver.findElement(By.xpath("//h2/a[@title = 'IPhone']")).getText();
	 
	 System.out.println("Popup Window Product1 is :" +popupProduct1 );	 
	 System.out.println("Popup Window Product2 is :" +popupProduct2 );
	 
	 Thread.sleep(5000);
	 
			
	 try
	 {
		 assertEquals(product1,popupProduct1);
	 }
	  
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 
	 System.out.println("Product1 is matched");
	 
	 try
	 {
		 assertEquals(product2,popupProduct2);
	 }
	  
	 catch(Exception e) {
		 e.printStackTrace();
	 }
	 System.out.println("Product2 is matched");
	 
	 
	 driver.findElement(By.xpath("//button[@type ='button' and @title = 'Close Window']")).click();
	 
	 for(String handle : driver.getWindowHandles())
	 {
		 driver.switchTo().window(handle);
	 }
	 
	 
  }
  
  @AfterMethod
  
  public void tearDown() {
	  driver.quit();
  }

}


