package com.qa.Guru99Assignment;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day5Assignment {
	
	public WebDriver driver;
	public String firstname = "POOJA";
	public String lastname = "REDDY";
	
	  
	  @BeforeMethod
	  public void setUp() throws Exception
	  {
		  System.setProperty("webdriver.chrome.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\chromedriver_win32\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  }
	
  @Test
  public void day5TestCase() throws Exception
  {
	  driver.get("http://live.guru99.com/index.php/");
	  driver.findElement(By.linkText("ACCOUNT")).click();
	  driver.findElement(By.linkText("MY ACCOUNT")).click();
	  
	  driver.findElement(By.xpath("//a[@title = 'Create an Account' and @class = 'button']")).click();
	  
	  driver.findElement(By.xpath("//input[@type = 'text' and @id = 'firstname']")).clear();
	  driver.findElement(By.xpath("//input[@type = 'text' and @id = 'firstname']")).sendKeys(firstname);
	  
	  driver.findElement(By.xpath("//input[@type = 'text' and @id = 'lastname']")).clear();
	  driver.findElement(By.xpath("//input[@type = 'text' and @id = 'lastname']")).sendKeys(lastname);
	  
	  driver.findElement(By.xpath("//input[@type = 'email' and @id = 'email_address']")).clear();
	  driver.findElement(By.xpath("//input[@type = 'email' and @id = 'email_address']")).sendKeys("pooja123@gmail.com");
	  
	  driver.findElement(By.xpath("//input[@type = 'password' and @id = 'password']")).clear();
	  driver.findElement(By.xpath("//input[@type = 'password' and @id = 'password']")).sendKeys("password123");
	  
	  driver.findElement(By.xpath("//input[@type = 'password' and @id = 'confirmation']")).clear();
	  driver.findElement(By.xpath("//input[@type = 'password' and @id = 'confirmation']")).sendKeys("password123");
	  
	  driver.findElement(By.xpath("//button[@type = 'submit' and @title = 'Register']")).click();
	  
	  String expectedWelcome = ("WELCOME, "+firstname+ " "+lastname+ "!");
	  String actualWelcome = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[1]/div/p")).getText();
	  
	  System.out.println("Welcome text is:" +actualWelcome);
	  
	 /* try 
	  {
		  Assert.assertEquals(expectedWelcome,actualWelcome);
		  
	  }
	  catch (Exception e) {
	    	e.printStackTrace();	    	
	    }	*/
	  
	  driver.findElement(By.xpath("//a[contains(text(), 'TV')]")).click();
	  driver.findElement(By.xpath("//li/a[@class = 'link-wishlist']")).click();
	  driver.findElement(By.xpath("//button[@type ='submit' and @title = 'Share Wishlist']")).click();
	  
	  Thread.sleep(3000);
	  
	  driver.findElement(By.xpath("//textarea[@id ='email_address']")).sendKeys("usha.chavv@gmail.com");
	  driver.findElement(By.xpath("//textarea[@id ='message']")).sendKeys("Hey Usha.. I liked it..Please check this TV");
	  driver.findElement(By.xpath("//button[@type ='submit' and @title = 'Share Wishlist']")).click();
	  
	  String expectedWishListMessage = "Your Wishlist has been shared.";
	  String actualWishListMessage =driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span")).getText();
      System.out.println("WishListMessage is:" +actualWishListMessage);
	  
	  try 
	  {
		  Assert.assertEquals(expectedWishListMessage,actualWishListMessage);
		  
	  }
	  catch (Exception e) {
	    	e.printStackTrace();	    	
	    }	

	  }
  
@AfterMethod
  
  public void tearDown() {
	  driver.quit();
  }
	  
	  
  }

