package Tests;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MainBase.baseTest;
import Pages.homepage;

public class Searchproduct extends baseTest{

	public homepage home;
	
	public Searchproduct() throws IOException {
		super();
	}

	@BeforeMethod
	public void initialize() {
		init();
	}
	
	@Test(priority=1,description="Login and search Product and Filtering the result")
	public void ProductSearchandFilter() throws IOException, InterruptedException {
		
		home=new homepage();
		home.login(prop.getProperty("username"),prop.getProperty("password"));
		home.Product_Search(prop.getProperty("itemname"));
		int result=home.Searched_result_count();
		System.out.println(result);
		home.Product_filters();
	}
	
	@Test(priority=2,description="Adding and Removing Items from the Shopping Cart")
	public void AddingandRemovingItemsfromtheShoppingCart() throws IOException, InterruptedException {
		home=new homepage();
		home.login(prop.getProperty("username"),prop.getProperty("password"));
		home.Product_Search(prop.getProperty("itemname"));
		home.AddToproductTocart();
		home.removeproductfromcart();
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}