package com.mindtree.reusablecomponents;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class reusabledriver 
{
	public static WebDriver driver;
	public static WebDriver driver()
	{
		String value=com.mindtree.utility.Propertyfilereader.browsername();
		if(value.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",com.mindtree.utility.Propertyfilereader.getChromePath());
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		 driver=new ChromeDriver(options);	
		}
		 else if(value.equalsIgnoreCase("edge"))
		   {
			   System.setProperty("webdriver.edge.driver",com.mindtree.utility.Propertyfilereader.getEdge());
				 driver=new EdgeDriver();
		   }
		   else
		   {
		     System.setProperty("webdriver.gecko.driver",com.mindtree.utility.Propertyfilereader.getFirefoxPath());
			 driver=new FirefoxDriver();
			
		   }
		 driver.manage().window().maximize();
		 return driver;
	}
	 public static void captureScreen(String tname) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File( ".\\Screenshots\\" + tname + ".png");
			try {
				FileUtils.copyFile(source, target);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			System.out.println("Screenshot taken");
		}	
}



/* public static void search(WebDriver driver,String product) {
		
	    	reusablemethods.click(Search_verifyui.search_box, driver);
	    	reusablemethods.sendkeys(Search_verifyui.search_box,product, driver);
	    	reusablemethods.enter(Search_verifyui.search_box, driver);
	    	
	    }
	
	public static void compare(WebDriver driver)
	{
		reusablemethods.action(Compareui.recom_mouseover, driver);
		reusablemethods.actionclick(Compareui.low_to_high, driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Compareui.firstproduct));
		reusablemethods.action(Compareui.firstproduct, driver);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(Compareui.firstproduct));
		reusablemethods.click(Co…
[8:54 PM, 9/24/2021] Tamilmaran Mindtree 2: pageobject
[8:54 PM, 9/24/2021] Tamilmaran Mindtree 2: public static By recom_mouseover=By.xpath("//span[contains(text(),'Recom')]");
	public static By low_to_high=By.cssSelector("[data-key='price_desc']");
	public static By firstproduct=By.cssSelector("[data-id='98114']");
	public static By secondproduct=By.cssSelector("[data-id='30865']");
	
	public static By frstcompare=By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[3]/ul/li[1]/div/div[5]/a[1]");
	
	public static By secondcompare=By.xpath("//*[@id=\"search-results\"]/div[3]/ul/li[2]/div/div[5]/a[1]");
	
	public static By compare_button=By.id("compare-cta");
	
	public static By close=By.xpath("//a[@class='close-reveal-modal close-overlay']");
	
	public static By title=By.xpath("//img[@alt='Urban Ladder - Online furniture store']");*/
