package com.qa.Guru99Assignment;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day2Assignment {
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		System.setProperty("webdriver.chrome.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
  @Test
  public void day2TestCase2() throws Exception {
	  
	  driver.get("http://live.guru99.com/index.php/");
	  driver.findElement(By.linkText("MOBILE")).click();
	  
	  String Product =driver.findElement(By.xpath("//a[@title ='Sony Xperia']")).getText();
	  System.out.println("The Product is :" +Product);
	  
	  String price1 = driver.findElement(By.xpath("//div[@class = 'price-box']//span[@id = 'product-price-1']//span[@class ='price']")).getText();
	  System.out.println("The Price of Sony Xperia Mobile is: " +price1);
	  
	  
	  driver.findElement(By.xpath("//a[@title ='Sony Xperia']")).click();
	  String productdetailPageTitle = driver.getTitle();
	  System.out.println("The title of product detail page is:" +productdetailPageTitle);
	  
	  String price2 = driver.findElement(By.xpath("//div[@class = 'price-box']//span[@id = 'product-price-1']//span[@class ='price']")).getText();
	  System.out.println("The Price of Sony Xperia Mobile on Detail Page is: " +price2);
	  
	  Assert.assertEquals(price1, price2);
	  
  }
  
  @AfterMethod
  public void tearDown()
  {
	  driver.quit();
	  
  }
}
