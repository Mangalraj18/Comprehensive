package com.mindtree.runner;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.mindtree.pageOfObjects.Homepage;
import com.mindtree.pageOfObjects.List_of_products_page;
import com.mindtree.reusablecomponents.reusabledriver;
import com.mindtree.reusablecomponents.reusablemethods;
import com.mindtree.utility.ExcelReader;
import com.mindtree.utility.Propertyfilereader;
import com.mindtree.utility.logger;


public class TestRunner extends reusabledriver
{
	public static Logger log=LogManager.getLogger( TestRunner.class.getName());
	
@BeforeMethod()
public void load_browser()
{
	
	reusabledriver.driver();
	reusablemethods.loadurl(driver);
	reusablemethods.timelapse(driver);
}
@Test(priority=0)
public void login()
{
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
	}
	catch(Exception e)
	{
		logger.logerror(log,"Login is not clicked");
		reusabledriver.captureScreen("Login");
	}
}
	
	
@Test(priority=1, dataProvider="data_get")
public void add_to_cart(String product_name,String product_brand_name) throws InterruptedException
{	
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
    Homepage.search(driver,product_name);
    List_of_products_page.product_search(driver,product_brand_name);	
    List_of_products_page.addtocart(driver);
    logger.loginfo(log, "Product Successfully added to cart");
	}
	catch(Exception e)
	{
		logger.logerror(log, "Product not added to cart");
		reusabledriver.captureScreen("add to cart");
	}
}
@Test(priority=2)
public void offers() throws InterruptedException
{	
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
	Thread.sleep(1000);
	Homepage.sale_menu_bar(driver);
	List_of_products_page.price_range(driver);	
	Thread.sleep(1000);
	List_of_products_page.low_high(driver);
	logger.loginfo(log, "Product successfully filtered");
	}
	catch(Exception e)
	{
		logger.logerror(log, "Price not filtered");
		reusabledriver.captureScreen("price_filter");
	}
}


@Test(priority=3, dataProvider="data_get")
public void moveto_window_homepage(String product_name,String product_brand_name) throws InterruptedException
{
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
	Homepage.search(driver,product_name);
    List_of_products_page.product_search(driver,product_brand_name);	
    List_of_products_page.move_to__addtocart_page(driver);
    List_of_products_page.validation_title(driver);
    logger.loginfo(log, "Grabbed the price of product and returned to homepage");
	}
	catch(Exception e)
	{
		logger.loginfo(log, "Not returned to homepage and not grabbed the price details");
		reusabledriver.captureScreen("not_grab_the_price");
	}
}

//Verify stores offline location with google map
@Test(priority=4)
public void stores_offline_address() throws InterruptedException
{
	try
	{
   Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
   Homepage.stores(driver);
   List_of_products_page.stores_map(driver);
   List_of_products_page.google_location(driver);
   logger.loginfo(log, "Google location has showed for particular location");
	}
	catch(Exception e)
	{
		logger.logerror(log, "Google location has not showed for that particular location");
		reusabledriver.captureScreen("stores");
	}
}

//Payment page
@Test(priority=5, dataProvider="data_get")
public void payment_page(String product_name,String product_brand_name) throws InterruptedException
{	
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
	Homepage.search(driver,product_name);
    List_of_products_page.product_search(driver,product_brand_name);	
    List_of_products_page.addtocart_address(driver);
    logger.loginfo(log,"Payment page has showed");
	}
	catch(Exception e)
	{
		logger.logerror(log, "Payement has not showed");
		reusabledriver.captureScreen("payment");
	}
}

@Test(priority=6)
public void customer_stories()
{
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
	Homepage.user_stories_(driver);
	List_of_products_page.user_stories_count(driver);
	}
	catch(Exception e)
	{
		reusabledriver.captureScreen("user_stories");
		logger.logerror(log, "customer stories");
	}
}


@Test(priority=7)
public void wishlist() throws InterruptedException
{
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
    Homepage.select(driver);
    Homepage.selectproduct(driver, "Kaira Study Lamp");
    Homepage.child(driver);
    Homepage.add_wish(driver);
    logger.loginfo(log, "Produt added to wishlist");
	}
	catch(Exception e)
	{
		reusabledriver.captureScreen("wishlist");
		logger.logerror(log,"Product is not added to wishlist");
	}
}
@Test(priority=8)
public void subscribe() throws InterruptedException
{
	try
	{
	Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
    Homepage.subscribe(driver,Propertyfilereader.propfile().getProperty("email_id"));
	}
	catch(Exception e)
	{
		reusabledriver.captureScreen("subscription");
		logger.logerror(log, "Subscription error");
	}
}

	@Test(priority=9)
	public void android_app()
	{
		try
		{
		Homepage.login_page(driver,Propertyfilereader.propfile().getProperty("email_id"),Propertyfilereader.propfile().getProperty("password"));
		Homepage.stores(driver);
		List_of_products_page.andriod_button(driver);
		List_of_products_page.verify_android(driver);
		logger.loginfo(log, "Andriod app is clicked");
		}
		catch(Exception e)
		{
			logger.logerror(log, "Andriod app is not clicked");
		}
	}
		
  





@DataProvider
public Object[][] data_get() throws IOException
{
	Object[][] data=ExcelReader.getexceldata(Propertyfilereader.getSheetName());
	return data;
}
  
@AfterMethod
public void close_browser()
{
	driver.quit();
}
}