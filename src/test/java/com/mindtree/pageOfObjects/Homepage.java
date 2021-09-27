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
import com.mindtree.uistore.homepageui;
import com.mindtree.utility.logger;

public class Homepage 
{
	public static Logger log=LogManager.getLogger(Homepage .class.getName());
    public static boolean login_page(WebDriver driver, String email_id, String password) throws InterruptedException
    {
    	Thread.sleep(10000);
    	if(reusablemethods.click(homepageui.log_in, driver))
    	{
    	if(reusablemethods.click(homepageui.email_box, driver))
    	{
    	if(reusablemethods.sendkeys(homepageui.email_box, email_id, driver))
    	{
    	if(reusablemethods.click(homepageui.password_box, driver))
    	{
    	if(reusablemethods.sendkeys(homepageui.password_box, password, driver))
    	{
    	if(reusablemethods.click(homepageui.login_button, driver))
    		logger.loginfo(log,"Login successfully");
    		return true;
    	}
    	}
    	}
    	}
    	}
    	return false;
    }
    public static boolean search(WebDriver driver ,String value)
    {
    	if(reusablemethods.click(homepageui.search_box, driver))
    	   {
    	if(reusablemethods.sendkeys(homepageui.search_box, value, driver))
    	{
    	if(reusablemethods.enter(homepageui.search_box, driver))
    		logger.loginfo(log,"Product searched successfully");
    		return true;
    	}
    	   }
    	return false;
    	
    }
    
    public static boolean sale_menu_bar(WebDriver driver) throws InterruptedException
    {
    	if(reusablemethods.actions_mouseover(homepageui.saale_list, driver))
    	{
    	Thread.sleep(1000);
    	if(reusablemethods.click(homepageui.offer_30, driver))
    	{
    		return true;
    	}
    	}
    	return false;
    }
    
    public static boolean stores(WebDriver driver)
    {
    	if(reusablemethods.click(homepageui.stores_ui, driver))
    	{
    		logger.loginfo(log,"Stores clicked successfully");
    		return true;
    	}
    	return false;
    }
    public static boolean user_stories_(WebDriver driver)
    {
    	if(reusablemethods.click(homepageui.user_stories, driver))
    	{
    		logger.loginfo(log,"User stories clicked successfully");
    		return true;
    	}
    	return false;
    }
    
    public static boolean gift_card(WebDriver driver) throws InterruptedException
    {
    	Thread.sleep(1000);
    	if(reusablemethods.clear(homepageui.gift_card, driver));
   
    	return true;
    }
    public static void select(WebDriver driver)
	{
		reusablemethods.actions_mouseover(homepageui.study, driver);
		
		reusablemethods.click(homepageui.study_lamp, driver);
		

		reusablemethods.actions_mouseover(homepageui.recom_mouseover, driver);
		
		reusablemethods.actions_click(homepageui.new_arrival, driver);
		
	}
	
	public static void selectproduct(WebDriver driver, String value) 
	{
		
		//reusablemethods.actionclick(Wishlistui.select, driver);
		List<WebElement>products_list =driver.findElements(homepageui.product_name1);
	    for(int i=0;i<products_list.size();i++)
	    {
	    	String name=driver.findElements(homepageui.product_name1).get(i).getText();
	    	System.out.println(name);
	    	if(name.equals(value))
	    	{
	    		System.out.println("valid "+ name);
	    		driver.findElements(homepageui.product_name1).get(i).click();
	    		break;
	    	}
	}
	}

	
	public static String child(WebDriver driver) {
		Set<String> b=driver.getWindowHandles();
		Iterator<String> c=b.iterator();
		String parent =c.next();
		String Child =c.next();
		driver.switchTo().window(Child);
		String title=driver.getTitle();
		return title;
	}
	
	public static boolean add_wish(WebDriver driver)
	{
		reusablemethods.click(homepageui.wishtext, driver);
		
		Boolean value=reusablemethods.findElement(homepageui.verify, driver).isDisplayed();
		return value;
	}
	
	public static void subscribe(WebDriver driver,String email) throws InterruptedException
	{
		reusablemethods.click(homepageui.subscribe_key, driver);
		reusablemethods.sendkeys(homepageui.subscribe_key, email, driver);
		reusablemethods.click(homepageui.subscribe_button, driver);	
		String msge=reusablemethods.findElement(homepageui.text_msge, driver).getText();
	   Thread.sleep(1000);
		Assert.assertEquals(msge, "  SIGN UP AND GET A CHANCE TO WIN THE GIVEAWAY OF THE WEEK.");
	}
    
}
