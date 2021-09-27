package com.mindtree.uistore;
import org.openqa.selenium.By;
public class UI_list_products 
{
	//Test =1
	public static By produts_image=By.className("product-img");
	public static By product_name=By.cssSelector("[itemprop=\"name\"]");
	public static By add_to_cart=By.id("add-to-cart-button");
	public static By checkout=By.id("checkout-link");
	
	//Test=2
	public static By filter=By.xpath("//*[@id=\"filters-form\"]/div[1]/div/div/ul/li[2]/div[1]");
	public static By price_range=By.id("price_limit_1259-13257");	
	public static By price_offer=By.className(".listing-discount-ribbon-content");
	public static By product_img=By.className(".product-img");
	public static By price_filter=By.xpath("//*[@id=\"content\"]/div[2]/div[1]/div/div/div/div/div[2]/div[1]");
	public static By  price_filter_low_to_high=By.xpath("//ul[@class=\"sortoptions\"]/li[2]");

	
	//Test=3
	public static By compare=By.cssSelector("[class=\"button button-with-border add-to-compare\"]");
	public static By recommanded=By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/div/div/div[2]/div[1]");
	
	//Test=4
	public static By product_price=By.cssSelector("[class=\"price discounted-price\"]");
	public static By homepage_buttob=By.className("logo-with-gradient");
	
	//Test =5
	public static By product_image_mumbai=By.cssSelector("[href=\"/furniture-stores/mumbai/bandra?src=stores_listing\"]");
    public static By view_on_google_maps=By.cssSelector("[href=\"https://goo.gl/maps/R8u24fcUpG3Vsawn9\"]");	
	
    
    //Test=6
    
    public static By save_and_continue=By.id("address-form-submit");
    public static By place_order=By.cssSelector("[value=\"Place Order\"]");
    
    //Test=7
    public static By user_stories_list=By.className("timgtag");
    
    public static By andriod=By.cssSelector("[src=\"/deadpul-public/assets/images/app-store-badge.dfda0.svg\"]");
    
    public static By android_app=By.cssSelector("[src=\"/deadpul-public/assets/images/play-store-badge.23212.svg\"]");
    public static By andriod_app_verify=By.xpath("//span[contains(text(),'Urban Ladder - Furniture Store')]");
}
