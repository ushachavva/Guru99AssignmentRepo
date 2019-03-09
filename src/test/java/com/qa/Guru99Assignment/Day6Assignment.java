package com.qa.Guru99Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day6Assignment {
	public WebDriver driver;
	public String firstname = "USHA";
	public String lastname = "REDDY";
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
  public void day6TestCase() throws InterruptedException 
  {
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
	  
	  driver.findElement(By.linkText("MY WISHLIST")).click();
	  
	  //clicking on Add to Cart button
	  driver.findElement(By.xpath("//button[@type ='button' and @title = 'Add to Cart']")).click();
	  
	  Thread.sleep(5000);
	  
	  //Entering Country & State Info and clicking on Estimate 
	  Select country = new Select(driver.findElement(By.xpath("//select[@id ='country']")));
	  country.selectByVisibleText("United States");
	  
	  Select state = new Select(driver.findElement(By.xpath("//select[@id ='region_id']")));
	  state.selectByVisibleText("Pennsylvania");
	  
	  driver.findElement(By.xpath("//input[@id = 'postcode']")).sendKeys("19380");
	  
	  driver.findElement(By.xpath("//button[@type ='button' and @title = 'Estimate']")).click();
	  
	  //Verifying Flat Rate Text
	  String expFlatRate ="Flat Rate";
	  String actFlatRate = driver.findElement(By.xpath("//form/dl[@class ='sp-methods']/dt")).getText();
	  
	  System.out.println("Actual Flat Rate is:" +actFlatRate);
	  
	  try
	  {
		  Assert.assertEquals(expFlatRate,actFlatRate);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  System.out.println("Both Texts are same");
	  
	  //Verifying Flat Rate Price
	  String expFlatRatePrice ="Fixed - $5.00";
	  String actFlatRatePrice =driver.findElement(By.xpath("//form[@id ='co-shipping-method-form']/dl/dd/ul/li/label")).getText();
	  
      System.out.println("Actual Flat Rate Price is:" +actFlatRatePrice);
	  
	  try
	  {
		  Assert.assertEquals(expFlatRatePrice,actFlatRatePrice);
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  System.out.println("Both Prices are same");
	  
	  //Selecting radio button and clicking on Update Total
	  driver.findElement(By.xpath("//input[@type ='radio' and @id ='s_method_flatrate_flatrate']")).click();
	  driver.findElement(By.xpath("//button[@type ='submit' and @title = 'Update Total']")).click();
	  
	  //Verifying Shipping Cost added to Total
	  String shippingPrice = "$5.00";
	  String shippingCostIncluded = driver.findElement(By.xpath("//table[@id ='shopping-cart-totals-table']/tbody/tr[2]/td[2]/span")).getText();
	  
	  try
	  {
		  System.out.println("Shipping Price is: " +shippingPrice);
		  System.out.println("Shipping Cost included is: " +shippingCostIncluded);
		  Assert.assertEquals(shippingPrice,shippingCostIncluded);
		  System.out.println("Shipping Cost is added to Total");
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  
	  //Clicking on Proceed to Checkout
	  driver.findElement(By.xpath("//button[@title ='Proceed to Checkout']")).click();
	  
	// Check if Select element is present. 
	//If not present, it is the first time a customer has logged back in, to process what is in his/her wishlist
	    
	  try {
	    	Select bAddr = new Select(driver.findElement(By.name("billing_address_id")));
	    	int bAddrSize = bAddr.getOptions().size();
	    	bAddr.selectByIndex(bAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	System.out.println("No dropdown element present");
		    }
	  
	  //entering New Billing Info
	  driver.findElement(By.id("billing:firstname")).clear();
	  driver.findElement(By.id("billing:firstname")).sendKeys(firstname);
	  
	  driver.findElement(By.id("billing:lastname")).clear();
	  driver.findElement(By.id("billing:lastname")).sendKeys(lastname);
	  
	  driver.findElement(By.id("billing:street1")).clear();
	  driver.findElement(By.id("billing:street1")).sendKeys("123 Kings Blvd");
	  
	  driver.findElement(By.id("billing:city")).clear();
	  driver.findElement(By.id("billing:city")).sendKeys("King Of Prussia");
	  
	  driver.findElement(By.id("billing:region")).clear();
	  driver.findElement(By.id("billing:region")).sendKeys("Pennsylvania"); 
	  
	  driver.findElement(By.id("billing:postcode")).clear();
	  driver.findElement(By.id("billing:postcode")).sendKeys("19406");
	  
	  Select billingCountry = new Select(driver.findElement(By.id("billing:country_id")));
	  billingCountry.selectByVisibleText("United States");
	  
	  driver.findElement(By.id("billing:telephone")).clear();
	  driver.findElement(By.id("billing:telephone")).sendKeys("4845785416");
	  
	  System.out.println("Billing Info Entered");
	  
	// check radio button to "Ship to different address" 
      driver.findElement(By.id("billing:use_for_shipping_no")).click();
	    
     //Clicking on Continue
      driver.findElement(By.xpath("//button[@type ='button' and @title = 'Continue']")).click();
      
      Thread.sleep(2000);
      
      //Shipping Info
      
	  // Check if Select element is present or not.  
     // If not present, it is first time user has logged back in to process his/her order
	    
	    try {
	    	Select sAddr = new Select(driver.findElement(By.name("shipping_address_id")));
	    	int sAddrSize = sAddr.getOptions().size();
	    	sAddr.selectByIndex(sAddrSize-1); 
		    } catch (Exception e) {
		    	//e.printStackTrace();
		    	System.out.println("No dropdown element present");
		    }
	    
	  
	    Thread.sleep(3000);   
	    
	    //entering New Shipping Info

	    driver.findElement(By.id("shipping:firstname")).clear();
		driver.findElement(By.id("shipping:firstname")).sendKeys(firstname);
		
		driver.findElement(By.id("shipping:lastname")).clear();
	    driver.findElement(By.id("shipping:lastname")).sendKeys(lastname);
	  
	    driver.findElement(By.id("shipping:street1")).clear();
		driver.findElement(By.id("shipping:street1")).sendKeys("110 Berry Street");
		
		driver.findElement(By.id("shipping:city")).clear();
		driver.findElement(By.id("shipping:city")).sendKeys("New York");
		
	    driver.findElement(By.id("shipping:region")).clear();
	    driver.findElement(By.id("shipping:region")).sendKeys("New York"); 
	    
	    driver.findElement(By.id("shipping:postcode")).clear();
	    driver.findElement(By.id("shipping:postcode")).sendKeys("542986");
	    
	    Select shippingCountry = new Select(driver.findElement(By.id("shipping:country_id")));
		shippingCountry.selectByVisibleText("United States");
		
		driver.findElement(By.id("shipping:telephone")).clear();
	    driver.findElement(By.id("shipping:telephone")).sendKeys("1234567890");

	    Thread.sleep(3000);   
	    
	    System.out.println("Shipping Info Entered");
	    
	    //Clicking on Continue button
	    driver.findElement(By.xpath("//button[@type ='button' and @title = 'Continue' and @onclick= 'shipping.save()']")).click();
	    Thread.sleep(2000);
	    
	    //Clicking on Continue for Shipping Method
	    driver.findElement(By.xpath("//div[@id ='shipping-method-buttons-container']/button")).click();
	    Thread.sleep(3000);
	    
	    //In Payment Information select 'Check/Money Order' radio button. Click Continue
        driver.findElement(By.xpath("//input[@type ='radio' and @title = 'Check / Money order']")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//div[@id ='payment-buttons-container']/button")).click();
	    Thread.sleep(3000);
	    
	    //clicking on Place Order
	    driver.findElement(By.xpath("//button[@type ='submit' and @title = 'Place Order']")).click();
	    Thread.sleep(3000);
	    
	    //Verify Oder is generated. Note the order number 
	    String orderNum = driver.findElement(By.xpath(".//*[@id='top']/body/div[1]/div/div[2]/div/div/p[1]/a")).getText();	
	    System.out.println("*** Your order number for your record = " + orderNum);
	   
  }
  
  @AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	  }

  
}
