package com.mindtree.reusablecomponents;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mindtree.uistore.UI_list_products;



public class reusablemethods 
{

	public static void loadurl(WebDriver driver)
	{
		driver.get(com.mindtree.utility.Propertyfilereader.loadurl());	
	}
	
	public static void timelapse(WebDriver driver) {
		int wait = Integer.parseInt(com.mindtree.utility.Propertyfilereader.propfile().getProperty("implicitWait"));
		driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}
   public static WebElement findElement(By selector, WebDriver driver)
   {
	   WebElement a = null;
	   try
	   {
	  a=driver.findElement(selector);
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   
	   }  
	   return a;
   }
   public static boolean enter(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).sendKeys(Keys.ENTER);
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }    
   }
   public static boolean clear(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).clear();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }    
   }
   public static boolean sendkeys(By selector, String value, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).sendKeys(value);
	  return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		  return false;
	   }
	   
   }
   public static boolean click(By selector, WebDriver driver)
   {
	   try
	   {
	   driver.findElement(selector).click();
	   return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }
	   
   }
   public static boolean actions_mouseover(By selector,WebDriver driver)
   {
	   
	   try
	   {
	   Actions a =new Actions(driver);
 			WebElement filter=reusablemethods.findElement(selector, driver);
		a.moveToElement(filter).build().perform();
			return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }
	   
   }
   public static boolean actions_click(By selector,WebDriver driver)
   {
	   
	   try
	   {
	   Actions a =new Actions(driver);
 			WebElement filter=reusablemethods.findElement(selector, driver);
		a.moveToElement(filter).click().build().perform();
			return true;
	   }
	   catch(Exception e)
	   {
		   System.out.println(String.format("Element %s doesnt exist", selector));
		   return false;
	   }
	   
   }
  
	
	
	
	
}
