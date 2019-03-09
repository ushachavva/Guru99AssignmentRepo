package com.qa.Guru99Assignment;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Day1Assignment {
	
	static WebDriver driver;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.gecko.driver","C:\\Documents\\Usha Learnings\\Selenium\\Documents\\Browsers\\geckodriver-v0.18.0-win64\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.get("http://live.guru99.com/index.php/");
				
		String title = driver.getTitle();
		System.out.println("The title is : " +title);
		String demoSite = driver.findElement(By.cssSelector("h2")).getText();
		System.out.println(demoSite);
		
		driver.findElement(By.xpath("//a[text()='Mobile']")).click();
		
		String title1 = driver.getTitle();
		System.out.println("The title of Mobile Page is:" +title1);
		
		//Select select = new Select(driver.findElement(By.xpath("//div[@class='category-products']//select//option[contains(text(),'Name')]")));
		Select select = new Select(driver.findElement(By.cssSelector("select[title=\"Sort By\"]")));
		select.selectByVisibleText("Name");
		takeScreenshot("Sort By Name");
	}
	
	public static void takeScreenshot(String fileName) throws IOException
	{
		File scrsht = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(scrsht, new File("C:\\Users\\FreerateSales-10\\eclipse-workspace\\Guru99Assignment\\src\\main\\java\\com\\qa\\Guru99Assignment\\Day1Assignment\\" +fileName+ ".jpg"));
	
	}

}
