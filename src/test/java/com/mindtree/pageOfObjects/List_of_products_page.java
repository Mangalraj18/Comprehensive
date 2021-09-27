package com.mindtree.pageOfObjects;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.mindtree.reusablecomponents.reusablemethods;
import com.mindtree.runner.TestRunner;
import com.mindtree.uistore.UI_list_products;
import com.mindtree.utility.logger;


public class List_of_products_page
{
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	public static boolean product_search(WebDriver driver,String value)
	{
		//UI_list_products
	List<WebElement>products_list =driver.findElements(UI_list_products.product_name);
    for(int i=0;i<products_list.size();i++)
    {
    	String name=driver.findElements(UI_list_products.product_name).get(i).getText();
    	System.out.println(name);
    	if(name.equals(value))
    	{
    		System.out.println("valid "+ name);
    		driver.findElements(UI_list_products.product_name).get(i).click();
    		break;
    	}
    }
	logger.loginfo(log,"Product finded and clicked successfully");
    return true;
	}
	public static boolean addtocart(WebDriver driver)
	{
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
				String child=it.next();
				if(!parent.equals(child))
				{
				driver.switchTo().window(child);
				reusablemethods.click(UI_list_products.add_to_cart, driver);
				logger.loginfo(log,"Product is added to cart successfully");
				boolean result=driver.findElement(UI_list_products.checkout).isDisplayed();
				logger.loginfo(log,"Product is displayed successfully");
				Assert.assertTrue(result);
				}
		}		
		driver.switchTo().window(parent);
		return true;
	}
	
	
	//Test=2
	public static boolean price_range(WebDriver driver)
	{
		if(reusablemethods.actions_mouseover(UI_list_products.filter, driver))
		{
		if(reusablemethods.click(UI_list_products.price_range, driver))
			logger.loginfo(log,"price range is clicked successfully");
			return true;
		}
		return false;
		
	}
	
	public static boolean low_high(WebDriver driver)
	{
		if(reusablemethods.actions_mouseover(UI_list_products.price_filter, driver))
		{
			if(reusablemethods.click(UI_list_products.price_filter_low_to_high, driver))
			{
				logger.loginfo(log,"Price is low to high successfully is clicked");
				return true;
			}
		}
		return false;
	}
	
	//Test=3
	public static void comparison(WebDriver driver) throws InterruptedException
	{
		 Thread.sleep(1000);
		reusablemethods.actions_mouseover(UI_list_products.recommanded, driver);
		reusablemethods.click(UI_list_products.price_filter_low_to_high, driver);
		logger.loginfo(log,"Price is low to high successfully is clicked");
//		Thread.sleep(2000);
		List<WebElement> list=driver.findElements(UI_list_products.compare);
		for(int i=0;i<list.size();i++)
		{
	    String name=driver.findElements(UI_list_products.product_name).get(i).getText();
	    System.out.println(name);
	    if(name.equals("Boston Bed")||name.equals("Boston Bed"))
	    {
	    	/*WebElement ab=driver.findElements(UI_list_products.product_name).get(i);
	    	Actions a =new Actions(driver);
			//WebElement filter=reusablemethods.findElement(selector, driver);
			a.moveToElement(ab).build().perform();*/
			driver.findElements(UI_list_products.compare).get(i).click();

	    }
	    	
	    }
	}
	
	//Test=4
	public static boolean move_to__addtocart_page(WebDriver driver)
	{
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
				String child=it.next();
				if(!parent.equals(child))
				{
				driver.switchTo().window(child);
		        WebElement name=reusablemethods.findElement(UI_list_products.product_price, driver);
		        String price=name.getText();
		        System.out.println("product price is :"+price);
				}
		}
		logger.loginfo(log,"Product is in move_to__addtocart_page clicked");
		        driver.switchTo().window(parent);
				return true;
	}
	
	public static void validation_title(WebDriver driver) throws InterruptedException
	{
		String url=driver.getCurrentUrl();	
		Thread.sleep(1000);
		reusablemethods.click(UI_list_products.homepage_buttob, driver);
		logger.loginfo(log,"Homepage is clicked successfully");
		String url1=driver.getCurrentUrl();
		Thread.sleep(1000);
		Assert.assertEquals(url,"https://www.urbanladder.com/products/search?utf8=%E2%9C%93&keywords=table");
	}
	
	//Test=5
	public static void stores_map(WebDriver driver)
	{
		reusablemethods.click(UI_list_products.product_image_mumbai, driver);
		logger.loginfo(log,"Mumbai offline store is clicked successfully");
		reusablemethods.click(UI_list_products.view_on_google_maps, driver);
		logger.loginfo(log,"view_on_google_maps is clicked successfully");
	}
	
	public static void google_location(WebDriver driver)
	{
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
				String child=it.next();
				if(!parent.equals(child))
				{
				driver.switchTo().window(child);
		       String name= driver.getTitle();
		       Assert.assertEquals(name,"Urban Ladder - Google Maps");
		       logger.loginfo(log,"Google map title is valid successfully");
		        System.out.println(name);
				}
		}
		 driver.switchTo().window(parent);
	}
	public static boolean addtocart_address(WebDriver driver) throws InterruptedException
	{
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext())
		{
				String child=it.next();
				if(!parent.equals(child))
				{
				driver.switchTo().window(child);
				reusablemethods.click(UI_list_products.add_to_cart, driver);
				logger.loginfo(log,"Add to cart is clicked successfully");
				//boolean result=driver.findElement(UI_list_products.checkout).isDisplayed();
				reusablemethods.click(UI_list_products.checkout, driver);
				logger.loginfo(log,"Checkout is clicked successfully");
				Thread.sleep(2000);
				reusablemethods.click(UI_list_products.save_and_continue, driver);
				logger.loginfo(log,"save and continue is clicked successfully");
				reusablemethods.click(UI_list_products.place_order, driver);
				logger.loginfo(log,"Place order is clicked successfully");
				}
		}		
		driver.switchTo().window(parent);
		return true;
	}
	
	public static void user_stories_count(WebDriver driver)
	{
		List<WebElement> list=driver.findElements(UI_list_products.user_stories_list);
		int a=list.size();
		logger.loginfo(log,"a + count inuser stories ");
		System.out.println("Customer stories list in the webpage"  +a);
	}
	public static void andriod_button(WebDriver driver)
	{
		reusablemethods.click(UI_list_products.andriod, driver);
		logger.loginfo(log, "Appstore is clicked");
		driver.navigate().back();
		reusablemethods.click(UI_list_products.android_app, driver);
		logger.loginfo(log, "Andriod app is clicked");
		
	}
	public static void verify_android(WebDriver driver)
	{
		String name=reusablemethods.findElement(UI_list_products.andriod_app_verify, driver).getText();
		Assert.assertEquals(name, "Urban Ladder - Furniture Store");
	}
	
	
		
	}

	
