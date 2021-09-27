package com.mindtree.uistore;

import org.openqa.selenium.By;

public class homepageui 
{
   public static By log_in=By.cssSelector("[data-gaaction=\"show_login\"]");
   public static By email_box=By.xpath("//input[@class='email required input_authentication']");
   public static By password_box=By.xpath("//input[@placeholder='Password']");
   //public static By email_box=By.xpath("html/body/div[5]/div/div[1]/div/div[2]/div[3]/form/div/input");
  // public static By password_box=By.xpath("/html/body/div[5]/div/div[1]/div/div[2]/div[3]/form/div/div/div/input");
   public static By login_button=By.id("ul_site_login");
   public static By search_box=By.id("search");
   public static By saale_list=By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[1]/span");
   //public static By sale_list=By.xpath("/html/body/div[1]/header/div[2]/div/nav/div/ul/li[1]");
   public static By offer_30=By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[1]/div/div/ul/li[2]/ul/li[2]/a");   
   public static By stores_ui=By.cssSelector("[href=\"../../furniture-stores?src=header\"]");
   public static By user_stories=By.cssSelector("[href=\"/reviews-testimonials?src=g_custstorwdgt\"]");
   public static By gift_card=By.xpath("//ul[@class=\"_19wbI\"]/li[3]");
   //Test-9
    public static By study=By.cssSelector(".topnav_item.studyunit");
    public static By study_lamp=By.cssSelector("[href='/study-lamps?src=g_topnav_study_study-lamps_study-lamps']");
    public static By recom_mouseover=By.xpath("//span[contains(text(),'Recom')]");
	public static By new_arrival=By.cssSelector("[data-key='new_arrival']");
	
	//public static By select=By.xpath("//span[contains(text(),'Kaira Study Lamp ')]");
	public static By product_name1=By.xpath("//span[contains(text(),'Lamp')]");
    public static By wishtext=By.cssSelector(".wishtext");
	
	public static By verify=By.cssSelector("[class='icofont wishicon icofont-heart_fill selected']");
	

	public static By subscribe_key=By.id("email_id");
	public static By subscribe_button=By.cssSelector("[value=\"SUBSCRIBE\"]");
	public static By text_msge=By.xpath("/html/body/div[1]/footer/div[1]/div/div");
}
   
   ///html/body/div[5]/div/div[1]/div/div[2]/div[3]/form/div/input

